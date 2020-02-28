<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="header.jsp"%>
<%@ include file="footer.jsp"%>
<link rel="stylesheet" href="NewFile.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Withdraw</title>
</head>
<body>
	<h3 align="center" style="margin-top: 80px">Withdraw Money</h3>
	<form action="Controller" method="post" name="form"
		onsubmit="return checkForm();">
		<%
			String id = request.getAttribute("accid").toString();
			int accid = Integer.parseInt(id);
			String bal = request.getAttribute("bal").toString();
			double balance = Double.parseDouble(bal);
			String type = request.getAttribute("type").toString();
		%>

		<div class="container">
			<table class="table">

				<tr>
					<th>Account ID</th>
					<td><%=accid%></td>
				</tr>

				<tr>
					<th>Account Type</th>
					<td><%=type%></td>
				</tr>

				<tr>
					<th>Balance Available (Rs.)</th>
					<td><%=balance%></td>
				</tr>

			</table>
		</div>


		<br>
		<br>
		<div class="form-group">
			<center>
				<label for="usr">Enter Amount to Withdraw (Rs)</label> <input id="amtip"
					type="text" name="amount"> <input type="submit"
					class="btn btn-info" value="Withdraw"> <input type="hidden"
					value=<%=type%> name="type"> <input type="hidden"
					value=<%=accid%> name="accid"> <input type="hidden"
					value=<%=balance%> name="balance"> <input type="hidden"
					value="withdrawhere" name="action">

			</center>
	</form>
	<script type="text/javascript">
		function checkForm() {
			var t = document.forms["form"]["type"].value;
			var z = document.forms["form"]["amount"].value;
			var bal = document.forms["form"]["balance"].value;

			if (!/^[0-9]+$/.test(z)) {
				alert("Please only enter positive amount");
				document.getElementById('amtip').value = "";
				return false;
			}
			if (t == "Savings") {
				if (bal == 0) {
					alert("available balance is 0.0. You can not withdraw");
					document.getElementById('amtip').value = "";
					return false;
				}
				if (bal - z <= 500) {
					alert("For saving account minimum balance should be 500.please enter less amount");
					document.getElementById('amtip').value = "";
					return false;
				}
				return true;
			} else {
				if (bal == 0) {
					alert("available balance is 0.0. You can not withdraw");
					document.getElementById('amtip').value = "";
					return false;
				}
				if (bal - z < 0) {
					alert("withdraw is not possible please enter lesser amount");
					document.getElementById('amtip').value = "";
					return false;
				}
				return true;
			}

			return true;
		}
	</script>

</body>
</html>