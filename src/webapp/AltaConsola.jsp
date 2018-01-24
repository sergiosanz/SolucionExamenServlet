<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Alta Consola</title>
	</head>
	<body>
		<form action="altaConsola" method="post">
			<label>Nombre de la consola</label>
			<input type="text" name="nameConsole">
			<label>Nombre de la compañia</label>
			<input type="text" name="nameCompanyConsole">
			<input type="submit" value="Crear Consola">	
		</form>
	</body>
</html>