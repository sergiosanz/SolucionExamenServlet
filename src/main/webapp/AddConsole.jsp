<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Form of console</title>
	</head>
	<body>
		<form action="addConsole" method="post">
			<span>Name:</span> 
			<input type="text" name="name">
			<br/>
			<span>Company:</span> 
			<input type="text" name="companyId">
			<br/>
			<input type="submit">
		</form>
	</body>
</html>