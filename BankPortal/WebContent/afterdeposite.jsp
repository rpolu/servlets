<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.bean.*"%>
<%@ include file = "header.jsp" %>
<%@ include file="footer.jsp"%>
<link rel="stylesheet" href="NewFile.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Deposit</title>
</head>
<body>
	<form action="Controller" method="post">
		<%
			Account acc = new Account();
			acc = (Account) request.getAttribute("obj");
			String before = request.getAttribute("beforeamt").toString();
			double beforeamt = Double.parseDouble(before);
		%>






		<div class="container">
 <table class="table">
			<tr>
				<th>Customer ID </th>
				<td> <%=acc.getCustomerid()%></td>
				
			</tr>
			<tr>
				<th>Account ID </th><td><%=acc.getAccount_id()%></td>
			</tr>
			<tr>
				<th>Balance before deposit </th><td> <%=beforeamt%></td>
			</tr>
			<tr>
				<th>Latest balance </th><td><%=acc.getBalance()%></td>
			</tr>
			<tr>
			</table>
		</div>
		
		<center>
				<h4 style="color:green">Amount deposited successfully...</h4>
		
		</center>
		
		<div class="form-group">
		<center>
		<input type="hidden" name="id" value=<%=acc.getAccount_id()%>>
		 <input type="hidden" name="balance" value=<%=acc.getBalance()%>>
		 <input type="submit"  class="btn btn-info" value="Back">
		 <input type="hidden" name="action" value="backto">
		 </center>
	</form>
</body>
</html>

