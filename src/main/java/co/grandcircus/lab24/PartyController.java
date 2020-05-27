package co.grandcircus.lab24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import co.grandcircus.lab24.dao.PartiesDao;
import co.grandcircus.lab24.entity.SortByVotes;
import co.grandcircus.lab24.dao.PartyOptionRepository;
import co.grandcircus.lab24.dao.PartyOptionsDao;
import co.grandcircus.lab24.dao.PartyRepository;
import co.grandcircus.lab24.entity.PartyOption;

@Controller
public class PartyController {
	
	@Autowired
	private PartyRepository partyRepository;
	
	@Autowired
	private PartyOptionRepository partyOptionRepository;
	
	@Autowired
	private PartiesDao partiesDao;
	
	@Autowired
	private PartyOptionsDao partyOptionsDao;
	
	@RequestMapping("/vote")
	public String votePage (
			Model model
			) {
		
		List<PartyOption> optionList = partyOptionsDao.findAll();
		
		//sort the list using comparator
		Collections.sort(optionList, new SortByVotes());
		
		model.addAttribute("optionList", partyOptionsDao.findAll());
		
		return "vote";
	}
	
	@RequestMapping("/vote/add-vote")
	public String addVote(
			@RequestParam String id
			) {
		
		List<PartyOption> partyOptions = partyOptionsDao.findAll();
		
		for (PartyOption option: partyOptions) {
			if (id.equals(option.getId() + "")) {
				option.setVotes(option.getVotes() + 1);
				partyOptionsDao.save(option);
			}
		}
		
		return "redirect:/vote";
	}
	
	@RequestMapping("/vote/add-option")
	public String addOption(
			@RequestParam(value="name") String name,
			@RequestParam(value="description") String description
			) {
		
		//Create new option
		PartyOption option = new PartyOption(name, description);
		
		//Save to table
		partyOptionsDao.save(option);
		
		return "redirect:/vote";
	}
	
	@RequestMapping("/review")
	public String reviewPage(Model model) {
		
		List<PartyOption> optionList = partyOptionsDao.findAll();
		
		//sort the list using comparator
		Collections.sort(optionList, new SortByVotes());
		
		//give to jsp page
		model.addAttribute("optionList", optionList);
		
		return "review";
	}
	
}
