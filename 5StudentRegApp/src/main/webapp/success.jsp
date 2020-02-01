<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create new account</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<style>
.account{
	margin-top: 30px;
}
.required:after {
    content: " *";
    color: red;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fullwidth">
		<div class="row">
			<div class="account col-md-6 col-md-offset-3">
				<div class="col-lg-12 well">
					<div class="row">
						<form action="CreateAccountServlet" method="post">
							<div class="col-sm-12">
								User Registered Sucessfully.
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>