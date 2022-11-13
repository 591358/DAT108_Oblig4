package no.hvl.dat108.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import no.hvl.dat108.model.Deltaker;
import no.hvl.dat108.model.DeltakerRepo;



@Controller
public class PaameldtKontroller {
	
	@Autowired 
	private DeltakerRepo deltakerRepo;
	

	@GetMapping(value="/paameldt")
	public String getPaamelding(HttpSession session,@ModelAttribute Deltaker deltaker) {
		Deltaker paameldtDeltaker = deltakerRepo.findByMobil(session.getAttribute("erLoggetInn"));
		
		session.setAttribute("paameldtdeltaker", paameldtDeltaker);
		return "paameldt";
	}
	

	@PostMapping(value="/paameldt")
	public String deltakerListe(HttpSession session) {
		return "redirect:deltakerliste";
	}
	
	
	
	
}
