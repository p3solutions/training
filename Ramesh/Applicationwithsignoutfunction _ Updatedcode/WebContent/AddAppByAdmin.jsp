<!DOCTYPE html>
<html>
<head>
    <title>ADD APPLICATION</title>
</head>
<body>
            <h2>ADD APPLICATION</h2>
        <form action="Controller" method="get">
            <input type="hidden" name="command" value="ADDAPPLICATIONBYADMIN" />
            <table>
                <tbody>
                    <tr>
                        <td><label>LICENCE ID : </label></td>
                        <td><input type="text" name="license_Id" required /></td>
                    </tr>
                    <tr>
                        <td><label>APPLICATION NAME:</label></td>
                        <td><input type="text" name="applicationname"  required/></td>
                    </tr>
                    <tr>
                        <td><label>PURCHASE DATE:</label></td>
                        <td><input type="date" name="purchase_Date" required/></td>
                    </tr>
                    
                    <tr>
                    	<td><input type="submit" value="save" />
                    		<input type="hidden" name="command" value="SHOWAPPLICATIONLIST" />
                    	</td>
                    </tr>
                </tbody>
            </table> 
            
            
        </form>
        <form action="Controller" method="get">
         <input type="hidden" name="command" value="ADMINAPPLICATIONS" />
    		<button type="submit" class="link-button">Back</button>
		</form>
</body>
</html>



