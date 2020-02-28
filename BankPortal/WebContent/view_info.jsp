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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Display</title>
</head>
<body>
	<h3 align="center" style="margin-top: 80px">Account Details</h3>
	<%
		Account acc = new Account();
		acc = (Account) request.getAttribute("obj");
	%>
	<table class="table table-bordered" align="center" border="1" style="margin-top: 40px" width="250px">
		<tr>
			<td><b>Account Number</b></td><td> <%=acc.getAccount_id()%> <br></td>
		</tr>
		<tr>
			<td><b>Account type</b> </td><td><%=acc.getAcc_type()%><br></td>
		</tr>
		<tr>
			<td><b>Customer ID </b></td><td> <%=acc.getCustomerid()%><br></td>
		</tr>
		<tr>
			<td><b>Balance (Rs)</b> </td><td> <%=acc.getBalance()%></td>
		</tr>

		</tr>
	</table>


<div class="row" align="center" style="margin-top: 20px">
  <div class="col-xs-4" align="right">
	<form action="Controller" method="post">
		<input type="submit" class="btn btn-success" value="Deposit"> <input type="hidden"
			name="accid" value=<%=acc.getAccount_id()%>> <input
			type="hidden" name="balance" value=<%=acc.getBalance()%>>
			<input type="hidden"  value=<%=acc.getCr()%> disabled>
			 <input
			type="hidden" name="action" value="deposite">

	</form>
	</div>

	<div class="col-xs-4" align="center">
	<form action="Controller" method="post">
		<input type="submit" class="btn btn-success"  value="Withdraw"> <input type="hidden"
			value=<%=acc.getAccount_id()%> name="accid">
			 <input
			type="hidden" value=<%=acc.getBalance()%> name="balance">
			 <input type="hidden" value=<%=acc.getAcc_type()%> name="type">
			 <input type="hidden"  value=<%=acc.getCr()%> disabled>
			  <input type="hidden" name="action" value="withdraw">

	</form>
	</div>
	
	<div class="col-xs-4" align="left">
	<form action="Controller" method="post">
		<input type="submit" class="btn btn-success"  value="Transfer"> <input type="hidden"
			value=<%=acc.getAccount_id()%> name="accid">
						 <input type="hidden" value=<%=acc.getAcc_type()%> name="type">
						 <input type="hidden"  value=<%=acc.getCr()%> disabled>
			 <input type="hidden" value=<%=acc.getBalance()%> name="balance">
			  <input type="hidden" name="action" value="transaction">

	</form>
	</div>
	</div>
</body>
</html>