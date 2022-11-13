<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deltakerliste</title>
<link rel="stylesheet" type="text/css" href="/CSS/simple.css" />

</head>
<body>
	<!-- Skriver ut den som er logget inn -->
	<p>Inlogget som ${loginnDeltaker.mobil} / ${loginnDeltaker.fornavn}
		${loginnDeltaker.etternavn}</p>
	<h2>Deltakerliste</h2>

	<table>
		<tbody>
			<tr>
				<th>Kjønn</th>
				<th align="left">Navn</th>
				<th align="left">Mobil</th>
			</tr>

			<!-- Går gjennom listen og skriver ut hver deltaker -->
			<c:forEach items="${listdeltakere}" var="deltaker">
				<tr bgcolor="${deltaker.mobil eq erLoggetInn ? '#228B22' : '#212121'}">
					<td><c:out value="${deltaker.kjonn}" /></td>
					<td><c:out value="${deltaker.fornavn} ${deltaker.etternavn}" /></td>
					<td> <c:out value="${deltaker.mobil}" /> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<!-- KNAPP FOR Å LOGGE UT-->
	<form action="logout" method="post">
		<fieldset>
			<p>
				<input type="submit" value="Logg ut" />
			</p>
		</fieldset>
	</form>

</body>
</html>