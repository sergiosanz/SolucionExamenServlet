<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulario de datos</title>
</head>
<body>
<form action="addVideogame" method="post">
		<span>Name:</span> 
		<input type="text" name="name"> <br/>
		<span>Recomended Age:</span> 
		<input type="text" name="age"><br/>
		<span>ReleaseDate:</span> 
		<input type="date" name="releaseDate"><br/>
		<input type="submit">
	</form>
	</body>
</html>