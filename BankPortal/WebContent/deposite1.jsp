<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.bean.*"%>
<%@ include file = "cashhead.jsp" %>
<%@ include file="footer.jsp"%>
<link rel="stylesheet" href="NewFile.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deposit</title>
</head>
<body>
	<h3 align="center" style="margin-top: 80px">Deposit Money</h3>
	<form action="Controller" method="post" name="form" onsubmit="return checkForm();">
		<%
			String id = request.getAttribute("accid").toString();
			int accid = Integer.parseInt(id);
			String bal = request.getAttribute("bal").toString();
			double balance = Double.parseDouble(bal);
		%>
		
		
		<div class="container">
 <table class="table">
    
      <tr>
        <th>Account ID</th>
        <td><%=accid%></td> 
      </tr>
    
      <tr>
       <th>Balance Available (Rs)</th>
        <td><%=balance%></td>
      </tr>
      
      </table></div>
	<br><br>	
		<div class="form-group">
		<center>
		 <label for="usr">Enter Amount to Deposit (Rs)</label>
		<input id="amtip" type="text"  name="amount"><br>
		 <input type="submit" class="btn btn-info" value="Deposit"> 
		 <input type="hidden" value=<%=accid%> name="accid">
		  <input type="hidden"	value=<%=balance%> name="balance"> 
		  <input type="hidden" value="depositehere" name="action">
		
</center>
	</form>
	<script type="text/javascript">
		function checkForm() {
			var z = document.forms["form"]["amount"].value;

			if (!/^[0-9]+$/.test(z)) {
				alert("Please only enter positive amount");
				document.getElementById('amtip').value = "";
				return false;
			}
			return true;
		}
	</script>
</body>
</html>