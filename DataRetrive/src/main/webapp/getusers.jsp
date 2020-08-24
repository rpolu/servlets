<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
	<h3>Here is the User Records</h3>
	<c:forEach items="${users}" var="u">
	   ${u.uid}  ${u.fname} ${u.lName} ${u.ph} ${u.address} <br>
	</c:forEach>
</body>
</html>