package no.hvl.dat108.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat108.model.Deltaker;
import no.hvl.dat108.model.DeltakerRepo;
import no.hvl.dat108.util.InputValidator;
import no.hvl.dat108.util.LoginUtil;
import no.hvl.dat108.util.PassordUtil;



@Controller
public class PaameldingController {

	@Autowired 
	private DeltakerRepo deltakerRepo;
	

	@GetMapping(value="/paamelding")
	public String getLogin(@ModelAttribute("deltaker") Deltaker deltaker, Model model) {
		model.addAttribute("deltaker", new Deltaker());
		return "paamelding";
	}
	@GetMapping(value="/nyPaamelding")
	public String dede(@ModelAttribute("deltaker") Deltaker deltaker, Model model) {
		return "redirect:paamelding";
	}
	
	@PostMapping(value="/paamelding")
	public String getdeltakerForms(@Valid @ModelAttribute("deltaker") Deltaker deltaker,BindingResult bs,
			HttpSession session, HttpServletRequest request, RedirectAttributes ra) {
		
		//Hvis passord eller mobil inneholder ugyldige verdier blir du sent tilbake til paameldingsiden.
		if(!InputValidator.gyldigeLogginVerdier(deltaker.getMobil(), deltaker.getPassord())) {
			ra.addFlashAttribute("ugyldiginput","Ugyldige input verdier ");
			return "redirect:paamelding";
		}
		
		//Sjekker om det allerede finnes en mobil registrert paa nummeret
		if(deltakerRepo.existsByMobil(deltaker.getMobil())) {
			ra.addFlashAttribute("ugyldiginput", "Det er allerede en bruker registrert med det nummeret!");
			return "redirect:paamelding";
		}
		if(bs.hasErrors()) {
			return "redirect:/";
		}
		
		//oppretter en "ny" deltaker, i prossessen blir passordet saltet og hashet
		deltaker = new Deltaker(deltaker.getFornavn(),deltaker.getEtternavn(),deltaker.getMobil(),
				deltaker.getPassord(),deltaker.getPassordRepetert(), deltaker.getKjonn());
		
		//vi kan naa lagre brukeren i databasen med passorder saltet og hashet, vi logger saa brukeren inn
		deltakerRepo.save(deltaker);
		LoginUtil.logInUser(request, deltaker.getMobil(), deltaker.getPassord());
		return "redirect:paameldt";
	}
}
