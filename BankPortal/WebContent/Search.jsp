<!DOCTYPE html>
<%@ include file = "cashhead.jsp" %>
<%@ include file="footer.jsp"%>
<link rel="stylesheet" href="NewFile.css">
<html lang="en">
<head>
<title>Search</title>
<style>
form {
    border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
    width: 30%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 20%;
}

button:hover {
    opacity: 0.8;
}






.container {
    padding: 10px;
}



}
</style>
</head>
<body>
<%  String message = request.getAttribute("message").toString(); %>
		
<center>
<h2>Search Customer</h2>



<form action="Controller" method="post" name="form"  onsubmit="return checkForm(this);">
 <input type="hidden" name="action" value="search" />

  <div class="container">
  
   <div class="radio">
      <label><input type="radio" name="ide1" value="SSNID">SSN ID</label>
      <label><input type="radio" name="ide1" value="CustomerId">Customer ID</label>
      <input type="text" name="id" id="no"  required maxlength=9/>
    </div>
     
    <button type="submit" name="Search" value="Search">Submit</button>
    
 </div>
 </center>
</form>
	<h4 align="center" style="color:red" ><%=message%></h4>
	
	<script type="text/javascript">
		function checkForm() {
			var x = document.forms["form"]["id"].value;
			
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
			if ( ( form.ide1[0].checked == false ) && ( form.ide1[1].checked == false ) ) 
			{
			alert ( "Please choose your ID: SSN or Customer" ); 
			return false;
			}
			return true;
		}
	</script> 
	
</body>
</html>
