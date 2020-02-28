<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.bean.*"%>
<%@ page import="java.util.*"%>
<%@ include file = "cashhead.jsp" %>
<%@ include file="footer.jsp"%>
<link rel="stylesheet" href="NewFile.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Details</title>
</head>
<body>
	<%
		ArrayList<Account> aList = new ArrayList<Account>();
		aList = (ArrayList<Account>) request.getAttribute("obj");
	%>
	<center>
	<form action="Controller" method="post">
		<input type="hidden" name="action" value="fetchAccountList">
		<h4><b>Search for Account </b></h4>
		
		<center>
		
		
		
		
		
		<br><br>	
	<div  class="form-group">	
  <h4> <label   for="usr" class="control-label col-sm-2" >Account no :</label></h4>
   <div class="col-sm-2">
						<select class="form-control" style="margin-left: -100px" name="aNo" class="control-label col-sm-2">
							<%
							for (Account a : aList) {
						%>
							<option ><%=a.getAccount_id()%></option>
							<%} %>
						</select>
					</div>
					
		</div>
			</center>
	
		
	

		
		 
						
		<input type="submit" class="btn btn-info" style="margin-left:-800px" value="SUBMIT">
	</form>
	</center>
</body>
</html>