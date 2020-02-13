<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Banking App</title>
</head>
<body>
	<div>
		<h3 > ${requestScope.operation }</h3>
		</br>
		<form action="saveDeposit.bankApp" method="get">
			<div>
				Account Number: <input type="number" name="accNo"></br> 
				Amount:<input type="number" name="amount"></br>
				 <input type="submit" value="submit">
			</div>
		</form>
	</div>
</body>
</html>