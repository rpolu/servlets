<link rel="stylesheet" href="NewFile.css">
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file = "cashhead.jsp" %>
<%@ include file = "footer.jsp" %>
  <title>Add Customer</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
</head>
<body>
<form class="form-horizontal" name="form1" action="Controller" method="post" onsubmit="return checkForm();" >
 <input type="hidden" name="action" value="ad" />
<div class="container">
  <h2 align="center">Add Customer</h2>
  
 
    <div class="form-group">
      <label class="control-label col-sm-4" for="email">Customer SSN ID <sup style="color: red;">*</sup></label>
      <div class="col-sm-4">
        <input type="text" class="form-control" id="SSNID" placeholder="Enter SSN ID" name="ssn" required maxlength="9">
      </div>
      
      
      
      
      
      
      
      
    </div>
    <div class="form-group">
      <label class="control-label col-sm-4" for="pwd">Customer name<sup style="color: red;">*</sup></label>
      <div class="col-sm-4">          
        <input type="text" class="form-control" id="CNAME" placeholder="Enter name" name="name" required >
      </div>
    </div>
    
    
    
    
    
     <div class="form-group">
      <label class="control-label col-sm-4" for="pwd">Age<sup style="color: red;">*</sup></label>
      <div class="col-sm-4">          
        <input type="text" class="form-control" id="age" placeholder="Enter age" name="age" required maxlength="3">
      </div>
    </div>
    
    
    
    
    
     <div class="form-group">
      <label class="control-label col-sm-4" for="pwd">Address Line 1<sup style="color: red;">*</sup> </label>
      <div class="col-sm-4">          
        <input type="text" class="form-control" id="address1" placeholder="Enter addressline 1" name="address1" required>
      </div>
    </div>
    
    
    
    
    
    
    <div class="form-group">
      <label class="control-label col-sm-4" for="pwd">Address Line 2 </label>
      <div class="col-sm-4">          
        <input type="text" class="form-control" id="address2" placeholder="Enter addressline 2" name="address2" >
      </div>
    </div>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    <div class="form-group">
      <label class="control-label col-sm-4" for="pwd">State<sup style="color: red;">*</sup></label>
      <div class="col-sm-4">          

        <select class="form-control" id="State" placeholder="Enter State" name="state">
        	<option disabled="disabled" selected="selected" value="0">--select--</option>
			<option value='Andaman and Nicobar Islands'>Andaman and Nicobar Islands</option>
			<option value='Andhra Pradesh'>Andhra Pradesh</option>
			<option value='Arunachal Pradesh'>Arunachal Pradesh</option>
			<option value='Assam'>Assam</option>
			<option value='Bihar'>Bihar</option>
			<option value='Chandigarh'>Chandigarh</option>
			<option value='Chhattisgarh'>Chhattisgarh</option>
			<option value='Dadra and Nagar Haveli'>Dadra and Nagar Haveli</option>
			<option value='Daman and Diu'>Daman and Diu</option>
			<option value='Delhi'>Delhi</option>
			<option value='Goa'>Goa</option>
			<option value='Gujarat'>Gujarat</option>
			<option value='Haryana'>Haryana</option>
			<option value='Himachal Pradesh'>Himachal Pradesh</option>
			<option value='Jammu and Kashmir'>Jammu and Kashmir</option>
			<option value='Jharkhand'>Jharkhand</option>
			<option value='Karnataka'>Karnataka</option>
			<option value='Kerala'>Kerala</option>
			<option value='Lakshadweep'>Lakshadweep</option>
			<option value='Madhya Pradesh'>Madhya Pradesh</option>
			<option value='Maharashtra'>Maharashtra</option>
			<option value='Manipur'>Manipur</option>
			<option value='Meghalaya'>Meghalaya</option>
			<option value='Mizoram'>Mizoram</option>
			<option value='Nagaland'>Nagaland</option>
			<option value='Odisha'>Odisha</option>
			<option value='Puducherry'>Puducherry</option>
			<option value='Punjab'>Punjab</option>
			<option value='Rajasthan'>Rajasthan</option>
			<option value='Sikkim'>Sikkim</option>
			<option value='Tamil Nadu'>Tamil Nadu</option>
			<option value='Telengana'>Telengana</option>
			<option value='Tripura'>Tripura</option>
			<option value='Uttar Pradesh'>Uttar Pradesh</option>
			<option value='Uttarakhand'>Uttarakhand</option>
			<option value='West Bengal'>West Bengal</option>
			</select>
        
      </div>
    </div>
    
    
    
    <div class="form-group">
      <label class="control-label col-sm-4" for="pwd">City<sup style="color: red;">*</sup></label>
      <div class="col-sm-4">          
        <input type="text" class="form-control" id="city" placeholder="Enter City" name="city" required>
      </div>
    </div>
    
    
 
    
   <div class="form-group">        
      <div class="col-sm-offset-1 col-sm-10" align="center">
      <button type="reset" name="Reset"
					value="Reset" class="btn btn-default">Reset</button>
        <button type="submit" 
					value="Submit" class="btn btn-default">Submit</button> 
		<h6 align="center" style="color:red;">* Mandatory fields are required.</h6>
					
      </div>
     
</div></div>
<%
			String message = request.getAttribute("message").toString();
		%>
		<h4 align="center" style="color:red;"><%=message%></h4>
  
  </form>




	 <script>
	function checkForm() {
	
	var v7 = document.forms["form1"]["ssn"].value;
    var v1 = document.forms["form1"]["name"].value;
    var v2= document.forms["form1"]["age"].value;
    var v3 = document.forms["form1"]["address1"].value;
    var v5 = document.forms["form1"]["city"].value;
    
    var str= /^[ A-Za-z0-9 ]{1,20}$/;
    var strn= /^[ A-Za-z ]{1,20}$/;
    
    if (!v7.match(/^\d+/))
 	{
        alert(" Please enter a valid 9 digit SSN ID ");
        return false;
    }
    else if (v7.length < 9) {
		alert("Error: ID should be combination of 9 numbers!");
		document.getElementById('SSNID').value = "";
		return false;
	}
    else if(v1==""||!strn.test(v1))
    	{
    	 alert("Please enter valid Name ");
         return false;
    	}
    else if (!v2.match(/^\d+/))
 	{
        alert("Please enter valid age ");
        return false;
    }
    else if (v2 > 125) {
		alert("Maximum age should not be greater than 125");
		document.getElementById('age').value = "";
		return false;
	}
    else if (v2 < 18) {
		alert("Minimum age should be 18");
		document.getElementById('age').value = "";
		return false;
	}
    else if(v3=="")
    {
         alert("Please enter address ");
         return false;
    }
    else if (v5==""||!strn.test(v5))
 	{
        alert("Please enter city name ");
        return false;
    }
    
    var z = document.forms["form1"]["state"].value;
	
	if (z==0) {
		alert("Please select state");
		return false;
	}
	return true;
}
</script>

</body>
</html>
