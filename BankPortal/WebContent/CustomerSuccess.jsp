<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file = "cashhead.jsp" %>
<%@ include file="footer.jsp"%>
<link rel="stylesheet" href="NewFile.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://afeld.github.io/emoji-css/emoji.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>
<div style="color:green;">
	<center><i class="em em-grinning" style="font-size:500%;margin-top: 80px"></i>
		<h2 align="center"
			style="position: fixed; top: 250px; left: 0px; right: 20px;"><%
		int id = Integer
				.parseInt((request.getAttribute("custid").toString()));
	%>

	Customer created successfully with Customer id
	<%=id%>
</h2></center>
	</div>
	
</body>
</html>