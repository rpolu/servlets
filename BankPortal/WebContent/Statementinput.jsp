<%@ include file="header.jsp"%>
<%@ include file="footer.jsp"%>
<link rel="stylesheet" href="NewFile.css">
<!DOCTYPE html>
<html lang="en">
<head>
<title>Search</title>
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

	<div class="container">

		<center>
			<h2><b>Mini Statement</b></h2>
		</center>
		<center style="margin-top: 60px">
			<input type="radio" id="showform" value="yes" name="showform" onchange="showhideForm(this.value);" />By Transaction Number
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" id="showform" value="no" name="showform" onchange="showhideForm(this.value);" />By Date
		</center>
		<br>
		<div id="div1" style="display: none">

			<form action="Controller" method="post" name="form" onsubmit="return checkForm(this);" class="form-horizontal">
				
				<div class="form-group">
					<input type="hidden" name="action" value="statement" />
					<label class="control-label col-sm-4">Enter Account ID</label>
					<div class="col-sm-4">
						<input type="text" id="no" name="accid" class="form-control" placeholder="Enter Account ID" required maxlength="9">
					</div>
				</div>
<center>
				<div  style="width: 350px" >
					<select name="rows" class="form-control ">
						<option selected="selected" disabled="disabled" value="0">Select number of transactions you want to see</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
					</select>
				</div>
	</center>			
	<br>
	<div class="form-group" align="center">
					<!-- <div class="col-sm-offset-2 col-sm-2" align="center"> -->
 						<button type="submit" value="submit" class="btn btn-default">Submit</button>

				
				</div>
			</form>
		</div>


		<div id="div2" style="display: none">
			<form action="Controller" method="post" name="form1" onsubmit="return checkForm1();" class="form-horizontal">
				<div class="form-group">

					<input type="hidden" name="action" value="statement11" />
					<label class="control-label col-sm-4">Enter Account ID</label>
					<div class="col-sm-4">
						<input type="text" id="no1" name="accid" class="form-control" placeholder="Enter Account ID" required maxlength="9">
					</div>
				</div>
<center>
				<div >
					Enter Start Date: <input type="date" name="startdate" id="sd" placeholder="dd-mm-yyyy" required maxlength="10"><br>
				<br>
					Enter End Date: <input type="date" name="enddate" id="ed" placeholder="dd-mm-yyyy" required maxlength="10">
				</div>

<br>
				<div class="form-group"  align="center">
					<div  align="center">
						<button type="submit" value="submit" class="btn btn-default">Submit</button>

					</div>
				</div>
				</center>
			</form>
		</div>

	</div>
	
	<%
		String message = request.getAttribute("message").toString();
	%>
	<h4 style="color: red" align="center"><%=message%></h4>
	
	<script type="text/javascript">
		function checkForm() {
			var x = document.forms["form"]["accid"].value;
			  var z = document.forms["form"]["rows"].value;
				
				if (z==0) {
					alert("Please select No. of transaction");
					return false;
				}
			if (!/^[0-9]+$/.test(x)) {
				alert("Error: Please provide numeric value");
				//document.getElementById('no').value = "";
				return false;
			}
			if (x.length < 9) {
				alert("Error: ID should be combination of 9 numbers!");
				//document.getElementById('no').value = "";
				return false;
			}
			if ((form.showform[0].checked == false)
					&& (form.showform[1].checked == false)) {
				alert("Please choose method either by transactions or by date");
				return false;
			}
			
			return true;
		}
		function showhideForm(showform) {
			if (showform == "yes") {
				document.getElementById("div1").style.display = 'block';
				document.getElementById("div2").style.display = 'none';
			}
			if (showform == "no") {
				document.getElementById("div2").style.display = 'block';
				document.getElementById("div1").style.display = 'none';
			}
			return true;
		}
	</script>
	
	<script type="text/javascript">
		function checkForm1() {
			
			var startDate = document.getElementById("sd").value;
		    var endDate = document.getElementById("ed").value;
		 
		    if ((Date.parse(startDate) >= Date.parse(endDate))) {
		        alert("End date should be greater than Start date");
		        document.getElementById("ed").value = "";
		        return false;
		    }
			
			var x1 = document.forms["form1"]["accid"].value;

			if (!/^[0-9]+$/.test(x1)) {
				alert("Error: Please provide numeric value");
				document.getElementById('no1').value = "";
				return false;
			}
			if (x1.length < 9) {
				alert("Error: ID should be combination of 9 numbers!");
				document.getElementById('no1').value = "";
				return false;
			}
			if ((form.showform[0].checked == false)
					&& (form.showform[1].checked == false)) {
				alert("Please choose method either by transactions or by date");
				return false;
			}

			
			return true;
		}
		function showhideForm(showform) {
			if (showform == "yes") {
				document.getElementById("div1").style.display = 'block';
				document.getElementById("div2").style.display = 'none';
			}
			if (showform == "no") {
				document.getElementById("div2").style.display = 'block';
				document.getElementById("div1").style.display = 'none';
			}
			return true;
		}
	</script>
	
</body>
</html>