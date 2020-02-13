<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Banking App</title>
</head>
<body>
<div><h2>Transaction Successful</h2></br>
Fund Transferred From Account Number: ${requestScope.fromAccNum }</br>
 Updated Balance is Rs: ${requestScope.retrievedBalance } </br></br>
 
 Fund Transferred To Account Number: ${requestScope.toAccNum }</br>
 Updated Balance is Rs: ${requestScope.accBal } </br></br>
 
</div>
</body>
