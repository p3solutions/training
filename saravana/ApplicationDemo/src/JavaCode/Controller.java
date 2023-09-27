package JavaCode;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

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
		// TODO Auto-generated method stub

		try {
			String theCommand = request.getParameter("command");

			if (theCommand == null) {
				theCommand = "LOGIN";
			}

			switch (theCommand) {
			case "LOGIN":
				loginAuthentication(request, response);
				break;
			case "ADMINAPPLICATIONS":
				AdminApplicationList(request, response);
				break;
			case "ADDUSER":
				NewUserByAdmin(request, response);
				break;
			case "ADDAPPLICATIONBYADMIN":
				NewApplicationbyAdmin(request, response);
				break;
			case "APPLICATIONHISTORYBYADMIN":
				ApplicationHistoryForAdmin(request, response);
				break;
			case "FILTER":
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
				ApplicationRenewalByUser(request, response);
				break;
			case "HISTORY":
				ApplicationHistory(request, response);
				break;
			case "DROPDOWNFORLICENCEID":
				DropdwnforLicenceIdMap(request, response);
				break;
			case "SHOWHISTORY":
				ShowHistoryBetweenIntervals(request, response);
				break;
			case "EXPORT":
				exportHistoryToPdf(request, response);
				break;

			default:
				loginAuthentication(request, response);
			}
		} catch (Exception exc) {
			throw new ServletException(exc);
		}
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

	private void exportHistoryToPdf(HttpServletRequest request, HttpServletResponse response) {
		try {
			String ApplicationName = request.getParameter("ApplicationName");
			List<History> historyData = userdatabase.getHistoryData(ApplicationName);
			OutputStream outputStream = response.getOutputStream();
			response.setHeader("Content-Disposition", "attachment; filename=HistoryDetails.pdf");
			Document document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);
			String watermarkImagePath = "C:\\Users\\Dell 5420\\eclipse-workspace\\ApplicationDemo\\webContent\\images\\logo4.png"; // Update
																																	// this
																																	// with
																																	// the
																																	// actual
																																	// path
			Image watermarkImage = Image.getInstance(watermarkImagePath);
			writer.setPageEvent(new PdfPageEventHelper() {
				public void onEndPage(PdfWriter writer, Document document) {
					float pdfPageWidth = document.getPageSize().getWidth();
					float pdfPageHeight = document.getPageSize().getHeight();
					PdfContentByte contentByte = writer.getDirectContentUnder();
					watermarkImage.setAbsolutePosition((pdfPageWidth - watermarkImage.getScaledWidth()) / 2,
							(pdfPageHeight - watermarkImage.getScaledHeight()) / 2);
					try {
						contentByte.addImage(watermarkImage);
					} catch (DocumentException e) {
						e.printStackTrace();
					}
				}

				public void onStartPage(PdfWriter writer, Document document) {
					if (writer.getPageNumber() == 1) {
						document.newPage();
						PdfPTable coverPageTable = new PdfPTable(1);
						coverPageTable.setWidthPercentage(100);
						PdfPCell cell = new PdfPCell();
						cell.setBorderWidth(2);
						cell.setHorizontalAlignment(Element.ALIGN_LEFT);
						cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
						cell.setFixedHeight(document.getPageSize().getHeight());
						Paragraph coverPageContent = new Paragraph();
						coverPageContent.setAlignment(Element.ALIGN_CENTER);
						Font boldFont = new Font(Font.FontFamily.HELVETICA, 16, Font.NORMAL);
						coverPageContent.setFont(boldFont);
						coverPageContent.add("Platform3 Solutions \n");
						coverPageContent.add("Renewal History of  " + ApplicationName + "\n");
						coverPageContent.add("Generated Date-Time: "
								+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\n");
						cell.addElement(coverPageContent);
						coverPageTable.addCell(cell);
						try {
							document.add(coverPageTable);
						} catch (DocumentException e) {
							e.printStackTrace();
						}
						document.newPage();
					} else {
						// System.out.println("else");

//	                	 For pages other than the first page, add the header table as before
//	                   	PdfPTable headerTable = new PdfPTable(5);
//	                   	System.out.println("Hai hello");
//	                    headerTable.setWidthPercentage(80);
//	                    headerTable.addCell("Application Name");
//	                    headerTable.addCell("Username");
//	                    headerTable.addCell("License ID");
//	                    headerTable.addCell("Renewed Date");
//	                    headerTable.addCell("Renewal Date");
//
//	                    try {
//	                        document.add(headerTable);
//	                    } catch (DocumentException e) {
//	                        e.printStackTrace();
//	                    }
					}
				}
			});
			document.open();
			boolean isnewpage = true;
			PdfPTable table = new PdfPTable(5);
			table.setWidthPercentage(100);
			int batchSize = 46;
			int rowCount = 0;
			for (History history : historyData) {
				if (rowCount % batchSize == 0) {
					if (rowCount > 0) {
						document.add(table);
						document.newPage();
						table = new PdfPTable(5);
						table.setWidthPercentage(100);
					}

					if (isnewpage) {
						PdfPTable headerTable = new PdfPTable(5);
						headerTable.setWidthPercentage(100);
						headerTable.setHorizontalAlignment(PdfPTable.ALIGN_CENTER);
						headerTable.addCell("Application Name");
						headerTable.addCell("Username");
						headerTable.addCell("License ID");
						headerTable.addCell("Renewed Date");
						headerTable.addCell("Renewal Date");
						document.add(headerTable);
					}
				}
				table.addCell(history.getApplicationName());
				table.addCell(history.getUserName());
				table.addCell(history.getLicense_Id());
				table.addCell(history.getRenewal_Date());
				if (rowCount == historyData.size() || rowCount % batchSize == 0) {
					document.add(table);
					if (rowCount != historyData.size()) {
						document.newPage();
						table = new PdfPTable(5);
						table.setWidthPercentage(100);
					}
				}
			}
			document.close();
			outputStream.flush();
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void ShowHistoryBetweenIntervals(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String start_Date = request.getParameter("Start_Date");
		String end_Date = request.getParameter("End_Date");
		String applicationName = request.getParameter("ApplicationName");
		System.out.println("Application name" + applicationName);
		List<History> RenewalDetails = userdatabase.GetHistoryOfIntervals(start_Date, end_Date, applicationName);
		// place student in the request attribute
		request.setAttribute("RenewalDetails", RenewalDetails);

		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/FilteredHistory.jsp");
		dispatcher.forward(request, response);

	}

	private void ApplicationHistoryForAdmin(HttpServletRequest request, HttpServletResponse response)
			throws Exception, Exception {
		String application_Name = request.getParameter("Application_Name");

		List<History> ApplicationHistory = userdatabase.getApplicationHistoryForAdmin(application_Name);
		request.setAttribute("HistoryOfApplication", ApplicationHistory);
		RequestDispatcher dispatcher = request.getRequestDispatcher("History.jsp");
		dispatcher.forward(request, response);
	}

	private void NewUserByAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("userName");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String role = request.getParameter("role");
		String password = request.getParameter("password");
		Users UserList = new Users(username, firstName, lastName, email, role, password);
		userdatabase.AddnewUser(UserList);
		AdminApplicationList(request, response);

	}

	private void NewApplicationbyAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String License_Id = request.getParameter("license_Id");

		String ApplicationName = request.getParameter("applicationname");

		String Purchase_Date = request.getParameter("purchase_Date");

		Admin NewApplicationList = new Admin(License_Id, ApplicationName, Purchase_Date);

		userdatabase.AddApplicationListbyAdmin(NewApplicationList);

		AdminApplicationList(request, response);
	}

	private void AdminApplicationList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, Exception {

		List<Admin> ApplicationlistOfAdmin = userdatabase.AdminApplications();
		request.setAttribute("ApplicationList", ApplicationlistOfAdmin);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminPage.jsp");
		dispatcher.forward(request, response);
	}

	private void LoadAppliationDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String license_id = request.getParameter("License_Id");
		String username = request.getParameter("UserName");
		Application AppliationDetails = userdatabase.LoadDetailsForRenewal(license_id, username);

		request.setAttribute("ApplicationDetailsForLoad", AppliationDetails);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Update.jsp");
		dispatcher.forward(request, response);
	}

	private void ApplicationRenewalHistory(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String License_Id = request.getParameter("License_Id");

		String UserName = request.getParameter("UserName");
		String ApplicationName = request.getParameter("ApplicationName");
		String Renewed_Date = request.getParameter("Renewed_Date");
		String Renewal_Date = request.getParameter("Renewal_Date");

		History UpdatedLicense = new History(License_Id, UserName, ApplicationName, Renewed_Date, Renewal_Date);
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
		String License_Id = request.getParameter("license_Id");
		String ApplicationName = request.getParameter("applicationName");
		String UserName = request.getParameter("UserName");
		String Renewed_Date = request.getParameter("renewed_date");
		String Renewal_Date = request.getParameter("renewal_date");
		Application NewApplication = new Application(License_Id, UserName, ApplicationName, Renewed_Date, Renewal_Date);
		userdatabase.AddApplication(NewApplication);

		FilterByUserName(request, response);

	}

	private void ApplicationHistory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String userName = request.getParameter("UserName");
		String license_Id = request.getParameter("License_Id");
		String applicationName = request.getParameter("ApplicationName");

		List<History> FilteredHistory = userdatabase.getApplicationHistory(userName, license_Id, applicationName);
		request.setAttribute("HistoryOfApplication", FilteredHistory);
		RequestDispatcher dispatcher = request.getRequestDispatcher("HistoryForUser.jsp");
		dispatcher.forward(request, response);
	}

	private void FilterByUserName(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String userName = request.getParameter("UserName");

		List<Application> FilteredDetails = userdatabase.getApplicationDetails(userName);

		request.setAttribute("ApplicationByUser", FilteredDetails);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/app.jsp");
		dispatcher.forward(request, response);

	}

	private void loginAuthentication(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("UserName");
		String password = request.getParameter("Password");
		List<Users> users = userdatabase.getuserdetailsforauthentication();

		if (password != null) {
			String EncryptedPassword = Argon.encrypt(password);
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
					request.getSession().setAttribute("UserName", authenticatedUser.getUserName()); // Store username in
																									// session
					RequestDispatcher dispatcher = request.getRequestDispatcher("AdminPage.jsp");
					AdminApplicationList(request, response);
					dispatcher.forward(request, response);
				} else {
					request.getSession().setAttribute("UserName", authenticatedUser.getUserName()); // Store username in
																									// session
					RequestDispatcher dispatcher = request.getRequestDispatcher("app.jsp");
					FilterByUserName(request, response);
					dispatcher.forward(request, response);
				}
			} else {
				request.setAttribute("errorMessage", "Incorrect username or password");
				RequestDispatcher dispatcher = request.getRequestDispatcher("BasicLoginPage.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			// Check for sign-out command
			String signOutCommand = request.getParameter("command");

			System.out.println("verification");
			if ("SIGNOUT".equals(signOutCommand)) {
				// Invalidate the session
				request.getSession().invalidate();
				System.out.println("hello buddy cool");
				// Disable caching
				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
				response.setHeader("Pragma", "no-cache"); // HTTP 1.0
				response.setDateHeader("Expires", 0); // Proxies

				// Redirect to the login page
				response.sendRedirect("BasicLoginPage.jsp"); // Adjust the URL as needed
			} else {
				// Disable caching
				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
				response.setHeader("Pragma", "no-cache"); // HTTP 1.0
				response.setDateHeader("Expires", 0); // Proxies

				// Forward to the login page
				RequestDispatcher dispatcher = request.getRequestDispatcher("BasicLoginPage.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

}
