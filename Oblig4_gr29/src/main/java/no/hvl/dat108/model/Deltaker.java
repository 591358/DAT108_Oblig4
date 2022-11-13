package no.hvl.dat108.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import no.hvl.dat108.util.PassordUtil;

@Entity
@Table(schema = "deltaker")
public class Deltaker {

	@NotNull(message = "Field cannot be empty")
	@Size(min = 2, max = 20, message = "Must be between 2 and 20 characters")
	@Pattern(regexp = "^[A-ZÆØÅ ]+[-A-ZÅØÆa-zæøå ]{2,19}$", message = "Must start with a capital letter")
	private String fornavn;
	
	@NotNull(message = "Field cannot be empty")
	@Size(min = 2, max = 20, message="Must be bewtween 2 and 20 characters")
	@Pattern(regexp = "^[A-ZÆØÅ]+[-A-ZÅØÆa-zæøå]{2,19}$", message = "Must start with a capital letter")
	private String etternavn;
	
	
	@Id
	@NotNull(message = "Field cannot be empty")
	@Size(min = 8, max=8, message="Must be 8 digits")
	@Column(unique=true)
	private String mobil;
	
	
	@Size(min=6, message="Must be at least 6 characters long")
	@NotNull(message = "Field cannot be empty")
	@Pattern(regexp="(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{6,}", message="Must be atleast 6 characters long, and should contain both lower- and uppercase aswell as a number")
	private String passord;
	
	@Size(min=6, message="Must be at least 6 characters long")
	@NotNull(message = "Field cannot be empty")
	@Pattern(regexp="(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{6,}", message="Must be atleast 6 characters long, and should contain both lower- and uppercase aswell as a number")
	private String passordrepetert;
	
	@NotNull(message = "Field cannot be empty")
	private String kjonn;
	
	private String salt;
	
	
	public Deltaker(){	
	}
	
	public Deltaker(String fornavn, String etternavn, String mobil, String passord, String passordrepetert,
			String kjonn) {
		super();
		this.salt = PassordUtil.genererTilfeldigSalt();
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.mobil = mobil;
		this.passord = PassordUtil.hashMedSalt(passord, salt);
		this.passordrepetert = PassordUtil.hashMedSalt(passord, salt);
		this.kjonn = kjonn;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getPassordRepetert() {
		return passordrepetert;
	}

	public void setPassordRepetert(String passordRepetert) {
		this.passordrepetert = passordRepetert;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	
}
