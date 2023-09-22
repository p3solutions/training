package JavaCode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

public class UserDatabase {

	private DataSource dataSource;

	public UserDatabase(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public void AddApplication(Application NewApplication) throws SQLException {
	    Connection myConnection = null;
	    PreparedStatement checkStatement = null;
	    PreparedStatement myStatement = null;
	    ResultSet resultSet = null;

	    try {
	        myConnection = dataSource.getConnection();

	        // Check if a record with the same ApplicationName and UserName exists in UserDetails
	        String checkSql = "SELECT * FROM UserDetails WHERE UserName = ?";
	        checkStatement = myConnection.prepareStatement(checkSql);
	        checkStatement.setString(1, NewApplication.getUserName());
	        resultSet = checkStatement.executeQuery();

	        if (resultSet.next()) {
	            // Perform date comparison validation
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            Date renewedDate = dateFormat.parse(NewApplication.getRenewed_Date());
	            Date renewalDate = dateFormat.parse(NewApplication.getRenewal_Date());

	            if(renewalDate.after(renewedDate) || renewalDate.equals(renewedDate)) {
	                // Check if a record with the same ApplicationName and UserName does not exist in ApplicationDetails
	                String sql = "INSERT INTO ApplicationDetails (License_Id, ApplicationName, UserName, Renewed_Date, Renewal_Date) " +
	                             "SELECT ?, ?, ?, ?, ? " +
	                             "WHERE NOT EXISTS (SELECT * FROM ApplicationDetails " +
	                             "WHERE (ApplicationName = ? AND UserName = ?) OR (License_Id = ? AND UserName = ?))";

	                myStatement = myConnection.prepareStatement(sql);
	                myStatement.setString(1, NewApplication.getLicense_Id());
	                myStatement.setString(2, NewApplication.getApplicationName());
	                myStatement.setString(3, NewApplication.getUserName());
	                myStatement.setString(4, NewApplication.getRenewed_Date());
	                myStatement.setString(5, NewApplication.getRenewal_Date());
	                myStatement.setString(6, NewApplication.getApplicationName());
	                myStatement.setString(7, NewApplication.getUserName());
	                myStatement.setString(8, NewApplication.getLicense_Id());
	                myStatement.setString(9, NewApplication.getUserName());

	                myStatement.execute();
	            } else {
	                System.out.println("Renewal date must be greater than the renewed date.");
	            }
	        } else {
	            throw new SQLException("Data for the user does not exist in the UserDetails table");
	            
	        }
	    } catch (SQLException | ParseException e) {
	        // Handle exceptions (log, provide user feedback, etc.)
	        e.printStackTrace();
	    } finally {
	        close(myConnection, checkStatement, resultSet);
	        close(null, myStatement, null);
	    }
	}

	

	public List<History> getApplicationHistory(String userName, String license_Id, String applicationName)
			throws SQLException {
		List<History> historyOfApplication = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String enteredusername = userName;
			String enteredLicense_Id = license_Id;
			String enteredapplicationname = applicationName;

			connection = dataSource.getConnection();
			String sql = "SELECT * FROM historydetails WHERE username = ? AND license_id = ?  And ApplicationName=? ;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, enteredusername); // Replace with your dynamic username value
			preparedStatement.setString(2, enteredLicense_Id); // Replace with your dynamic license_id value
			preparedStatement.setString(3, enteredapplicationname); // Replace with your dynamic username value

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String License_Id = resultSet.getString("License_Id");
				String UserName = resultSet.getString("UserName");
				String ApplicationName = resultSet.getString("ApplicationName");
				String Renewed_Date = resultSet.getString("Renewed_Date");
				String Renewal_Date = resultSet.getString("Renewal_Date");

				History history = new History(License_Id, UserName, ApplicationName, Renewed_Date, Renewal_Date);
				historyOfApplication.add(history);
			}
			return historyOfApplication;
		} finally {
			close(connection, preparedStatement, resultSet);
		}
	}

	public List<Users> getuserdetailsforauthentication() throws SQLException {
		List<Users> users = new ArrayList<>();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			myConn = dataSource.getConnection();
			String sql = "SELECT * FROM UserDetails;";
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);

			while (myRs.next()) {
				int id = myRs.getInt("User_Id");
				String userName = myRs.getString("UserName");
				String firstName = myRs.getString("FirstName");
				String lastName = myRs.getString("LastName");
				String email = myRs.getString("Email");
				String role = myRs.getString("Role");
				String password = myRs.getString("Password");
				
				

				Users tempUser = new Users(id, userName, firstName, lastName, email, role, password);

				users.add(tempUser);
			}

			return users;
		} finally {
			close(myConn, myStmt, myRs);
		}

	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close();
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	public List<Application> getApplicationDetails(String userName) throws Exception {
//			Client theclient;
		List<Application> ApplicationList = new ArrayList<>();
		Connection myConnection = null;
		Statement myStatement = null;
		ResultSet myset = null;

		try {
			String enteredusername = userName;
			myConnection = dataSource.getConnection();
			String sql = "SELECT * FROM ApplicationDetails WHERE Username = '" + enteredusername + "' ORDER BY ApplicationName";
			Statement statement = myConnection.createStatement();
			myset = statement.executeQuery(sql);

			while (myset.next()) {
				String License_Id = myset.getString("License_Id");
				String UserName = myset.getString("UserName");
				String ApplicationName = myset.getString("ApplicationName");
				String Renewed_Date = myset.getString("Renewed_Date");
				String Renewal_Date = myset.getString("Renewal_Date");

				Application TemporaryList = new Application(License_Id, UserName, ApplicationName, Renewed_Date,
						Renewal_Date);
				ApplicationList.add(TemporaryList);
			}

			return ApplicationList;

		}

		finally {
			close(myConnection, myStatement, myset);
		}

	}

	public void DeleteApplicationByUser(String applicationName, String username) throws SQLException {
		Connection myConnection = null;
		PreparedStatement myStatement = null;
		try {

			String enteredapplicationname = applicationName;
			String enteredusername = username;

			// get connection to database
			myConnection = dataSource.getConnection();
			// create sql to delete student
			String sql = "delete from Applicationdetails where ApplicationName=? and UserName=?;";
			// prepare statement
			myStatement = myConnection.prepareStatement(sql);
			// set params
			myStatement.setString(1, enteredapplicationname);
			myStatement.setString(2, enteredusername);

			// execute sql statement
			myStatement.execute();
		} finally {
			close(myConnection, myStatement, null);
		}
	}


	public void ApplicationRenewalByUser(Application UpdatedLicense) throws SQLException {
	    Connection myConnection = null;
	    PreparedStatement myStatement = null;

	    try {
	        // Get a DB connection
	        myConnection = dataSource.getConnection();

	        // Perform date comparison validation in Java code
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	       Date renewedDate = dateFormat.parse(UpdatedLicense.getRenewed_Date());
	        Date renewalDate = dateFormat.parse(UpdatedLicense.getRenewal_Date());
	     //  
            if(renewalDate.after(renewedDate) || renewalDate.equals(renewedDate)) {
	            // Create SQL update statement
	            String sql = "UPDATE Applicationdetails SET License_Id = ?, UserName = ?, ApplicationName = ?, Renewed_Date = ?, Renewal_Date = ? WHERE License_Id = ?";

	            // Prepare statement
	            myStatement = myConnection.prepareStatement(sql);

	            // Set parameters
	            myStatement.setString(1, UpdatedLicense.getLicense_Id());
	            myStatement.setString(2, UpdatedLicense.getUserName());
	            myStatement.setString(3, UpdatedLicense.getApplicationName());
	            myStatement.setString(4, UpdatedLicense.getRenewed_Date());
	            myStatement.setString(5, UpdatedLicense.getRenewal_Date());
	            myStatement.setString(6, UpdatedLicense.getLicense_Id());

	            // Execute SQL statement
	            myStatement.execute();
	        } else {
	            System.out.println("Renewal date must be greater than the renewed date.");
	        }
	    } catch (SQLException | ParseException e) {
	        // Handle exceptions (log, provide user feedback, etc.)
	        e.printStackTrace();
	    } finally {
	        // Clean up JDBC objects
	        close(myConnection, myStatement, null);
	    }
	}
	public Application LoadDetailsForRenewal(String license_id, String username) throws Exception {
		Application DetailsForLoad;
		Connection myConnection = null;
		PreparedStatement myStatement = null;
		ResultSet mySet = null;
		String enteredlicenseid, enteredusername;
		try {
			// convert student id to int
			enteredlicenseid = license_id;
			enteredusername = username;
			// get connection to database
			myConnection = dataSource.getConnection();

			// create sql to get selected student
			String sql = "select * from ApplicationDetails where License_Id=? and UserName=?";

			// create prepared statement
			myStatement = myConnection.prepareStatement(sql);

			// set params
			myStatement.setString(1, enteredlicenseid);
			myStatement.setString(2, enteredusername);

			// execute statement
			mySet = myStatement.executeQuery();

			// retrieve data from result set row
			if (mySet.next()) {

				String License_Id = mySet.getString("License_Id");
				String UserName = mySet.getString("UserName");
				String ApplicationName = mySet.getString("ApplicationName");
				String Renewed_date = mySet.getString("Renewed_date");
				String Renewal_Date = mySet.getString("Renewal_Date");

				// use the studentId during construction
				DetailsForLoad = new Application(License_Id, UserName, ApplicationName, Renewed_date, Renewal_Date);
			} else {
				throw new Exception(
						"Could not find License_Id: " + enteredlicenseid + "And UserName" + enteredusername);
			}

			return DetailsForLoad;
		} finally {
			// clean up JDBC objects
			close(myConnection, myStatement, mySet);
		}
	}

	public void ApplicationRenewalHistory(History updatedLicense) throws SQLException {
		Connection mConnection = null;
		PreparedStatement myStatement = null;
		try {
			mConnection = dataSource.getConnection();
			String sql = "INSERT INTO HistoryDetails (License_Id, UserName,ApplicationName, Renewed_Date, Renewal_Date) VALUES (?,?,?, ?, ?)";
			myStatement = mConnection.prepareStatement(sql);
			myStatement.setString(1, updatedLicense.getLicense_Id());
			myStatement.setString(2, updatedLicense.getUserName());
			myStatement.setString(3, updatedLicense.getApplicationName());
			myStatement.setString(4, updatedLicense.getRenewed_Date());
			myStatement.setString(5, updatedLicense.getRenewal_Date());

			myStatement.execute();
		} finally {
			close(mConnection, myStatement, null);
		}
	}

	public List<Admin> AdminApplications() throws Exception {

		List<Admin> ApplicationList = new ArrayList<>();
		Connection myConnection = null;
		Statement myStatement = null;
		ResultSet myset = null;

		try {

			myConnection = dataSource.getConnection();
			String sql = "SELECT * FROM ApplicationList";
			Statement statement = myConnection.createStatement();
			myset = statement.executeQuery(sql);

			while (myset.next()) {
				String License_Id = myset.getString("License_Id");
				String ApplicationName = myset.getString("ApplicationName");
				String Purchase_Date = myset.getString("Purchase_Date");

				Admin TemporaryList = new Admin(License_Id, ApplicationName, Purchase_Date);
				ApplicationList.add(TemporaryList);
			}

			return ApplicationList;

		}

		finally {
			close(myConnection, myStatement, myset);
		}

	}

	public void AddnewUser(Users UserList) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = dataSource.getConnection();

			String sql = "INSERT INTO UserDetails (userName, firstName, lastName, email, role, password) VALUES (?, ?, ?, ?, ?, ?)";

			myStmt = myConn.prepareStatement(sql);

			myStmt.setString(1, UserList.getUserName());
			myStmt.setString(2, UserList.getFirstName());
			myStmt.setString(3, UserList.getLastName());
			myStmt.setString(4, UserList.getEmail());
			myStmt.setString(5, UserList.getRole());
			String Password = Argon.encrypt(UserList.getPassword());
            myStmt.setString(6, Password);

			myStmt.execute();
		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public List<History> getApplicationHistoryForAdmin(String application_Name) throws Exception {
		List<History> historyOfApplication = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String entereredApplicationName = application_Name;

			connection = dataSource.getConnection();
			String sql = "SELECT * FROM historydetails WHERE  ApplicationName = ?;";
			preparedStatement = connection.prepareStatement(sql);
			// Replace with your dynamic license_id value
			preparedStatement.setString(1, entereredApplicationName);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String License_Id = resultSet.getString("License_Id");
				String UserName = resultSet.getString("UserName");
				String ApplicatioName = resultSet.getString("ApplicationName");
				String Renewed_Date = resultSet.getString("Renewed_Date");
				String Renewal_Date = resultSet.getString("Renewal_Date");

				History history = new History(License_Id, UserName, ApplicatioName, Renewed_Date, Renewal_Date);
				historyOfApplication.add(history);
			}
			return historyOfApplication;
		} finally {
			close(connection, preparedStatement, resultSet);
		}
	}

	public void AddApplicationListbyAdmin(Admin newApplicationList) throws SQLException {

		Connection myConnection = null;

		PreparedStatement myStatement = null;

		try {

			myConnection = dataSource.getConnection();

			String sql = "INSERT INTO applicationlist (License_Id,ApplicationName,Purchase_Date) VALUES (?, ?, ?);";
			myStatement = myConnection.prepareStatement(sql);
			myStatement.setString(1, newApplicationList.getLicense_Id());
			myStatement.setString(2, newApplicationList.getApplicationName());
			myStatement.setString(3, newApplicationList.getPurchase_Date());
			myStatement.execute();

		}

		finally {

			close(myConnection, myStatement, null);

		}

	}

	public List<History> getApplicationHistoryByUser(String userName) throws SQLException {
		List<History> historyOfApplication = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String entereredusername = userName;

			connection = dataSource.getConnection();
			String sql = "SELECT * FROM historydetails WHERE  UserName = ?;";
			preparedStatement = connection.prepareStatement(sql);
			// Replace with your dynamic license_id value
			preparedStatement.setString(1, entereredusername);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String License_Id = resultSet.getString("License_Id");
				String UserName = resultSet.getString("UserName");
				String ApplicationName=resultSet.getString("ApplicationName");
				String Renewed_Date = resultSet.getString("Renewed_Date");
				String Renewal_Date = resultSet.getString("Renewal_Date");

				History history = new History(License_Id, UserName,ApplicationName, Renewed_Date, Renewal_Date);
				historyOfApplication.add(history);
			}
			return historyOfApplication;
		} finally {
			close(connection, preparedStatement, resultSet);
		}

	}

	public List<Application> DropDownForLicense() throws Exception {
		List<Application> License_id = new ArrayList<>();
		Connection myConnection = null;
		Statement myStatement = null;
		ResultSet mySet = null;

		try {
			myConnection = dataSource.getConnection();
			String sql = "SELECT License_Id FROM ApplicationDetails;";
			myStatement = myConnection.createStatement();
			mySet = myStatement.executeQuery(sql);

			while (mySet.next()) {

				String License_Id = mySet.getString("License_Id");

				Application tempUser = new Application(License_Id);

				License_id.add(tempUser);
			}
			System.out.println(License_id);

			return License_id;
		} finally {
			close(myConnection, myStatement, mySet);
		}

	}

	public List<Application> DropDownForApplicationName() {

		return null;
	}

	public List<History> GetHistoryOfIntervals(String start_Date, String end_Date,String applicationName) throws Exception {
		List<History> IntervalOfDetails = new ArrayList<>();
		Connection myConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet mySet = null;

		try {
		    String start_date = start_Date;
		    String end_date = end_Date;
		    String applicationname = applicationName;
		    myConnection = dataSource.getConnection();
		    String sql = "SELECT * FROM HistoryDetails WHERE ApplicationName=? AND Renewed_Date BETWEEN ? AND ?";
		    preparedStatement = myConnection.prepareStatement(sql);
		    preparedStatement.setString(1, applicationname);
		    preparedStatement.setString(2, start_date);
		    preparedStatement.setString(3, end_date);

		    mySet = preparedStatement.executeQuery();

		    while (mySet.next()) {
		        String License_Id = mySet.getString("License_Id");
		        String UserName = mySet.getString("UserName");
		        String ApplicationName = mySet.getString("ApplicationName");
		        String Renewed_Date = mySet.getString("Renewed_Date");
		        String Renewal_Date = mySet.getString("Renewal_Date");

		        History Details = new History(License_Id, UserName, ApplicationName, Renewed_Date, Renewal_Date);
		        IntervalOfDetails.add(Details);
		    }
		    System.out.println("database" + IntervalOfDetails);

		    return IntervalOfDetails;
		} finally {
		    close(myConnection, preparedStatement, mySet);
		}
	}
	public Map<String, String> DropDownForLicenseIdMap() throws SQLException {
	    Map<String, String> licenseIdToAppNameMap = new HashMap<>();
	    Connection myConnection = null;
	    Statement myStatement = null;
	    ResultSet mySet = null;
	    try {
	        myConnection = dataSource.getConnection();
	        String sql = "SELECT License_Id, ApplicationName FROM applicationlist;";
	        myStatement = myConnection.createStatement();
	        mySet = myStatement.executeQuery(sql);
	        while (mySet.next()) {
	            String License_Id = mySet.getString("License_Id");
	            String ApplicationName = mySet.getString("ApplicationName");
	            licenseIdToAppNameMap.put(License_Id, ApplicationName);
	        }
	        System.out.println(licenseIdToAppNameMap);
	        return licenseIdToAppNameMap;
	    } finally {
	        close(myConnection, myStatement, mySet);
	    }
	}
}


