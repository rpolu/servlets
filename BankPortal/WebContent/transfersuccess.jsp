<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.bean.*"%>
<%@ include file = "header.jsp" %>
<%@ include file="footer.jsp"%>
<link rel="stylesheet" href="NewFile.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>
<form action="Controller" method="post">
	
	<%
	Account sourceacc = new Account();
	sourceacc = (Account) request.getAttribute("sourceacc");

	Account targetacc = new Account();
	targetacc = (Account) request.getAttribute("targetacc");

	String targetprevbal = request.getAttribute("targetprevbal")
			.toString();
	double targetprevbalance = Double.parseDouble(targetprevbal);

	String sourceprevbal = request.getAttribute("sourceprevbal")
			.toString();
	double sourceprevbalance = Double.parseDouble(sourceprevbal);
%>




		<div class="container">
 <table class="table">
    
      


		<tr>
			<th>Source Account ID </th><td> <%=sourceacc.getAccount_id()%></td>
		</tr>
		<tr>
			<th>Target Account ID </th><td> <%=targetacc.getAccount_id()%></td>
		</tr>
		<tr>
			<th>Balance before transfer for Source Account </th><td> <%=sourceprevbalance%></td>
		</tr>
		<tr>
			<th>Balance before transfer for Target Account </th><td> <%=targetprevbalance%></td>
		</tr>
		<tr>
			<th>Latest balance for Source Account </th><td><%=sourceacc.getBalance()%></td>
		</tr>
		<tr>
			<th>Latest balance for Target Account </th><td><%=targetacc.getBalance()%></td>
		</tr>
		<tr>
			</table></div>
		<center>
		<h4 style="color:green">Amount transfer completed successfully</h4>

	<input type="hidden" name="id" value=<%=sourceacc.getAccount_id()%>>
		<input type="hidden" name="balance" value=<%=sourceacc.getBalance()%>>
	
	<input type="submit"  class="btn btn-info" value="Back">
	<input type="hidden" name="action" value="backto">
	</center>
	
</form>
</body>
</html>