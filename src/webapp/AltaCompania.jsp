<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Alta Compania</title>
	</head>
	<body>
		<form action="altaCompania"method="post">
			<label>Nombre de la compania</label>	
			<input type="text" name="nameCompany">
			<label>Fecha de creacion (dd/mm/yyyy)</label>
			<input type="text" name="crationDateCompany">
			<input type="submit" value="Crear Compania">
		</form>
	</body>
</html>