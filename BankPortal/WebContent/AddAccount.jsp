<%@ include file = "cashhead.jsp" %>
<%@ include file="footer.jsp"%>
<link rel="stylesheet" href="NewFile.css">
<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Account</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

<%  String message = request.getAttribute("message").toString(); %>
	<div class="container">


		<h2 align="center">Add Account</h2>


		<form class="form-horizontal" name="form" action="Controller"
			onsubmit="return checkForm();">
			<div class="form-group">
				<label class="control-label col-sm-2">Customer ID<sup style="color: red;">*</sup></label>
				<div class="col-sm-4">
					<input type="text" name="custid" id="no" required maxlength=9
						class="form-control" placeholder="Enter Customer ID">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Account Type<sup style="color: red;">*</sup></label>
				<div class="col-sm-4">
					<select  name="type" class="form-control">
						<option disabled selected value="0">--Select--</option>
						<option value="Savings">Savings</option>
						<option value="Current">Current</option>

					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Amount<sup style="color: red;">*</sup></label>
				<div class="col-sm-4">
					<input type="text" name="bal" id="balid" class="form-control" placeholder="Enter Amount">
				</div>
			</div>


			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" value="submit" class="btn btn-default">Submit</button>
					<input type="hidden" name="action" value="addaccount">
					<h4 style="color:red"><%=message%></h4>
					<h6 align="left" style="color:red;">* Mandatory fields are required.</h6>
				</div>
			</div>
		</form>

	</div>
	
	<script type="text/javascript">
		function checkForm() {
			var x = document.forms["form"]["custid"].value;
			var y = document.forms["form"]["bal"].value;
			var z = document.forms["form"]["type"].value;
			
			if (!/^[0-9]+$/.test(x)) {
				alert("Error: Please provide numeric value for Customer ID");
				document.getElementById('no').value = "";
				return false;
			}
			if (x.length < 9) {
				alert("Error: ID should be combination of 9 numbers!");
				document.getElementById('no').value = "";
				return false;
			}
			if (!/^[0-9]+$/.test(y)) {
				alert("Error: Please provide numeric value for balance");
				document.getElementsByName("bal").value = "";
				return false;
			}
			if (z==0) {
				alert("Please select valid account type");
				return false;
			}
			
			 if(z=="Savings"){
				 if(y<500){
					 alert("For saving account minimum amount should be 500");
  				 document.getElementById("balid").value = "";
  				 
  				return false;
       	  }
			 }
			
			
			
			return true;
		}
	</script></body>
</html>