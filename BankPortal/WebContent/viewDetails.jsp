 <!DOCTYPE html>
<%@ include file = "cashhead.jsp" %>
<%@ include file="footer.jsp"%>
 <%@ page import="com.bean.Customer"%>
 <link rel="stylesheet" href="NewFile.css">
<html lang="en">
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
<form action="Controller" method="post">
<input type="hidden" name="id111" value="<%=c.getCustId()%>" />
<%String m=(String)request.getAttribute("message");%>
<div class="container">
  <h2>Customer Details</h2>
 
 <table class="table">
    
      <tr>
        <th>SSN Id</th>
        <td><%=c.getSsn()%>  </td>
      </tr>
   
      <tr>
        <th>Customer Id</th>
        <td><%=c.getCustId()%>  </td>
      </tr>
      
      <tr>
         <th>Customer Name</th>
        <td><%=c.getCustomerName()%>  </td>
      </tr>
      
      <tr>
        <th>Age</th>
        <td> <%=c.getAge()%> </td>
      </tr>
    
     <tr>
        <th>AddressLine 1</th>
        <td><%=c.getAddressLine1()%>  </td>
      </tr>
      
       <tr>
        <th>AddressLine 2</th>
        <td>  <%=c.getAddressLine2()%></td>
      </tr>
      
      
      <tr>
        <th>City</th>
        <td> <%=c.getCity()%> </td>
      </tr>
      
      <tr>
        <th>State</th>
        <td><%=c.getState()%>  </td>
      </tr>       

  </table>
</div>
  <center><button type="submit" name="action" value="Delete" class="btn btn-default ">Delete</button>
  <button type="submit" name="action" value="Cancel" class="btn btn-default ">Cancel</button></center>
 
		<h4 align="center" style="color:red;"><%=m %></h4>
		
</form>

</body>
</html>