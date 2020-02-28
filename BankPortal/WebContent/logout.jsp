<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<%HttpSession ses1=request.getSession(false);
if(ses1.getAttribute("user")!=null){ %>
<table style="width: 100%" >
<tr>
<td align="left"><h2>Welcome <%=ses1.getAttribute("user") %> (<%= ses1.getAttribute("role")%>)</h2></td>
<td align="right"><h3 ><a href="Controller?action=logout">Logout</a></h3><%} %></td>
</tr>
</table>
</body>
</html>