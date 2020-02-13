<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Banking App</title>
</head>
<body>
	<form action="saveFundTransfer.bankApp" method="get">
		<div>
			<h3>From-></h3>
			Account Number: <input type="number" name="fromAccNo">
			Amount:<input type="number" name="amount"></br>

			<h3>To -></h3>
			Account Number: <input type="number" name="toAccNo"></br> <input
				type="submit" value="submit"></br>
		</div>
	</form>
</body>
</html>