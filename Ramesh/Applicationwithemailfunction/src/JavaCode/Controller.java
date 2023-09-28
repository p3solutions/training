package JavaCode;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDatabase userdatabase;

	@Resource(name = "jdbc/Application")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();

		try {
			userdatabase = new UserDatabase(dataSource);
		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String theCommand = request.getParameter("command");

			if (theCommand == null) {
				theCommand = "LOGIN";
			}

			switch (theCommand) {
			case "LOGIN":
				loginAuthentication(request, response);
				break;
			case"ADMINAPPLICATIONS":
				AdminApplicationList(request,response);
				break;
			case "ADDUSER":
				NewUserByAdmin(request,response);
				break;
			case "ADDAPPLICATIONBYADMIN":
				NewApplicationbyAdmin(request,response);
				break;
			case "APPLICATIONHISTORYBYADMIN":
				ApplicationHistoryForAdmin(request,response);
				break;
			case "FILTER":
				System.out.println("FILTER");
				FilterByUserName(request, response);
				break;
			case "ADDAPPLICATIONBYUSER":
				AddnewApplication(request, response);
				break;
			case "DELETEAPPLICATION":
				DeleteApplicationByUser(request, response);
				break;
			case "LOADAPPLICATION":
				LoadAppliationDetails(request, response);
				break;
			case "APPLICATIONRENEWAL":
				System.out.println("APPLICATIONRENEWAL");
				ApplicationRenewalByUser(request, response);
				break;
			case "HISTORY":
				ApplicationHistory(request, response);
				break;
			case "DROPDOWNFORLICENCEID":
				System.out.println("DROPDOWNFORLICENCEID");
				DropdwnforLicenceIdMap(request, response);
				break;
			case "MAILFORADD":
				System.out.println("MAILFORADD");
				MailforAdd(request, response);
				break;
			case "MAILFORUPDATE" : 
				System.out.println("MAILFORUPDATE");
				MailforUpdate(request,response);
				break;
			
//			case "DropDownFORLicense_Id":
//				GetLicenseDropDown(request,response);
//				break;
//			case "DropDownFORApplicationName":
//				GetApplicationNameForDropDown(request,response);
//				break;
			case "SHOWHISTORY":
				ShowHistoryBetweenIntervals(request,response);
				break;
			default:
				loginAuthentication(request, response);
			}
		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	private void MailforUpdate(HttpServletRequest request, HttpServletResponse response) throws SQLException {
//		System.out.println("MailforUpdate");
		String License_Id = request.getParameter("License_Id");
//		System.out.println(License_Id);
		String Applicationname = request.getParameter("ApplicationName");
//		System.out.println(Applicationname);
		String UserName = request.getParameter("UserName");
//		System.out.println(UserName);
		String Renewed_Date = request.getParameter("Renewed_Date");
//		System.out.println(Renewed_Date);
		String Renewal_Date = request.getParameter("Renewal_Date");
//		System.out.println(Renewal_Date);
		String Review = request.getParameter("review");
		
		userdatabase.mailforupdate(License_Id,Applicationname,UserName,Renewed_Date,Renewal_Date,Review);
		
	}

	protected void MailforAdd(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
//		String usermailId = request.getParameter("UserMailId");
		String License_Id = request.getParameter("license_Id");
		String Applicationname = request.getParameter("applicationname");
		String userName = request.getParameter("UserName");
		
		userdatabase.mailforadd(License_Id, Applicationname,userName);
		
	}
	
	protected void DropdwnforLicenceIdMap(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Map<String, String> licenseIdToAppNameMap = userdatabase.DropDownForLicenseIdMap();
			request.setAttribute("licenseIdToAppNameMap", licenseIdToAppNameMap);
			RequestDispatcher dispatcher = request.getRequestDispatcher("AddApplication.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void ShowHistoryBetweenIntervals(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			
			String start_Date = request.getParameter("Start_Date");			
			String end_Date = request.getParameter("End_Date");
			String applicationName=request.getParameter("ApplicationName");
			System.out.println("Application name"+applicationName);
			List<History> RenewalDetails = userdatabase.GetHistoryOfIntervals(start_Date,end_Date,applicationName);
			// place student in the request attribute
			request.setAttribute("RenewalDetails", RenewalDetails);

			// send to jsp page: update-student-form.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("/FilteredHistory.jsp");
			dispatcher.forward(request, response);
			
		}
		


//	private void GetApplicationNameForDropDown(HttpServletRequest request, HttpServletResponse response) throws Exception, Exception {
//		
//		List<Application> FilteredDetails = userdatabase.DropDownForApplicationName();
//
//		request.setAttribute("ApplicationNameDropDown", FilteredDetails);
//
//		RequestDispatcher dispatcher = request.getRequestDispatcher("app.jsp");
//		dispatcher.forward(request, response);
//		
//	}
//
//	private void GetLicenseDropDown(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
//		List<Application> FilteredDetails = userdatabase.DropDownForLicense();
//
//		request.setAttribute("ApplicationByUser", FilteredDetails);
//
//		RequestDispatcher dispatcher = request.getRequestDispatcher("App.jsp");
//		dispatcher.forward(request, response);
//		
//	}

	

	private void ApplicationHistoryForAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception, Exception {
		String application_Name = request.getParameter("Application_Name");

		List<History> ApplicationHistory = userdatabase.getApplicationHistoryForAdmin( application_Name);
		request.setAttribute("HistoryOfApplication", ApplicationHistory);
		RequestDispatcher dispatcher = request.getRequestDispatcher("History.jsp");
		dispatcher.forward(request, response);	
	}

	private void NewUserByAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String  username= request.getParameter("userName");

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String role = request.getParameter("role");
		String password = request.getParameter("password");

		// create a new student object
		Users UserList = new Users(username, firstName,  lastName, email, role, password);
		// add the student to the database
		userdatabase.AddnewUser(UserList);
		AdminApplicationList(request,response);
		
	}

	private void NewApplicationbyAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String License_Id= request.getParameter("license_Id");
			String ApplicationName= request.getParameter("applicationname");
			String Purchase_Date= request.getParameter("purchase_Date");

			Admin NewApplicationList = new Admin(License_Id, ApplicationName, Purchase_Date);
			System.out.println("NewApplicationList : "+NewApplicationList);
			userdatabase.AddApplicationListbyAdmin(NewApplicationList);
			AdminApplicationList(request, response);
		}
	private void AdminApplicationList(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		
		List<Admin> ApplicationlistOfAdmin = userdatabase.AdminApplications();
		request.setAttribute("ApplicationList",ApplicationlistOfAdmin );

		RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminPage.jsp");
		dispatcher.forward(request, response);

		
	}

	private void LoadAppliationDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String license_id = request.getParameter("License_Id");
		String username = request.getParameter("UserName");
//		String ApplicationName=request.getParameter("ApplicationName");
		Application AppliationDetails = userdatabase.LoadDetailsForRenewal(license_id, username);

		// place student in the request attribute
		request.setAttribute("ApplicationDetailsForLoad", AppliationDetails);
		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Update.jsp");
		dispatcher.forward(request, response);
	}

	private void ApplicationRenewalHistory(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String License_Id = request.getParameter("License_Id");

		String UserName = request.getParameter("UserName");
		String ApplicationName=request.getParameter("ApplicationName");
		String Renewed_Date = request.getParameter("Renewed_Date");
		String Renewal_Date = request.getParameter("Renewal_Date");

		History UpdatedLicense = new History(License_Id,  UserName,ApplicationName ,Renewed_Date, Renewal_Date);
		userdatabase.ApplicationRenewalHistory(UpdatedLicense);
		FilterByUserName(request, response);

	}

	private void ApplicationRenewalByUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String License_Id = request.getParameter("License_Id");
		String UserName = request.getParameter("UserName");
		String ApplicationName = request.getParameter("ApplicationName");

		String Renewed_Date = request.getParameter("Renewed_Date");
		String Renewal_Date = request.getParameter("Renewal_Date");

		Application UpdatedLicense = new Application(License_Id, UserName, ApplicationName, Renewed_Date, Renewal_Date);
		userdatabase.ApplicationRenewalByUser(UpdatedLicense);
		MailforUpdate(request,response);
		ApplicationRenewalHistory(request, response);
		FilterByUserName(request, response);

	}

	private void DeleteApplicationByUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String applicationName = request.getParameter("ApplicationName");
		String username = request.getParameter("UserName");
		// delete the student from the database
		userdatabase.DeleteApplicationByUser(applicationName, username);
		// send them to list students
		FilterByUserName(request, response);
	}

	private void AddnewApplication(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
		String License_Id = request.getParameter("license_Id");
		String ApplicationName = request.getParameter("applicationname");
		String UserName = request.getParameter("UserName");
		String Renewed_Date = request.getParameter("renewed_date");
		String Renewal_Date = request.getParameter("renewal_date");
System.out.println(UserName);
		Application NewApplication = new Application(License_Id, UserName, ApplicationName, Renewed_Date, Renewal_Date);
		userdatabase.Addapplication(NewApplication);
		MailforAdd(request, response);
		FilterByUserName(request, response);
		}
		catch (SQLException e) {
			System.out.println("Error");
			request.setAttribute("errorMessage", "Enter New Application Data, Your given Already Existed data");

			RequestDispatcher dispatcher = request.getRequestDispatcher("AddApplication.jsp");

			dispatcher.forward(request, response);
        }
	}

	private void ApplicationHistory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String userName = request.getParameter("UserName");
		String license_Id = request.getParameter("License_Id");
		String applicationName=request.getParameter("ApplicationName");

		List<History> FilteredHistory = userdatabase.getApplicationHistory(userName, license_Id,applicationName);
		request.setAttribute("HistoryOfApplication", FilteredHistory);
		RequestDispatcher dispatcher = request.getRequestDispatcher("HistoryForUser.jsp");
		dispatcher.forward(request, response);
	}

	private void FilterByUserName(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Filter");
		String userName = request.getParameter("UserName");

		List<Application> FilteredDetails = userdatabase.getApplicationDetails(userName);

		request.setAttribute("ApplicationByUser", FilteredDetails);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/app.jsp");
		dispatcher.forward(request, response);

	}

	private void loginAuthentication(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("UserName");
		String password = request.getParameter("Password");
		System.out.println("Password: "+ password);
		List<Users> users = userdatabase.getuserdetailsforauthentication();
		if(password != null) {
			String EncryptedPassword = Argon.encrypt(password);
			System.out.println("EncryptedPassword : "+EncryptedPassword);
		Users authenticatedUser = null;
		for (Users user : users) {
			if (user.getUserName().equals(username)) {
				authenticatedUser = user;
				break;
			}
		}
		
		if (authenticatedUser != null && authenticatedUser.getPassword().equals(EncryptedPassword)) {
			String UserRole = authenticatedUser.getRole();
			String role = UserRole.toUpperCase();
			if (role.equals("ADMIN")) {
				request.setAttribute("authenticatedUser", authenticatedUser);
				RequestDispatcher dispatcher = request.getRequestDispatcher("AdminPage.jsp");
				AdminApplicationList(request,response);
				dispatcher.forward(request, response);
			}
			else {
				request.setAttribute("confirmedUser", authenticatedUser);
				RequestDispatcher dispatcher = request.getRequestDispatcher("app.jsp");
				FilterByUserName(request, response);
				dispatcher.forward(request, response);
			}

		} else {
			request.setAttribute("errorMessage", "Incorrect username or password");
			RequestDispatcher dispatcher = request.getRequestDispatcher("BasicLoginPage.jsp");
			dispatcher.forward(request, response);
			}
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("BasicLoginPage.jsp");

			dispatcher.forward(request, response);
		}

	}

}

