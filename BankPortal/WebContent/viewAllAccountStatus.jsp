<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.AccountStatus"%>
<%@ include file = "cashhead.jsp" %>
<%@ include file="footer.jsp"%>
<link rel="stylesheet" href="NewFile.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Status</title>

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
		<h3>Account Status</h3>
			<table id="assocTable" class="display" border=1>
			<thead>
			<tr>
					<td><b>Customer Id</b></td>
					<td><b>Account Id</b></td>
					<td><b>Account Type</b></td>
					<td><b>Status</b></td>
					<td><b>Message</b></td>
					<td><b>Last Updated (dd/mm/yyyy)</b></td>
					<td><b>Action</b></td>
				</tr>
				</thead>
				<tbody>
				
				<%
					ArrayList<AccountStatus> accountstatusList = (ArrayList<AccountStatus>) request.getSession()
							.getAttribute("accountstatusList");
				for (AccountStatus a : accountstatusList) {%>

				<tr>
					<td><%=a.getCustomerid()%></td>
					<td><%=a.getAccount_id()%></td>
					<td><%=a.getAcc_type()%></td>
					<td><%=a.getStatus()%></td>
					<td><%=a.getMessage()%></td>
					<td><%=a.getLastupdated()%></td>
					
					<td><a href="Controller?action=refresh&accid=<%=a.getAccount_id()%>">Refresh</a></td>
				</tr>
				<%}%>
				</tbody>
			</table>
			
		</center>

	</form>

</body>
</html>








