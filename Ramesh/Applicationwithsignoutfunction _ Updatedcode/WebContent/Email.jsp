<%@ page import="java.util.*, javax.mail.*, javax.mail.internet.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Email Sending</title>
</head>
<body>
	<form action="Controller" metod="get">
		<input type="hidden" name="command" value="MAILFORADD">
		<tbody>
			<tr>
				<td><lable> FROM MAIL ID : </lable></td>
				<td><input type="text" name="FromId" required></td>
			</tr>
			<tr>
				<td><lable> TO MAIL ID : </lable></td>
				<td><input type="text" name="ToId" required></td>
			<tr>
				<td><lable> SUBJECT : </lable></td>
				<td><input type="text" name="SUBJECT" required></td>	
			</tr>
			<tr>
				<td><lable> CONTENT : </lable></td>
				<td><input type="text" name="CONTENT" required></td>	
			</tr>
			<tr>
				<td></td>
				<td><input type="hidden" name="UserName"
						value="${param.UserName}" /> <input type="submit" value="save" />
						<input type="hidden" name="command" value="FILTER" /></td>
			</tr>
		</tbody>
	</form>
</body>
</html>
