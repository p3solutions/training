<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.*"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- Replace 'your.package.name' with the actual package name where Application class is located -->
<!DOCTYPE html>
<html>
<head>

<title>ADD APPLICATION</title>
</head>
<script>
function populateApplicationName(selectElement) {
    try {
        var LID = '${licenseIdToAppNameMap}';

        var LIDStr = LID;

        // Remove curly braces and split the string into key-value pairs
        var keyValuePairs = LIDStr.slice(1, -1).split(', ');

        // Initialize an empty object for the converted format
        var LIDConverted = {};

        // Loop through the key-value pairs and convert them
        for (var i = 0; i < keyValuePairs.length; i++) {
            var pair = keyValuePairs[i].split('=');
            var key = pair[0];
            var value = pair[1];
            LIDConverted[key] = [value];
        }

        // Convert the object to a JSON string
        var LIDConvertedJSON = JSON.stringify(LIDConverted);

        console.log("LIDConverted: " + LIDConvertedJSON);

        var selectedLicenseId = selectElement.value.trim();
        console.log("selectedLicenseId: " + selectedLicenseId);
        var applicationNameSelect = document.querySelector('#applicationName');
        console.log("applicationNameSelect : " + applicationNameSelect);
        // Clear existing options
        applicationNameSelect.innerHTML = '';

        var apps = JSON.parse(LIDConvertedJSON);
        console.log("apps : " + JSON.stringify(apps));

        if (selectedLicenseId in apps) {
            var applications = apps[selectedLicenseId];
            console.log("Applications for key " + selectedLicenseId + ": " + applications.join(", "));

            // Populate the applicationName dropdown with the options
            for (var i = 0; i < applications.length; i++) {
                var option = document.createElement('option');
                option.value = applications[i];
                option.textContent = applications[i];
                applicationNameSelect.appendChild(option);
            }
        } else {
            console.log("No apps found for selectedLicenseId: " + selectedLicenseId);
        }
    } catch (error) {
        console.error("An error occurred: ", error);
    }
}
	function printSelectedValue() {
		var selectedValue = document.querySelector('#applicationName').value;
		alert("Selected Value: " + selectedValue);
	}

	// Call populateApplicationName initially to populate the applicationName dropdown
	populateApplicationName(document.querySelector('select[name="license_Id"]'));
	
	function showErrorPopup() {
	    var errorPopup = document.getElementById('errorPopup');
	    errorPopup.style.display = 'block';
	}

	// Function to close the error popup
	function closeErrorPopup() {
	    var errorPopup = document.getElementById('errorPopup');
	    errorPopup.style.display = 'none';
	}
	
	</script>
 
<body>
    <h1>ADD APPLICATION FOR USER</h1>
	<form action="Controller" method="get">
		<input type="hidden" name="command" value="ADDAPPLICATIONBYUSER" />
		<table>
			<tbody>
				<tr>
					<td><label>LICENCE ID : </label></td>
					<td><select name="license_Id"
						onchange="populateApplicationName(this)" required>
							<c:forEach items="${licenseIdToAppNameMap}" var="entry">
								<option value="${entry.key}"
									${param.license_Id == entry.key ? 'selected' : ''}>
									${entry.key}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td><label>APPLICATION NAME:</label></td>
					<td><select name="applicationname" id="applicationName"
						required>
					</select>
				</td>
				</tr>

				<tr>
					<td><label>RENEWED DATE:</label></td>
					<td><input type="date" name="renewed_date" value="YYYY-MM-DD" required></td>
				</tr>
				<tr>
					<td><label>RENEWAL DATE:</label></td>
					<td><input type="date" name="renewal_date" value="YYYY-MM-DD" required></td>
				</tr>
				<tr>
					<td><input type="hidden" name="UserName"
						value="${param.UserName}" /> <input type="submit" value="save" />
						<input type="hidden" name="command" value="FILTER" /></td>
				</tr>
			</tbody>
		</table>
	</form>
	<div class="error-popup" id="errorPopup" style="display: none;">
    <p style="color: red;">Enter New Application Data. The given data already exists.</p>
    <button onclick="closeErrorPopup()">Close</button>
</div>
  
</body>
</html>
