<%@ include file="headder.jsp"%>
<%@ include file="footer.jsp"%>
<link rel="stylesheet" href="NewFile.css">
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login Page</title>
<style>
form {
    border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
    width: 30%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 20%;
}

button:hover {
    opacity: 0.8;
}






.container {
    padding: 10px;
}



}
</style>

<script>
	function validateForm() {
		var x = document.forms["form1"]["username"].value;
		var y = document.forms["form1"]["pwd1"].value;
		if (x == "") {
			alert("Username must be filled out");
			return false;
		}
		if (y == "") {
			alert("Password must be filled out");
			return false;
		}
	}
</script>
</head>
<body >
<center>
<h2 >User Login</h2>



<form action="Controller" method="post" name="form1" onsubmit="return checkForm(this);">
 

  <div class="container" >
  
    <label><b>Username<sup style="color: red;">*</sup></b></label>
    <input type="text" placeholder="Enter Username" name="username" required>
<br>
    <label><b>Password<sup style="color: red;">*</sup></b></label>
    <input type="password" placeholder="Enter Password" name="pwd1" required>
<br>        
    <button type="submit">Login</button>
    <input type="hidden" name="action" value="login" />
 </div>
 </center>
</form>
<div align="center" >
		<%String m=(String)request.getAttribute("message"); if(m!=null){%>
		<h3 style="color:red;"><%=m %></h3><%} %>
		</div>
		
</body>
</html>