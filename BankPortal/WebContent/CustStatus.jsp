<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.bean.CustomerStatus"%>
<%@ include file = "cashhead.jsp" %>
<link rel="stylesheet" href="NewFile.css">
<%@ include file="footer.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Status</title>

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
		<h3>Customer Status</h3>
		<table id="assocTable" class="display" border=1>
		<thead>
			<tr>
				<td><b>CustomerId</b></td>
				<td><b>SSNId</b></td>
				<td><b>Status</b></td>
				<td><b>Message</b></td>
				<td><b>Last Updated(dd/mm/yyyy)</b></td>
				<td><b>Action</b></td>
			</tr>
			</thead>
			<tbody>
			<%
				ArrayList<CustomerStatus> c = (ArrayList<CustomerStatus>) request.getSession()
						.getAttribute("cust");
				for (CustomerStatus cs : c) {
			%>
			<tr>
				<td><%=cs.getCustId()%></td>
				<td><%=cs.getSsn()%></td>
				<td><%=cs.getStatus()%></td>
				<td><%=cs.getMessage()%></td>
				<td><%=cs.getLast_Updated()%></td>
				<input type="hidden" name="idd" value="<%=cs.getSsn()%>" />
				<td><input type="submit" name="action" value="Refresh" /></td>
				<%
					}
				%>
			</tbody>	
		</table>
			</center>
	</form>
</body>
</html>