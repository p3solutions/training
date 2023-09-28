<!DOCTYPE html>

<html>



<head>

<title>Add User</title>



<link type="text/css" rel="stylesheet" href="css/style.css">

<link type="text/css" rel="stylesheet" href="css/add-student-style.css">

</head>



<body>

	<div id="wrapper">

		<div id="header">

			<h2>Platform 3 solutions</h2>

		</div>

	</div>



	<div id="container">

		<h3>Add New  User</h3>


		<form action="Controller" method="get">



			<input type="hidden" name="command" value="ADDUSER" />





			<tbody>

				<tr>

					<td><label>UserName :</label></td>

					<td><input type="text" name="userName" required /></td>

				</tr>
				<br>

				<tr>

					<td><label>FirstName:</label></td>

					<td><input type="text" name="firstName" required /></td>

				</tr>
				<br>






				<tr>

					<td><label>LastName :</label></td>

					<td><input type="text" name="lastName" required /></td>

				</tr>
				<br>



				<tr>

					<td><label>Email     :</label></td>

					<td><input type="text" name="email" required /></td>
					<br>

				</tr>
				<tr>

					<td><label>Role      :</label></td>

					<td></td>
						<select name=role required>
							<option>ADMIN</option>
							<option>USER</option>
						</select>
				</tr>
				<br>


				<tr>

					<td><label>Password</label></td>

					<td><input type="password" name="password" required /></td>

				</tr>
				</br>





				<tr>


					
	<td><input type="hidden" name="command"	value="ADMINAPPLICATIONS">
						 <input type="submit"
						value="Save" class="save" /></td>

				</tr>



			</tbody>



		</form>



		<div style="clear: both;"></div>



		<form action="Controller" method="get">
			<input type="hidden" name="command" value="ADMINAPPLICATIONS" />
			<button type="submit" class="link-button">Back</button>
		</form>

	</div>

</body>



</html>