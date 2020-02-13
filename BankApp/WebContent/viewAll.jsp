<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Banking App</title>
</head>
<body>
	<div align="center">
		<h3>Accounts List</h3>
		<jstl:if test="${requestScope.bankAccounts.size() > 0 }">
			<table border="10">
				<tr>
					<th>Account Number</th>
					<th>Customer Name</th>
					<th>Account Type</th>
					<th>Email-Id</th>
					<th>Date of Birth</th>
					<th>Contact No</th>
				</tr>
				<jstl:forEach var="account" items="${requestScope.bankAccounts }">
					<tr>
						<td>${account.accountNumber}</td>
						<td>${account.customer.customerName}</td>
						<td>${account.accType}</td>
						<td>${account.customer.emailId}</td>
						<td>${account.customer.dob}</td>
						<td>${account.customer.phoneNo}</td>

					</tr>
				</jstl:forEach>
			</table>
		</jstl:if>
		<jstl:if test="${requestScope.bankAccounts.size() == 0 }">
			<h4>No Accounts Found!</h4>
		</jstl:if>
	</div>
</body>
</html>