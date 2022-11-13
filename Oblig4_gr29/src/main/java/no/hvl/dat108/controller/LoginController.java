package no.hvl.dat108.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat108.model.Deltaker;
import no.hvl.dat108.model.DeltakerRepo;
import no.hvl.dat108.util.InputValidator;
import no.hvl.dat108.util.LoginUtil;
import no.hvl.dat108.util.PassordUtil;



@Controller
public class LoginController {
	@Autowired 
	private DeltakerRepo deltakerRepo;
   
	@GetMapping(value="/")
	public String login() {
		return "innlogging";
	}

	@PostMapping(value="/innlogging")
	public String loginAttempt(@RequestParam String passord, @RequestParam String mobil, HttpServletRequest request, RedirectAttributes ra,
			HttpSession session) {
		
		if(!InputValidator.gyldigeLogginVerdier(mobil,passord)) {
			ra.addFlashAttribute("redirectMessage", "Ugyldig input verdi, lovlige spesial tegn er !._@");
			return "redirect:/";
		}
		//Sjekker i databasen om det eksisterer en bruker med samme mobil nummer, hvis det gjør det finner den brukeren og sjekker passordet
		if(deltakerRepo.existsByMobil(mobil)) {
			Deltaker deltaker= deltakerRepo.findByMobil(mobil);
			if(!PassordUtil.validerMedSalt(passord, deltaker.getSalt(), deltaker.getPassord())){
				ra.addFlashAttribute("redirectMessage", "Feil passord");
				return "redirect:/";
			}
		}else {
			ra.addFlashAttribute("redirectMessage", "Ingen brukere med det nummeret");
			return "redirect:/";
		}
		//brukeren finnes, og passordet stemmer, vi logger inn brukeren.
		
		LoginUtil.logInUser(request,mobil, passord);
		return "redirect:deltakerliste";
	}

	
	@PostMapping(value="inlogging")
	public String nyBruker() {
		return "redirect:nyPaamelding";
	}
	
	
	
}
