<!DOCTYPE html>
<html>

<head>
<title>D360-UPDATE CLIENT</title>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>D360-UPDATE CLIENT DETAILS</h2>
		</div>
	</div>

	<div id="container">

		<form action="ClientController" method="get">

			<input type="hidden" name="command" value="UPDATE" /> 
			<input type="hidden" name="clientId" value="${ClientList.id}" />

			<table>
				<tbody>
					<tr>
						<td><label>ID:</label></td>
						<td><input type="text" name="id"
							value="${ClientList.id}" /></td>
					</tr>

					<tr>
						<td><label>UserName:</label></td>
						<td><input type="text" name="userName"
							value="${ClientList.userName}" /></td>
					</tr>
					<tr>
						<td><label>First name:</label></td>
						<td><input type="text" name="firstName"
							value="${ClientList.firstName}" /></td>
					</tr>
					<tr>
						<td><label>Middle name:</label></td>
						<td><input type="text" name="middleName"
							value="${ClientList.middleName}" /></td>
					</tr>
					<tr>
						<td><label>Last name:</label></td>
						<td><input type="text" name="lastName"
							value="${ClientList.lastName}" /></td>
					</tr>



					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email"
							value="${ClientList.email}" /></td>
					</tr>

					<tr>
						<td><label>Role:</label></td>
						<td><input type="text" name="role" value="${ClientList.role}" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				</tbody>
			</table>
		</form>

		<div style="clear: both;"></div>

		<form action="ClientController" method="get">
    		<input type="hidden" name="command" value="LIST" />
    		<button type="submit" class="link-button">Back</button>
		</form>
	</div>
</body>



</html>