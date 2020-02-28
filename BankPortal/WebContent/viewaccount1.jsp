<!DOCTYPE html>
<html lang="en">
<%@ include file="header.jsp" %>
<%@ include file="footer.jsp" %>
<link rel="stylesheet" href="NewFile.css">
<head>
  <title>Display</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%  String message = request.getAttribute("message").toString(); %>

  <center>
		<h2>Search Account</h2>	</center>
		<div class="container">
		
  <form class="form-inline" action="Controller" method="post" name="form" onsubmit="return checkForm()";>
  
    <div class="form-group">
      <label for="email">Enter Account Id</label>
      <input type="text" class="form-control" placeholder="Enter id"   name="id" id="no" required maxlength=9>
    </div>
   
    <button type="submit" class="btn btn-default">Submit</button>
    <input type="hidden" name="action" value="viewaccountdetails"/>
    <h4 style="color:red"><%=message%></h4>

  </form>

    </div>
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
			return true;
		}
	</script>

</body>
</html>
