package no.hvl.dat108.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import no.hvl.dat108.model.Deltaker;
import no.hvl.dat108.model.DeltakerRepo;
import no.hvl.dat108.model.DeltakerService;
import no.hvl.dat108.util.LoginUtil;

@Controller
public class DeltakerListeController {
	@Autowired 
	private DeltakerService deltakerService;
	 
	@Autowired 
	private DeltakerRepo deltakerRepo;
		
	
	@GetMapping(value="/deltakerliste")
	public String deltakerListe(HttpSession session, Model model) {
		if(!LoginUtil.isUserLoggedIn(session)) {
			return "redirect:/";
		}
		//Legger til den sortere listen av deltakerene allerede i databasen inn i modellen
		List<Deltaker> listDeltakere = deltakerService.sorterNavn();
		model.addAttribute("listdeltakere",listDeltakere);
		
		//Finner den innloggede brukeren og lagrer den i sesjonen
		Deltaker deltaker = deltakerRepo.findByMobil(session.getAttribute("erLoggetInn"));
		session.setAttribute("loginnDeltaker", deltaker);
		return "deltakerliste";
	}
	
	@PostMapping(value="logout")
	public String logout(HttpSession session) {
		LoginUtil.logOutUSer(session);
		return "redirect:/";
	}
}

