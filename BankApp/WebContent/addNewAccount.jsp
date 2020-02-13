<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank App</title>
</head>
<body>

	<div align="center">
		<h2>Enter Details for New Account</h2>
		<form action="newAccount.bankApp" method="post">
		<table>
			<tr>
				<td>Account Holder Name:</td>
				<td><input type="text" name="customerName" required="required" /></td>
			</tr>

			<tr>
				<td>Email-Id:</td>
				<td><input type="email" name="emailId" required="required" /></td>
			</tr>
			<tr>
				<td>Date Of Birth:</td>
				<td><input type="date" name="dob" required="required" /></td>
			</tr>
			<tr>
				<td>Phone No:</td>
				<td><input type="tel" name="telephone" required="required" /></td>
			</tr>
			<tr>
				<td>Account Type:</td>
				<td><select required="required" name="accType">
						<option value="default">Select</option>
						<option value="savingsAccount" >Savings
							Account</option>
						<option value="currentAccount" >Current
							Account</option>
				</select></td>
			</tr>

			<tr>
				<td>Salaried Account:</td>
				<td><input type="radio" name="salaried" value="true">Yes
					<input type="radio" name="salaried" value="false">No</td>
			</tr>
			<tr>
				<td>Balance (If not salaried ,</td>
				<td rowspan="2"><input type="number" name="balance" /></td>
			</tr>
			<tr>
				<td>Min. Balance >5000):</td>
			</tr>
			<tr>
				</br>
				<td>OverDraft Limit</td>
				<td rowspan="2"><input type="number" name="odLimit" /></td>
			</tr>
			<tr>
				<td>(Only if Current Account):</td>
			</tr></br>
			<tr>
				<td>
					<button type="reset">Clear</button>
					<button type="submit">Submit</button>
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>