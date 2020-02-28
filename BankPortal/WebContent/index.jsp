

<%@ include file = "executivehead.jsp" %>
<%@ include file = "footer.jsp" %>
<link rel="stylesheet" href="NewFile.css">
<!DOCTYPE html>
<html>
<head>
<title>Executive Operations</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<form action="Controller" method="post">
		<div class="panel-group" id="accordion" >

			<div class="panel panel-default" style="width: 200px"   style="height: 100">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a class="btn btn-info" data-toggle="collapse"
							data-parent="#accordion" href="#collapse1"> Customer Management </a>
					</h4>
				</div>

				<div id="collapse1" class="panel-collapse collapse">
					<div class="panel-body">
						<a href="Controller?action=add">Add Customer</a><br> <a
							href="Controller?action=deletec">Delete Customer</a><br> <a
							href="Controller?action=update">Update Customer</a>
					</div>
				</div>
			</div>

			<div class="panel panel-default" style="width: 200px" >
				<div class="panel-heading" >
					<h4 class="panel-title">
						<a class="btn btn-info" data-toggle="collapse" 
							data-parent="#accordion" href="#collapse2">Account Management &nbsp;</a>
					</h4>
				</div>


				<div id="collapse2" class="panel-collapse collapse">
					<div class="panel-body">
						<a href="Controller?action=createAcc">Create Account</a><br>
						<a href="Controller?action=delAcc">Delete Account</a><br>
					</div>
				</div>
</div>
				<div class="panel panel-default" style="width: 200px">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a class="btn btn-info" data-toggle="collapse" 
								data-parent="#accordion" href="#collapse3">View Status &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
						</h4>
					</div>
					<div id="collapse3" class="panel-collapse collapse">
						<div class="panel-body">
							<a href="Controller?action=CustStatus&page=1">Customer Status</a><br>
							<a href="Controller?action=Accstatus&page=1">Account Status</a>
						</div>
					</div>
				</div>
				</div>
				
			</form>
			
</body>
</html>



