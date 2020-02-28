<link rel="stylesheet" href="NewFile.css">
<%@ include file="header.jsp"%>
<%@ include file="footer.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
form {
	border: 3px solid #f1f1f1;
}

input[type=text] {
	width: 40%;
	padding: 10px 4px;
	margin: 0px 0;
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
	<%
		String message = request.getAttribute("message").toString();
	%>
	
	<center>
		<h2>Search Account</h2>	</center>



		<form class="form-horizontal" action="Controller" method="post"
			name="form" onsubmit="return checkForm();">
			<input type="hidden" value="getaccount" name="action">



			<div class="container">

				<div class="form-group">
    <label class="control-label col-sm-2" for="email">Select ID Type:</label>
    <div class="col-sm-3">
						<select class="form-control" name="number" id="number">
							<option disabled selected value="0">--Select--</option>
							<option value="Account ID">Account ID</option>
							<option value="Customer ID">Customer ID</option>
							<option value="SSN ID">SSN ID</option>
						</select>
					</div>
					
					
					 <div class="form-group">
    <label class="control-label col-sm-2" >Enter Number:</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="no" name="id" placeholder="Enter Number" required maxlength=9>
    </div>
  </div>
				<!-- 	<div class="form-group">
						<div class="col-sm-4">
							<label class="control-label col-sm-4">Enter No.</label>
							<div class="col-sm-1">
								<input class="form-control" type="text" name="id" id="no"
									required maxlength=9 />
							</div>
						</div> -->

					</div>
				<center>	<button type="submit" name="submit" value="submit">Submit</button> </center>
				</div>
				<h4 align="center" style="color:red"><%=message%></h4>
	</form>


	<script type="text/javascript">
		function checkForm() {
			var z = document.forms["form"]["number"].value;
			var x = document.forms["form"]["no"].value;

			if (z == 0) {
				alert("Please select valid option");
				return false;
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






<%-- comment <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Controller" method="post" name="form" onsubmit="return checkForm();">
		<%
			String message = request.getAttribute("message").toString();
		%>
		<%=message%>


		<table>
			<tr>
				<td>Enter Number : <select name="number" id="number">
						<option disabled="disabled" selected="selected" value="0">--select--</option>
						<option value="Account ID">Account ID</option>
						<option value="Customer ID">Customer ID</option>
						<option value="SSN ID">SSN ID</option>
				</select> 
				
				Enter no : <input type="text" name="id" id="no" reuired maxlength=9> <input
					type="submit" value="submit"> <input type="hidden"
					value="getaccount" name="action">

				</td>
			</tr>


		</table>

	</form>
	 <script type="text/javascript">
		function checkForm() {
			var z = document.forms["form"]["number"].value;
			var x = document.forms["form"]["no"].value;
			
			if (z==0) {
				alert("Please select valid option");
				return false;
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
</html> --%>