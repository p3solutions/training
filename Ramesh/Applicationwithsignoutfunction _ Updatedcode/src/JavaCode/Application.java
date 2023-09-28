package JavaCode;

public class Application{
	private String License_Id;
	private String UserName;
	private String ApplicationName;
	private String Renewed_Date;
	private String Renewal_Date;
	public Application(String license_Id, String userName, String applicationName,String renewed_Date,String renewal_Date) {
		super();
		License_Id = license_Id;
		UserName = userName;
		ApplicationName = applicationName;
		Renewed_Date = renewed_Date;
		Renewal_Date = renewal_Date;
	}
	public Application(String license_Id, String userName, String applicationName) {
		super();
		License_Id = license_Id;
		UserName = userName;
		ApplicationName = applicationName;
	}
	
	
	public Application(String license_Id) {
		super();
		License_Id = license_Id;
	}
	public String getLicense_Id() {
	    return License_Id;
	}
	public void setLicense_Id(String license_Id) {
		License_Id = license_Id;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getApplicationName() {
		return ApplicationName;
	}
	public void setApplicationName(String applicationName) {
		ApplicationName = applicationName;
	}
	
	public String getRenewed_Date() {
		return Renewed_Date;
	}
	public void setRenewed_Date(String renewed_Date) {
		Renewed_Date = renewed_Date;
	}
	public String getRenewal_Date() {
		return Renewal_Date;
	}
	public void setRenewal_Date(String renewal_Date) {
		Renewal_Date = renewal_Date;
	}
	@Override
	public String toString() {
		return "Application [License_Id=" + License_Id + ", UserName=" + UserName + ", ApplicationName="
				+ ApplicationName + ", Renewed_Date=" + Renewed_Date
				+ ", Renewal_Date=" + Renewal_Date + "]";
	}
	
	
}

