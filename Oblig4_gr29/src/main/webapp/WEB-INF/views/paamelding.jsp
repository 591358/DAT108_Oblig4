<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!-- saved from url=(0032)http://localhost:8080/paamelding -->
<html lang="no">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="/CSS/simple.css" />

<title>Påmelding</title>
</head>

<body>
	<h2>Påmelding</h2>
	
	<form:form id="deltagerFormBean" action="paamelding" method="post"
		modelAttribute="deltaker">
		<fieldset>
			<span style="color:red">${ugyldiginput}</span>
			<label for="fornavn">Fornavn</label>
			<!-- NB! Spring sin (form:input)-tag stÃ¸tter ikke required alene, 
			     men greit med required="noe"! -->
			<form:input id="fornavn" name="fornavn" title="Må starte med stor bokstav og være mellom 2 og 19 karakterer" pattern="^[A-ZÆØÅ ]+[-A-ZÅØÆa-zæøå ]{2,19}$"
				placeholder="Fyll inn fornavn" required="required" type="text"
				value="" path="fornavn" />
			<form:errors path="fornavn"></form:errors>

			<label for="etternavn">Etternavn</label>
			<form:input id="etternavn" name="etternavn" title="Må starte med stor bokstav og være mellom 2 og 19 karakterer" pattern="^[A-ZÆØÅ]+[-A-ZÅØÆa-zæøå]{2,19}$"
				placeholder="Fyll inn etternavn" required="required" type="text"
				value="" path="etternavn" />
			<form:errors path="etternavn" />


			<label for="mobil">Mobil (8 siffer)</label>
			<form:input id="mobil" name="mobil" title="Må være nøyaktig 8 siffer" pattern="\s*\+?\s*(\d\s*){8}\s*"
				placeholder="Fyll inn telefonnummer" required="required" type="text"
				value="" path="mobil" />
			<form:errors path="mobil" />


			<label for="passord">Passord</label>
			<form:input id="passord" name="passord" title="Må være mer enn 6 karakterer lang" pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{6,}"
				placeholder="Velg et passord" type="password" required="required"
				value="" path="passord" />
			<form:errors path="passord" />

			<label for="passordRepetert">Passord repetert</label>
			

			<form:input id="passordRepetert" name="passordRepetert" title="Passordene må være like"
				pattern=".{6,}" placeholder="Gjenta passord" type="password"
				required="required" value="" path="passordRepetert" />
			<form:errors path="passordRepetert" />

			<label for="kjonn">Kjønn:</label>
			<form:radiobutton id="M" name="M" checked="checked"
				value="M" path="kjonn" />
			mann
			<form:radiobutton id="K" name="K" value="K"
				path="kjonn" />
			kvinne <br> <br>
			<button type="submit">Meld meg på</button>
		</fieldset>
	</form:form>


</body>
	
<script src="/JS/script.js"></script>

</html>