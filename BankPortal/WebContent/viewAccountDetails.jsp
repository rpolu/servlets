<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.bean.Account"%>
    <%@ include file="header.jsp" %>
	<%@ include file="footer.jsp" %>
    <link rel="stylesheet" href="NewFile.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Display</title>
</head>
<body>
<%
Account acc = new Account();
acc = (Account) request.getAttribute("obj");
%>
<h3 align="center" style="margin-top: 80px">Account Details</h3>
<div class="container">
 <table class="table table-bordered" align="center" border="1" style="margin-top: 40px" width="250px">
    
      <tr>
        <th>Account ID</th>
        <td><%=acc.getAccount_id()%></td> 
      </tr>
    
      <tr>
       <th>Account Type</th>
        <td><%=acc.getAcc_type()%></td>
      </tr>
      
      <tr>
        <th>Customer ID</th>
        <td><%=acc.getCustomerid()%></td>
      </tr>
      
      <tr>
        <th>Balance (Rs)</th>
        <td> <%=acc.getBalance()%></td>
      </tr>
      
      <tr>
        <th>Creation Date (yyyy-mm-dd)</th>
        <td><%=acc.getCr()%></td>
      </tr>
      
      <tr>
        <th>Last Updated Date (yyyy-mm-dd)</th>
        <td> <%=acc.getCr_last()%></td>
      </tr>
   
  </table>
</div>

	
	
</body>
</html>