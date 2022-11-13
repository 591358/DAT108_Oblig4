package no.hvl.dat108.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import no.hvl.dat108.model.Deltaker;
import no.hvl.dat108.model.DeltakerRepo;

public class LoginUtil {

	@Autowired
	private  DeltakerRepo deltakerRepo;
	// Constant for the maximum allowed inactivity time
	private final static int MAX_INTERACTIVE_TIME = 100;

	/**
	 * This method will log in a user using a http request and a mobile number as
	 * username and a password.
	 * 
	 * @param request  - A HttpServletRequest
	 * @param mobil    - A mobile number, used as username
	 * @param password - A password entered by the user
	 */
	public static void logInUser(HttpServletRequest request, String mobil, String password) {
		// good practice to log a user out, if there already is a user logged in.
		logOutUSer(request.getSession());
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(MAX_INTERACTIVE_TIME);

		session.setAttribute("pass", password);
		session.setAttribute("mobil", mobil);
		
		session.setAttribute("loginUserMobil", mobil);
		session.setAttribute("erLoggetInn", mobil);
	}
	
	

	/**
	 * This method will log a user out by invalidatin the session.
	 * 
	 * @param session - the active session.
	 */
	public static void logOutUSer(HttpSession session) {
		session.invalidate();
	}

	/**
	 * This method will check whether or not the user is logged in the session
	 * 
	 * @param session
	 * @return true if logged in, false otherwise
	 */
	public static boolean isUserLoggedIn(HttpSession session) {
		return session != null && session.getAttribute("mobil") != null;
	}

}
