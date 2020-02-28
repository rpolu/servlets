<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.bean.*"%>
<%@ page import="java.util.*"%>
<%@ include file="cashhead.jsp"%>
<%@ include file="footer.jsp"%>
<link rel="stylesheet" href="NewFile.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display All Account</title>

<link rel="stylesheet" type="text/css"
href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.1/css/jquery.dataTables.css">
<!-- you can download the css and can edit it accordingly -->
<script type="text/javascript" charset="utf8"
src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.7.1.min.js"></script>
<script type="text/javascript" charset="utf8"
src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.1/jquery.dataTables.min.js"></script>
<script type="text/javascript" charset="utf-8">
$(document).ready(function() {
$('#deltable').dataTable({"sPaginationType": "full_numbers",
'iDisplayLength': 4 

});
} );
</script>

</head>
<body>
	<form action="Controller" method="post">
		<center style="margin-top: 100px">
		<h3 align="center">Account Details</h3>
		<%
		ArrayList<Account> acc=(ArrayList<Account>)request.getAttribute("array12");
		%>
			<table id="deltable" class="display" border=1>
				<thead>
					<tr>
						<td>Account ID</td>
						<td>Account Type</td>
						<td>Customer ID</td>
						<td>Balance (Rs)</td>
						<td>Creation Date(yyyy-mm-dd)</td>
						<td>Last Updated Date(yyyy-mm-dd)</td>
					</tr>
				</thead>
				<tbody>
					<%
for(Account a:acc){
%>

					<tr>
						<td><%=a.getAccount_id() %></td>
						<td><%=a.getAcc_type() %></td>
						<td><%=a.getCustomerid()%></td>
						<td><%=a.getBalance()%></td>
						<td><%=a.getCr() %></td>
						<td><%=a.getCr_last() %></td>
						<input type="hidden" name="value" value="<%=a.getAccount_id() %>" />
						<td><input type="submit" value="Delete"
							Onclick=" return ConfirmDelete()" /><input type="hidden"
							name="action" value="Delete11" /></td>
					</tr>
					<%} %>

				</tbody>
			</table>
			</center>
	</form>
	
	<script>
				function ConfirmDelete() {
					var x = confirm("Are you sure you want to delete?");
					if (x)
						return true;
					else
						return false;
				}
			</script>
		
	
</body>
</html>