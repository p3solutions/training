<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="css/Userstyle1.css">
<title>Application List</title>
</head>
 <script type="text/javascript">
        function preventBack() { window.history.forward(); }
        setTimeout("preventBack()", 0);
        window.onunload = function () { null };
    </script>
     
<body>
	<div id="wrapper">
    <header class="header">
        <div class="viewPort">
            <div class="image"><img src="images/d360.png" alt="P3 SOLUTIONS" width="100px" height="50px"  /></div>
            <div class="topic"><h1>APPLICATION LIST</h1></div>
            <div class="username">Welcome, ${param.UserName}</div>
                <form action="Controller" method="get" class="logout-form">
                    <input type="hidden" name="command" value="LOGOUT" />
                    <button onclick="window.location.href='BasicLoginPage.jsp';">SIGN OUT</button>
                </form>
        </div>
    </header>
</div>
    <br>
	<form action="Controller" method="get">
		<input type="hidden" name="UserName" value="${param.UserName}" /> <input
			type="hidden" name="command" value="DROPDOWNFORLICENCEID" /> <input
			type="submit" value="ADD" />

	</form>
	<br>
	<br>
	<center>
		<div id="container">
			<div id="content">
				<table>
					<tr>
						<th>LICENCE ID</th>
						<th>APPLICATION NAME</th>
						<!--   <th>USERNAME</th>-->
						<th>RENEWED DATE</th>
						<th>RENEWAL DATE</th>
						<th>ACTION</th>
					</tr>
					<c:forEach var="tempApp" items="${ApplicationByUser}">
						<tr>
							<td>${tempApp.license_Id}</td>
							<td>${tempApp.applicationName}</td>
							<!--   <td>${tempApp.userName} </td>-->
							<td>${tempApp.renewed_Date}</td>
							<td>${tempApp.renewal_Date}</td>
							<td><c:url var="tempUpdate" value="Controller">
									<c:param name="command" value="LOADAPPLICATION" />
									<c:param name="License_Id" value="${tempApp.license_Id}" />
									<c:param name="UserName" value="${tempApp.userName}" />
								</c:url> <c:url var="tempHistory" value="Controller">
									<c:param name="command" value="HISTORY" />
									<c:param name="UserName" value="${tempApp.userName}" />
									<c:param name="License_Id" value="${tempApp.license_Id}" />
									<c:param name="ApplicationName"
										value="${tempApp.applicationName}" />
								</c:url> <c:url var="tempDelete" value="Controller">
									<c:param name="command" value="DELETEAPPLICATION" />
									<c:param name="UserName" value="${tempApp.userName}" />
									<c:param name="ApplicationName"
										value="${tempApp.applicationName}" />
								</c:url>
								<button type="button"
									onclick="window.location.href='${tempUpdate}'">UPDATE</button>
								&nbsp;
								<button type="button"
									onclick="window.location.href='${tempHistory}'">HISTORY</button>
								&nbsp;
								<button type="button"
									onclick="if (confirm('Are you sure to delete this Application Details?')) window.location.href='${tempDelete}'">DELETE</button>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</center>
	<script>
		function redirectToAddApplication() {
			var userName = "${param.UserName}";
			window.location.href = 'AddApplication.jsp?UserName=' + userName;
		}
	</script>
</body>
</html>






