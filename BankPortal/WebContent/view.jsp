 <!DOCTYPE html>
<html lang="en">
<%@ include file = "cashhead.jsp" %>
<%@ include file="footer.jsp"%>
<%@ page import="com.bean.Customer"%>
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
<%
		Customer c = (Customer) request.getAttribute("view");
	%>
<form class="form-horizontal" name="form1" action="Controller" method="post" onsubmit="return checkForm();" >

<div class="container">
  <h2>Customer Details</h2>
 
 <table class="table">
    
      <tr>
        <th>SSN Id</th>
        <td> <input type="text"  value="<%=c.getSsn()%>" class="form-control" disabled > </td>
        
      </tr>
   
      <tr>
        <th>Customer Id</th>
        <td>  <input type="text"  value="<%=c.getCustId()%>" class="form-control"  disabled><input type="hidden" name="id2" value="<%=c.getCustId()%>" /> </td>
   
      </tr>
      
      <tr>
         <th>Customer Name</th>
        <td> <input type="text" name="name"
					value="<%=c.getCustomerName()%>"class="form-control" > </td>
      </tr>
      
      <tr>
        <th>Age</th>
        <td> <input type="text" name="age"  id="age" required
					maxlength="3" value="<%=c.getAge()%>"  class="form-control"> </td>
      </tr>
    
     <tr>
        <th>Address Line 1</th>
        <td> <input type="text" name="address1"
					value="<%=c.getAddressLine1()%>" class="form-control"> </td>
      </tr>
      
       <tr>
        <th>Address Line 2</th>
        <td> <input type="text" name="address2"
					value="<%=c.getAddressLine2()%>"  class="form-control"> </td>
      </tr>
      
				<tr>
					<th>State</th>
					<td>
						
						<select class="form-control" id="State" placeholder="Enter State" name="state">
				        	<option  selected="selected" ><%=c.getState() %></option>
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
						
						
						</td>
				</tr>
				
				<tr>
					<th>City</th>
					<td><input type="text" name="city" value="<%=c.getCity()%>"
						class="form-control"></td>
				</tr>
								
			</table>
		</div>
		<center>
		<button type="submit" name="action" value="Reset"
				class="btn btn-default ">Reset</button>
			<button type="submit" name="action" value="Update1"
				class="btn btn-default ">Update</button>
		</center>

	</form>

	<script>
	function checkForm() {
	
    var v1 = document.forms["form1"]["name"].value;
    var v2= document.forms["form1"]["age"].value;
    var v3 = document.forms["form1"]["address1"].value;
    var v5 = document.forms["form1"]["city"].value;
    
    var str= /^[ A-Za-z0-9 ]{1,20}$/;
    var strn= /^[ A-Za-z ]{1,20}$/;
    
    if(v1==""||!strn.test(v1))
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
	return true;
}
</script>

</body>
</html>

