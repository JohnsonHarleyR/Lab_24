package co.grandcircus.lab24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.grandcircus.lab24.dao.PartiesDao;
import co.grandcircus.lab24.dao.PartyOptionRepository;
import co.grandcircus.lab24.dao.PartyOptionsDao;
import co.grandcircus.lab24.dao.PartyRepository;

@Controller
public class HomeController {
	
	@Autowired
	private PartyRepository partyRepository;
	
	@Autowired
	private PartyOptionRepository partyOptionRepository;
	
	@Autowired
	private PartiesDao partiesDao;
	
	@Autowired
	private PartyOptionsDao partyOptionsDao;
	
	@RequestMapping("/")
	public String home(Model model) {

		model.addAttribute("partyList", partiesDao.findAll());
		return "index";
	}
	
}
