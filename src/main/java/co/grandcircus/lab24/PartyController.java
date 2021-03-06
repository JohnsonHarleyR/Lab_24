package co.grandcircus.lab24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import co.grandcircus.lab24.dao.PartiesDao;
import co.grandcircus.lab24.entity.SortByVotes;
import co.grandcircus.lab24.dao.PartyOptionRepository;
import co.grandcircus.lab24.dao.PartyOptionsDao;
import co.grandcircus.lab24.dao.PartyRepository;
import co.grandcircus.lab24.entity.Party;
import co.grandcircus.lab24.entity.PartyOption;

// I'm aware after going to part 3 that I likely should have created another controller
// on top of this one

// Stuff I need more practice on, yay :) (no really, I like it)

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
			@RequestParam("party") Long partyId,
			Model model
			) {
		
		List<PartyOption> optionList = partyOptionsDao.findByPartyId(partyId);
		
		model.addAttribute("party", partyId);
		model.addAttribute("optionList", optionList);
		
		return "vote";
	}
	
	//for the complete list
	@RequestMapping("/vote-all")
	public String votePage (
			Model model
			) {
		
		//Create list with all party options
		List<PartyOption> optionList = partyOptionsDao.findAll();
		
		
		//sort the list using comparator
		Collections.sort(optionList, new SortByVotes());
		
		model.addAttribute("optionList", partyOptionsDao.findAll());
		model.addAttribute("partyList", partiesDao.findAll());
		
		return "vote-all";
	}
	
	@RequestMapping("/vote/add-vote")
	public String addVote(
			@RequestParam(value="id") String id,
			@RequestParam(value="party") String partyId
			) {
		
		List<PartyOption> partyOptions = partyOptionsDao.findAll();
		
		for (PartyOption option: partyOptions) {
			if (id.equals(option.getId() + "")) {
				option.setVotes(option.getVotes() + 1);
				partyOptionsDao.save(option);
			}
		}
		
		return "redirect:/vote?party=" + partyId;
	}
	
	//for the complete list
	@RequestMapping("/vote-all/add-vote")
	public String addAllVote(
			@RequestParam String id
			) {
		
		List<PartyOption> partyOptions = partyOptionsDao.findAll();
		
		for (PartyOption option: partyOptions) {
			if (id.equals(option.getId() + "")) {
				option.setVotes(option.getVotes() + 1);
				partyOptionsDao.save(option);
			}
		}
		
		return "redirect:/vote-all";
	}
	
	@RequestMapping("/vote/add-option")
	public String addOption(
			@RequestParam(value="name") String name,
			@RequestParam(value="description") String description,
			@RequestParam(value="party") Long partyId
			) {
		//get list of parties
		List<Party> parties = partiesDao.findAll();
		
		//if the party matches the id
		for (Party party: parties) {
			if (party.getId() == partyId) {
				//Create new option
				PartyOption option = new PartyOption(name, description, party);
				
				//Save to table
				partyOptionsDao.save(option);
			}
		}
		
		return "redirect:/vote?party=" + partyId;
	}
	
	//for the complete list
	@RequestMapping("/vote-all/add-option")
	public String addAllOption(
			@RequestParam(value="name") String name,
			@RequestParam(value="description") String description,
			@RequestParam(value="party") Long partyId
			) {
		
		//get list of parties
		List<Party> parties = partiesDao.findAll();
		
		//if the party matches the id
		for (Party party: parties) {
			if (party.getId() == partyId) {
				//Create new option
				PartyOption option = new PartyOption(name, description, party);
				
				//Save to table
				partyOptionsDao.save(option);
			}
		}
		
		return "redirect:/vote-all";
	}
	
	@RequestMapping("/review")
	public String reviewPage(
			@RequestParam(value = "party") Long partyId,
			Model model) {
		
		List<PartyOption> optionList = partyOptionsDao.findByPartyId(partyId);
		
		//sort the list using comparator
		//I see now there's a sort.by() option too
		Collections.sort(optionList, new SortByVotes());
		
		//give to jsp page
		model.addAttribute("optionList", optionList);
		
		return "review";
	}
	
	//for the complete list
	@RequestMapping("/review-all")
	public String reviewPage(Model model) {
		
		//Create list with all party options
		List<PartyOption> optionList = partyOptionsDao.findAll();
		
		//sort the list using comparator
		Collections.sort(optionList, new SortByVotes());
		
		//give to jsp page
		model.addAttribute("optionList", optionList);
		model.addAttribute("partyList", partiesDao.findAll());
		
		return "review-all";
	}
	
	//Edit an option
	@RequestMapping("/edit")
	public String edit(
			@RequestParam(value = "option") Long optionId,
			Model model
			) {
		
		//Make list of options
		List<PartyOption> options = partyOptionsDao.findAll();
		//find optionId in list
		for (PartyOption opt: options) {
			if (opt.getId() == optionId) {
				//add that option to jsp
				PartyOption option = opt;
				model.addAttribute("option", option);
			}
		}
		
		return ("/edit");
	}
	
	//submit edit
		@RequestMapping("/edit-submit")
		public String editSubmit(
				@RequestParam(value = "optionId") Long optionId,
				@RequestParam(value = "name") String name,
				@RequestParam(value = "description") String description,
				Model model
				) {
			
			//set new properties
			List<PartyOption> options = partyOptionsDao.findAll();
			for (PartyOption option: options) {
				if (option.getId() == optionId) {
					option.setName(name);
					option.setDescription(description);
					partyOptionsDao.save(option);
					return ("redirect:/vote?party=" + option.getParty().getId());
				}
			}
			
			return ("redirect:/vote-all");
		}
	
	//In case the tables are empty.
	@PostConstruct
	public void preload() {
		//If there are no listed parties
		if (partyRepository.count() == 0) {
			//new party
			LocalDate date = LocalDate.of(2020, Month.OCTOBER, 13);
			Party party = new Party("Harley's Surprise Birthday", date);
			partyRepository.save(party);
			//new option for that party
			partyOptionRepository.save(new PartyOption("Pepperoni", "THE classic.", party));
		}
		
		//if there are no parties, there shouldn't be any options
	}
	
	
}
