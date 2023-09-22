<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Application History For User </title>
</head>
<body>




<div id="wrapper">
		<header class="header">
			<div class="viewPort">
				<img src="images/d360.png" alt="P3 SOLUTIONS" align="left"
					width="100px" height="50px" />
				<center>
					<h1>APPLICATION HISTORY</h1>
				</center>
			</div>
		</header>
	</div>
	
	</br>
	
	 <form action="Controller" method="get">
         <input type="hidden" name="command" value="FILTER" />
	<input type="hidden" name="UserName"value="${param.UserName}" />         
    		<button type="submit" class="link-button">Back</button>
		</form>
		<center>
	
  
	<div id="container">
			<div id="content">
	<table>
		<tr>
			<th>LICENCE ID</th>
			<th>ApplicationName</th>
			<th>RENEWED DATE</th>
			<th>RENEWAL DATE</th>
		</tr>
		<c:forEach var="tempAppHistory" items="${HistoryOfApplication}">
			<tr>
				<td>${tempAppHistory.license_Id}</td>
				<td>${tempAppHistory.applicationName}</td>
				<td>${tempAppHistory.renewed_Date}</td>
				<td>${tempAppHistory.renewal_Date}</td>
			</tr>
		</c:forEach>
		 
		
		
		</div>
	</div>
</center>
</table>
</body>
</html>