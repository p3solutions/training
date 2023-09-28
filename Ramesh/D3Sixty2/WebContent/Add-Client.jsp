<!DOCTYPE html>
<html>
<head>
    <title>D360 - CREATE NEW CLIENT</title>
</head>
<body>
            <h2>D360 - CREATE NEW CLIENT</h2>
        <form action="ClientController" method="get">
            <input type="hidden" name="command" value="ADD" />
            <table>
                <tbody>
                    <tr>
                        <td><label>User Name</label></td>
                        <td><input type="text" name="userName" /></td>
                    </tr>
                    <tr>
                        <td><label>First name:</label></td>
                        <td><input type="text" name="firstName" /></td>
                    </tr>
                    <tr>
                        <td><label>Middle name:</label></td>
                        <td><input type="text" name="middleName" /></td>
                    </tr>
                    <tr>
                        <td><label>Last name:</label></td>
                        <td><input type="text" name="lastName" /></td>
                    </tr>
                    <tr>
                        <td><label>Email:</label></td>
                        <td><input type="text" name="email" /></td>
                    </tr>
                    <tr>
                        <td><label>Role:</label></td>
                        <td><input type="text" name="role" /></td>
                    </tr>
                    <tr>
                        <td><label>Password</label></td>
                        <td><input type="text" name="password" /></td>
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
</body>
</html>

