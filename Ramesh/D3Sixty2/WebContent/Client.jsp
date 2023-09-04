<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<link type="text/css" rel="stylesheet" href="css/style.css">
    <title>D360-Client List</title>
</head>

<body>
    <div id="wrapper">
        <header class="header">
        <div class="viewPort">
         <img src="images/d360.png" alt="P3 SOLUTIONS" align="left"  width="100px" height="50px"  />
        <center><h1>D360-CLIENT DETAILS</h1></center>
        </div>
    </header>
    </div>
    <br><br>
<center>
    <div id="container">
        <div id="content">
            <form action="ClientController" method="get">
                <input type="hidden" name="command" value="SHOW">
                <label>FROM VALUE : </label>
                <input type="text" class="login-input" name="ClientIdFrom" placeholder="FROM">
                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                <label>TO VALUE : </label>
                <input type="text" class="login-input" name="ClientIdTo" placeholder="TO">
                <button type="submit">Submit</button><br><br><br>
            </form>
            <table>
                <tr>
                    <th>ID</th>
                    <th>USERNAME</th>
                    <th>FIRST NAME</th>
                    <th>MIDDLE NAME</th>
                    <th>LAST NAME</th>
                    <th>EMAIL</th>
                    <th>ROLE</th>
                </tr>
                <c:forEach var="tempClient" items="${ClientList}">
                    <!-- set up a link for each student -->
                    <c:url var="tempLink" value="ClientController">
                        <c:param name="command" value="LIST" />
                        <c:param name="ClientId" value="${tempClient.id}" />
                    </c:url>
                    <tr>
                        <td>${tempClient.id}</td>
                        <td>${tempClient.userName}</td>
                        <td>${tempClient.firstName}</td>
                        <td>${tempClient.middleName}</td>
                        <td>${tempClient.lastName}</td>
                        <td>${tempClient.email}</td>
                        <td>${tempClient.role}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    </center>
</body>
</html>
