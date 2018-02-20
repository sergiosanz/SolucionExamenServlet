<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show list of videogames</title>
</head>
<body>
	<form action="listVideoGame" method="post">
		<input type="submit" value="show list">
	</form>
	<form action="OrderByTitle" method="post">
		<input type="submit" value="order list by title">
	</form>
	<form action="OrderByReleaseDate" method="post">
		<input type="submit" value="order list by release date">
	</form>
	<table border="1">
		<thead>
			<tr>
				<td>Name</td>
				<td>Age</td>
				<td>Release Date</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="videogame" items="${listAllVideoGame}">
				<tr>
					<td>
						<c:out value="${videogame.name}" />
					</td>
					<td>
						<c:out value="${videogame.age}" />
					</td>
					<td>
						<c:out value="${videogame.releaseDate}" />
					</td>
					<td>
						<c:out value="${videogame.companyId}" />
					</td>
					<td>
						<a href="/deleteVG?name=${videogame.name}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>