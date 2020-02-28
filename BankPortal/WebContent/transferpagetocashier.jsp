<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file = "header.jsp" %>
<%@ include file="footer.jsp"%>
<link rel="stylesheet" href="NewFile.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="Controller" method="post">

		<table frame="box">

			<tr>
				<td>Transfer amount:</td>
				<td><input type="text" name="transferamount" /></td>
			</tr>

			<tr>
				<td>Source Account:</td>
				<td><input type="text" name="sourceaccount" /></td>
			</tr>

			<tr>
				<td>Target Account:</td>
				<td><input type="text" name="targetaccount" /></td>
			</tr>

		</table>
		<input type="hidden" name="action" value="transferinitiation" />
	</form>

</body>
</html>