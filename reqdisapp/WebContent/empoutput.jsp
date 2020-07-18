<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">

EID: <%= request.getAttribute("s1") %><br><br>
Name: <%= request.getAttribute("s2") %><br><br>
Salary: <%= request.getAttribute("s3") %><br><br>

</body>
</html>