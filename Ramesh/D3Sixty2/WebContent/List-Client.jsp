<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>D360-ADMIN</title>
</head>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
    function openAddClientPopup() {
        var popupWindow = window.open('Add-Client.jsp', 'AddClientPopup', 'width=800,height=600');

        // Check if the popup should be closed when the "Save" button is clicked
        var shouldClose = document.getElementById('shouldClosePopup').value;
        if (shouldClose === 'true') {
            popupWindow.close();
            // Reset the hidden input value
            document.getElementById('shouldClosePopup').value = 'false';
        }
    }
</script>
<body>
<center>
    <div id="wrapper">
        <header class="header">
            <div class="viewPort">
                <img src="images/d360.png" alt="P3 SOLUTIONS" align="left" width="100px" height="50px" />
                <center><h1>D360-ADMIN PAGE</h1></center>
            </div>
        </header>
    </div>
    <br>
    <div id="container">
        <div id="content">
            <input type="button" value="INSERT NEW CLIENT" onclick="openAddClientPopup()" /><br><br>

            <!-- Include a hidden input field to track whether the popup should be closed -->
            <input type="hidden" id="shouldClosePopup" value="false" />
            <table>
                <tr>
                    <th>ID</th>
                    <th>USERNAME</th>
                    <th>FIRST NAME</th>
                    <th>MIDDLE NAME</th>
                    <th>LAST NAME</th>
                    <th>EMAIL</th>
                    <th>ROLE</th>
                    <th>ACTION</th>
                </tr>
                <c:forEach var="tempClient" items="${ClientList}">
                    <!-- set up a link for each student -->
                    <c:url var="tempLink" value="ClientController">
                        <c:param name="command" value="LOAD" />
                        <c:param name="ClientId" value="${tempClient.id}" />
                    </c:url>

                    <!--  set up a link to delete a student -->
                    <c:url var="deleteLink" value="ClientController">
                        <c:param name="command" value="DELETE" />
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
                        <td>
                            <button type="button" onclick="window.location.href='${tempLink}'">UPDATE</button> |
                            <button type="button" onclick="if (confirm('Are you sure to delete this Client Details?')) window.location.href='${deleteLink}'">DELETE</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>  
        </div>
    </div>
<center>
</body>
</html>
