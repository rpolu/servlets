<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file = "header.jsp" %>
<%@ include file="footer.jsp"%>
<%@ page import="com.bean.Account"%>
<link rel="stylesheet" href="NewFile.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display</title>
</head>
<body>
	<form action="Controller" method="post">
		<%
			Account acc = new Account();
			acc = (Account) request.getAttribute("obj");
		%>
		<table align="center">
			<tr>
				<th>Information of Account</th>
				<td>Account id<%=acc.getAccount_id()%><br></td>
				<td>Customer id <%=acc.getCustomerid()%><br></td>
				<td>Acc_type<%=acc.getAcc_type()%><br></td>
				<td>Balance  <%=acc.getBalance()%><br></td>
				<td>CR <%=acc.getCr()%><br></td>
				<td>CR_last <%=acc.getCr_last()%><br></td>
				<td><input type="submit" value="Delete"> <input
					type="hidden" name="action" value="deletenow"> <input
					type="hidden" name="accid" value=<%=acc.getAccount_id()%>></td>

			</tr>
		</table>
	</form>
</body>
</html>