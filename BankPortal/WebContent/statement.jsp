<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.Transaction"%>
<%@ include file = "header.jsp" %>
<%@ include file="footer.jsp"%>
<link rel="stylesheet" href="NewFile.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mini Statement</title>

<link rel="stylesheet" type="text/css"
href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.1/css/jquery.dataTables.css">
<!-- you can download the css and can edit it accordingly -->
<script type="text/javascript" charset="utf8"
src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.7.1.min.js"></script>
<script type="text/javascript" charset="utf8"
src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.1/jquery.dataTables.min.js"></script>
<script type="text/javascript" charset="utf-8">
$(document).ready(function() {
$('#assocTable').dataTable({"sPaginationType": "full_numbers",
'iDisplayLength': 4 

});
} );
</script>

</head>
<body>
<form action="Controller" method="post">
	<center style="margin-top: 100px">
<h4 align="center"><b>Mini Statement</b></h4>
	<%
		ArrayList<Transaction> tlist = (ArrayList<Transaction>) request
				.getAttribute("state");
	%>
	<table id="assocTable" class="display" border=1>
	<thead>
		<tr >
			<td><b>Date (yyyy-mm-dd) </b></td>
			<td><b>Transaction Description</b></td>
			<td><b>Amount (Rs)</b></td>
			<td><b>Balance (Rs)</b></td>
		</tr>
		</thead>
			<tbody>
		<%
			for (Transaction t : tlist) {
		%>
		<tr >
			<td><%=t.getTranDate()%></td>
			<td><%=t.getDescription()%></td>
			<td><%=t.getAmount()%></td>
			<td><%=t.getBalance()%></td>

		</tr>
		<%
			}
		%>
		</tbody>
	</table>
	
</body>
</html>