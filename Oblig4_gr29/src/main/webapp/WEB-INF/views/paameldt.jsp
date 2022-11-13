<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<!-- saved from url=(0030)http://localhost:8080/paameldt -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/CSS/simple.css" />

<title>Påmeldingsbekreftelse</title>
</head>
<body>
	<h2>Påmeldingsbekreftelse</h2>
	<p>Påmeldingen er mottatt for</p>
	<p>
		${paameldtdeltaker.fornavn}<br>${paameldtdeltaker.etternavn}<br>
		${paameldtdeltaker.mobil}<br> ${paameldtdeltaker.kjonn}
	</p>
	<a href="deltakerliste">Gå til
		deltagerlisten</a>

</body>
</html>