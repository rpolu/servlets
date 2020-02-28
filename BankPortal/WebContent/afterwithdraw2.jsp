<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.bean.*"%>
<%@ include file="header.jsp"%>
<%@ include file="footer.jsp"%>
<link rel="stylesheet" href="NewFile.css">

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Withdraw</title>
</head>
<body>
	<form action="Controller">
		<%
			Account acc = new Account();
			acc = (Account) request.getAttribute("obj");
			String before = request.getAttribute("beforeamt").toString();
			double beforeamt = Double.parseDouble(before);
		%>


		<div class="container">
			<table class="table">






				<tr>
					<th>Customer ID</th>
					<td><%=acc.getCustomerid()%></td>
				</tr>
				<tr>
					<th>Account ID</th>
					<td><%=acc.getAccount_id()%></td>
				</tr>
				<tr>
					<th>Balance before withdraw</th>
					<td><%=beforeamt%></td>
				</tr>
				<tr>
					<th>Latest balance</th>
					<td><%=acc.getBalance()%></td>
				</tr>
				<tr>
					<td style="color: green">
						<h4 align="center">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
							&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
							&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Amount withdrawn successfully.</h4>
					</td>
				</tr>
			</table>
		</div>
		<input type="hidden" name="id" value=<%=acc.getAccount_id()%>>

		<input type="hidden" name="balance" value=<%=acc.getBalance()%>>
		<center>
			<input type="submit" class="btn btn-info" value="Back">
		</center>
		<input type="hidden" name="action" value="backto">
	</form>
</body>
</html>