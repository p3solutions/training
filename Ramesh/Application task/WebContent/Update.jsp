<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application Renewal</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>UPDATE APPLICATION DETAILS</h2>
		</div>
	</div>

	<form action="Controller" method="get">
		<input type="hidden" name="command" value="APPLICATIONRENEWAL" /> <input
			type="hidden" name="License_Id"
			value="${ApplicationDetailsForLoad.license_Id}" />
			<input
			type="hidden" name="UserName"
			value="${ApplicationDetailsForLoad.userName}" />
		<input
			type="hidden" name="ApplicationName"
			value="${ApplicationDetailsForLoad.applicationName}" />
		<table>
			<tbody>
				
				<td><label>RENEWED DATE : </label></td>
				<td><input type="date" name="Renewed_Date"
					value="${ApplicationDetailsForLoad.renewed_Date}" /></td>
				</tr>
				</tr>
				<td><label>RENEWAL DATE : </label></td>
				<td><input type="date" name="Renewal_Date"
					value="${ApplicationDetailsForLoad.renewal_Date}" /></td>
				</tr>


				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save" /></td>
				</tr>
			</tbody>
		</table>
	
	</form>
	<form action="Controller" method="get">
         <input type="hidden" name="command" value="FILTER" />
    	         <input type="hidden" name="UserName" value="${ApplicationDetailsForLoad.userName}" />
    	
    		<button type="submit" class="link-button">Back</button>
		</form>
	
</body>
</html>