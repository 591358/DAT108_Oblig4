<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<!-- saved from url=(0032)http://localhost:8080/innlogging -->
<html>
<head>

<link rel="stylesheet" type="text/css" href="/CSS/simple.css" />
<title>Logg inn</title>
</head>
<body>
	<h2>Logg inn</h2>
	<p style="color:red;"></p>
	<form method="post" action="innlogging">
		<fieldset>
			<p style="color:red">${redirectMessage}</p>
			<label for="mobil">Mobil:</label>
			<input id="mobil" name="mobil" title="Må være nøyaktig 8 siffer" pattern=".{8,8}"
				placeholder="Skriv inn mobil nummer.."required="required" type="text"
				value=""  />
			<br>
			<label for="passord">Passord:</label>
			<input id="passord" name="passord" title="Må være mer enn 6 karakterer lang" pattern=".{6,}"
				placeholder="Skriv inn passord..." type="password" required="required"
				value="" />
			<br><br><button type="submit">Logg inn</button>
		</fieldset>
	<a href="paamelding">Ny bruker?</a>
	</form>

</body>

</html>