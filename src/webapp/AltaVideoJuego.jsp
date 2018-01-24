<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Alta Videojuego</title>
	</head>
	<body>
		<form action="altaVideoJuego" method="post">
			<label>Titulo del videojuego</label>
			<input type="text" name="titleVideogame">
			<label>Edad del videojuego</label>
			<input type="text" name="ageVideogame">
			<label>Fecha de anzamiento del videojuego</label>
			<input type="text" name="RelDateVideogame">
			<input type="submit" value="Crear Videojuego">	
		</form>
	</body>
</html>