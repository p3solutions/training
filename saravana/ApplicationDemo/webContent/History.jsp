<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Application History</title>
</head>
<body>


	<div id="wrapper">
		<header class="header">
			<div class="viewPort">
				<img src="images/d360.png" alt="P3 SOLUTIONS" align="left"
					width="100px" height="50px" />

				<h1>Application History For Admin</h1>

			</div>
		</header>
	</div>
	<br />
	<form action="Controller" method="get">
		<input type="hidden" name="command" value="ADMINAPPLICATIONS" />
		<button type="submit" class="link-button">Back</button>
	</form>

	<form action="Controller" method="get">
		<input type="hidden" name="command" value="SHOWHISTORY"> <label>From_Date:</label>
		<input type="date" class="login-input" name="Start_Date" required>
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <label>To_Date:</label> <input
			type="date" class="login-input" name="End_Date" required> <input
			type="hidden" name="ApplicationName"
			value="${param.Application_Name}">
		<button type="submit">Submit</button>
		<br>
		<br>
		<br>
	</form>
	<form action="Controller" method="get">
		<input type="hidden" name="command" value="EXPORT" /> <input
			type="hidden" name="ApplicationName"
			value="${param.Application_Name}">
		<button type="submit" class="link-button">Export to PDF</button>
	</form>
	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>LICENCE ID</th>
					<th>USERNAME</th>
					<th>ApplicationName</th>
					<th>RENEWED DATE</th>
					<th>RENEWAL DATE</th>
				</tr>
				<c:forEach var="tempAppHistory" items="${HistoryOfApplication}">
					<tr>
						<td>${tempAppHistory.license_Id}</td>
						<td>${tempAppHistory.userName}</td>
						<td>${tempAppHistory.applicationName}</td>
						<td>${tempAppHistory.renewed_Date}</td>
						<td>${tempAppHistory.renewal_Date}</td>
					</tr>
				</c:forEach>
				<c:forEach var="tempClient" items="${RenewalDetails}">
					<tr>
						<td>${tempClient.license_Id}</td>
						<td>${tempClient.userName}</td>
						<td>${tempClient.applicationName}</td>
						<td>${tempClient.renewed_Date}</td>
						<td>${tempClient.renewal_Date}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>


</body>
</html>
