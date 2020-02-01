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
						<form action="stuRegSer">
							<div class="col-sm-12">
								<div class="row">
									<div class="col-sm-6 form-group">
										<label class="required">First Name</label><input type="text"
											placeholder="Enter First Name Here.." class="form-control"
											name="first_name" required>
									</div>
									<div class="col-sm-6 form-group">
										<label class="required">Last Name</label> <input type="text"
											placeholder="Enter Last Name Here.." class="form-control"
											name="last_name" required>
									</div>
								</div>
								<div class="form-group">
									<label class="required">Address</label>
									<textarea placeholder="Enter Address Here.." rows="3"
										class="form-control" name="address" required></textarea>
								</div>
								<div class="row">
									<div class="col-sm-4 form-group">
										<label>City</label> <input type="text"
											placeholder="Enter City Name Here.." class="form-control"
											name="city">
									</div>
									<div class="col-sm-4 form-group">
										<label class="required">State</label>
										<div class="input-group-btn">
											<select class="form-control btn btn-default" name="state" required>
												<option>Karnataka</option>
												<option>Thamilnadu</option>
												<option>Odisha</option>
												<option>Rajasthan</option>
												<option>Kerala</option>
											</select>
										</div>
									</div>
									<div class="col-sm-4 form-group">
										<label>Zip</label> <input type="text"
											placeholder="Enter Zip Code Here.." class="form-control"
											name="zip">
									</div>
								</div>
								<div class="form-group">
									<label class="required">Phone Number</label> <input type="tel"
										placeholder="Enter Phone Number Here.." class="form-control"
										name="phone" required>
								</div>
								<div class="form-group">
									<label class="required">Email Address</label> <input
										type="text" placeholder="Enter Email Address Here.."
										class="form-control" name="email" required>
								</div>
								<div class="form-group">
									  <label class="required">Gender</label>
									  <input type="radio" name="gender" value="male" checked> Male
                                      <input type="radio" name="gender" value="female"> Female
                                      <input type="radio" name="gender" value="other"> Other 
								</div>
								<div class="form-group">
									<span class="text-muted"><em><span
											style="color: red; font-size: 14px">*</span> Indicates
											required field</em> </span>
								</div>

								<input type="submit" class="btn btn-lg btn-info">
								</input>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>