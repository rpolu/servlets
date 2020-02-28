
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
.user{
color:#FFF;
}
.navbar{
color:#FFF;
}
</style>
<body>
<%HttpSession ses1=request.getSession(false);
if(ses1.getAttribute("user")!=null){ %>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
    <img src="piggy-bank.png" alt="Smiley face" height="42" width="42"/>
      <a class="navbar-brand" > MY BANK</a>
    </div>
    <ul class="nav navbar-nav"><div class="user"><h4><b>
     &nbsp;&nbsp;&nbsp; Welcome <%=ses1.getAttribute("user") %> (<%= ses1.getAttribute("role")%>)</b></h4></div>
     
    </ul>
    <ul class="nav navbar-nav navbar-right">
     
      <li><a href="Controller?action=logout"><span class="glyphicon glyphicon glyphicon-off"></span> Logout</a><%} %></li>
    </ul>
  </div>
</nav>
  


</body>
</html>
