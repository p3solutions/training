<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<link type="text/css" rel="stylesheet" href="css/Adminstyle.css">
    <meta charset="ISO-8859-1">
    <title>List Of Applications</title>
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
            <div class="left-content">
                <div class="image"><img src="images/d360.png" alt="P3 SOLUTIONS" width="100px" height="50px"  /></div>
            </div>
            <div class="topic"><h1>APPLICATION LIST</h1></div>
                <form action="Controller" method="get" class="logout-form">
                    <input type="hidden" name="command" value="LOGOUT" />
                    <button onclick="window.location.href='BasicLoginPage.jsp';">SIGN OUT</button>
                </form>
            </div>
    </header>
</div>
    <br>
    <input type="button" value="ADDAPPLICATION" onclick="window.location.href='AddAppByAdmin.jsp';return false;  "/>
    <input type="button" value="ADDUSER" onclick="window.location.href='AddUser.jsp';return false;  "/>
    <br><br>
    <center>
        <div id="container">
            <div id="content">
                <table>
                    <tr>
                        <th>LICENCE ID</th>
                        <th>APPLICATION NAME</th>
                        <th>PURCHASE DATE</th>
                        <th>ACTION</th>
                    </tr>
                    <c:forEach var="tempApp" items="${ApplicationList}">
                        <tr>
                            <td>${tempApp.license_Id}</td>
                            <td>${tempApp.applicationName}</td>
                            <td>${tempApp.purchase_Date}</td>
                            <td>
                                <c:url var="tempHistory" value="Controller">
                                    <c:param name="command" value="APPLICATIONHISTORYBYADMIN"/>
                                    <c:param name="Application_Name" value="${tempApp.applicationName}"/>
                                </c:url>
                                <button type="button" onclick="window.location.href='${tempHistory}'">HISTORY</button> &nbsp;
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </center>
</body>
</html>
