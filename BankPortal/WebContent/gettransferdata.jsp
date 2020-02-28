<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

	<%@ include file = "header.jsp" %>
<%@ include file = "footer.jsp" %>
<link rel="stylesheet" href="NewFile.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer</title>
</head>
<body>
	<h3 align="center" style="margin-top: 80px">Transfer Money</h3>
	<form action="Controller" method="post" name="form" onsubmit="return checkForm();">
		<%
			String message = request.getAttribute("message").toString();
		%>
		
		<%
			String id = request.getAttribute("accid").toString();
			int accid = Integer.parseInt(id);
			String bal = request.getAttribute("bal").toString();
			double balance = Double.parseDouble(bal);
			String type = request.getAttribute("type").toString();

		%>
		
		
		
		
		
		<div class="container">
 <table class="table" width="20px">
    
      <tr>
        <th>Account ID</th>
        <td><%=accid%></td> 
      </tr>
    
    
    <tr>
        <th>Account Type</th>
        <td><%=type%></td> 
      </tr>
      
      <tr>
       <th>Balance Available (Rs)</th>
        <td><%=balance%></td>
      </tr>
      
      </table></div>
	<br><br>	
		
	<div class="form-group">
		<center>	
		
		<label for="usr">Enter Amount to Transfer (Rs)</label>
	
		
		 <input id="amtip"   type="text" name="amount"><br> 
		<br>
		<label for="usr">Enter Target Account ID (Rs)</label>
		 <input type="text" name="targetaccno"id="no" maxlength=9><br> <br><input
			type="submit"  class="btn btn-info" value="Transfer"> 
			<input type="hidden"value=<%=accid%> name="accid" id="noa"> 
			<input type="hidden" value=<%=balance%> name="balance"> 
		    <input type="hidden" value=<%=type%> name="type">
			<input type="hidden" value="nowtransfer" name="action">
			
			<h4 align="center" style="color:red;"><%=message%></h4>	

	</form>
<script type="text/javascript">
		function checkForm() {
			var z = document.forms["form"]["amount"].value;
			var t = document.forms["form"]["type"].value;
			var bal = document.forms["form"]["balance"].value;
			var x = document.forms["form"]["targetaccno"].value;
			
			if(document.getElementById('no').value == document.getElementById('noa').value)
			{
				document.getElementById('no').value = "";
				alert("Can't have same account number to transfer!");
				return false;
			}
			
			if (!/^[0-9]+$/.test(z)) {
				alert("Please only enter positive amount");
				document.getElementById('amtip').value = "";
				return false;
			}
			
			 if(t=="Savings"){
					if(bal-z<=500)
	            	  {
	            	 alert("Minimum balance in saving account  should be 500. Enter less amount");
	  				 document.getElementById('amtip').value = "";
	  				 return false;
	            	  }
					return true;
				}
				else 
					{
					if(bal-z<0)
	          	  {
	          	 alert("withdraw is not possible lease enter lesser amount");
					 document.getElementById('amtip').value = "";
					 return false;
	          	  }
					}
					
					if (!/^[0-9]+$/.test(x)) {
						alert("Error: Please provide numeric value");
						document.getElementById('no').value = "";
						return false;
					}
					if (x.length < 9) {
						alert("Error: ID should be combination of 9 numbers!");
						document.getElementById('no').value = "";
						return false;
					}
					return true;
		}
	</script>
</body>
</html>