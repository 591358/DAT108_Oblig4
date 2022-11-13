package no.hvl.dat108.util;

public class InputValidator {
	  	public static final String ANY_LETTER = "[a-zA-ZæøåÆØÅ]";
	  	
	    public static final String ANY_LETTER_OR_DIGIT_AND_ALLOWED_SPECIAL_CHARS = "[a-zA-ZæøåÆØÅ0-9!._@]";
	    public static final String EXACTLY = "{8,8}";

	   /**
	    * Sjekker om mobilnummeret har gyldig format
	    * @param mobil - mobilnummeret vi vil sjekke
	    * @return true om gyldig, false ellers
	    */
	    public static boolean isValidMobil(String mobil) {
	        return mobil != null && mobil.matches("^" + "[0-9]" + EXACTLY + "$");
	    }
	    /**
	     * Sjekker om passord har gyldig format
	     * @param passord
	     * @return true om gyldig, false ellers
	     */
	    public static boolean isValidPass(String passord) {
	        return passord != null && passord.matches("^" + ANY_LETTER_OR_DIGIT_AND_ALLOWED_SPECIAL_CHARS + "{2,}" +"$");
	    }
	    /**
	     * Sjekker om mobil og passord har gyldig format
	     * @param mobil - mobilnummeret brukeren skriver inn
	     * @param passord - passordet brukeren skriver inn
	     * @return false om en eller begge er ugyldig, true ellers
	     */
	    public static boolean gyldigeLogginVerdier(String mobil, String passord) {
	    	return isValidMobil(mobil) && isValidPass(passord);
	    }
}
