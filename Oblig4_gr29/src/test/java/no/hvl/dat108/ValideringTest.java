package no.hvl.dat108;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import no.hvl.dat108.model.Deltaker;
import no.hvl.dat108.model.DeltakerService;
import no.hvl.dat108.util.InputValidator;

public class ValideringTest {

	private String passord1 = "HeiAlleSammen";
	private String passord2 = "h";
	private String passord3 = "1233";
	private String passord4 = "Hei4022";
	private String passord5 = "";
	private String passord6 = "<style=";
	private String passord7 = "<_: ";

	private String mobil1 = "12345678";
	private String mobil2 = "123";
	private String mobil3 = "";
	private String mobil4 = "11111111";
	private String mobil5 = "12345678901234567";

	// Test med bokstaver og korrekt antall karakterer
	private String mobil6 = "abcdefge";
	private String mobil7 = "1234567e";
	private String mobil8 = "e1234567";

	@Test
	public void passordTest() {
		assertTrue(InputValidator.isValidPass(passord1));
		assertFalse(InputValidator.isValidPass(passord2));
		assertTrue(InputValidator.isValidPass(passord3));
		assertTrue(InputValidator.isValidPass(passord4));
		assertFalse(InputValidator.isValidPass(passord5));
		// Test for spesial symboler
		assertFalse(InputValidator.isValidPass(passord6));
		assertFalse(InputValidator.isValidPass(passord7));
	}

	@Test
	public void mobilTest() {
		assertTrue(InputValidator.isValidMobil(mobil1));
		assertFalse(InputValidator.isValidMobil(mobil2));
		assertFalse(InputValidator.isValidMobil(mobil3));
		assertTrue(InputValidator.isValidMobil(mobil4));
		assertFalse(InputValidator.isValidMobil(mobil5));
		assertFalse(InputValidator.isValidMobil(mobil6));
		assertFalse(InputValidator.isValidMobil(mobil7));
		assertFalse(InputValidator.isValidMobil(mobil8));
	}

	List<Deltaker> deltakerListe = List.of(
			new Deltaker("Arne","Arnesen","55555555",passord1,passord1,"M"),
			new Deltaker("Arne","Barne","33333333",passord2,passord2,"M"),
			new Deltaker("Arne","Karne","44444444",passord2,passord2,"M"),
			new Deltaker("Anne","Abel","22222222",passord2,passord2,"K"),
			new Deltaker("Kari","Siste","11111111",passord1,passord2,"K")
			);

	@Test
	public void sorteringTest() {
		assertEquals("Arne",deltakerListe.get(0).getFornavn());
		assertEquals("Arne",deltakerListe.get(1).getFornavn());
		assertEquals("Arne",deltakerListe.get(2).getFornavn());
		assertEquals("Anne",deltakerListe.get(3).getFornavn());
		assertEquals("Kari",deltakerListe.get(4).getFornavn());
		
		assertEquals("Arnesen",deltakerListe.get(0).getEtternavn());
		assertEquals("Barne",deltakerListe.get(1).getEtternavn());
		assertEquals("Karne",deltakerListe.get(2).getEtternavn());
		assertEquals("Abel",deltakerListe.get(3).getEtternavn());
		assertEquals("Siste",deltakerListe.get(4).getEtternavn());
		deltakerListe = DeltakerService.sorterNavnTest(deltakerListe);
		
		assertEquals("Anne",deltakerListe.get(0).getFornavn());
		assertEquals("Arne",deltakerListe.get(1).getFornavn());
		assertEquals("Arne",deltakerListe.get(2).getFornavn());
		assertEquals("Arne",deltakerListe.get(3).getFornavn());
		assertEquals("Kari",deltakerListe.get(4).getFornavn());
		
		assertEquals("Abel",deltakerListe.get(0).getEtternavn());
		assertEquals("Karne",deltakerListe.get(1).getEtternavn());
		assertEquals("Barne",deltakerListe.get(2).getEtternavn());
		assertEquals("Arnesen",deltakerListe.get(3).getEtternavn());
		assertEquals("Siste",deltakerListe.get(4).getEtternavn());
	}


}
