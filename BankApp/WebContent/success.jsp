<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Banking App</title>
</head>
<body>
	<div>
		<h3>Account created successfully</h3></br>
		<div>Account Name: ${requestScope.name} </br>
			Account No: ${requestScope.accNo}</div>	
		
	</div>
</body>
</html>