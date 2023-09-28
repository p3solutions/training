package JavaCode;

public class Admin {
	private String License_Id;
	private String ApplicationName;
	private String Purchase_Date;
	public Admin(String license_Id, String applicationName, String purchase_Date) {
		super();
		License_Id = license_Id;
		ApplicationName = applicationName;
		Purchase_Date = purchase_Date;
	}
	
	@Override
	public String toString() {
		return "Admin [License_Id=" + License_Id + ", ApplicationName=" + ApplicationName + ", Purchase_Date="
				+ Purchase_Date + "]";
	}

	public String getLicense_Id() {
		return License_Id;
	}
	
	public void setLicense_Id(String license_Id) {
		License_Id = license_Id;
	}
	public String getApplicationName() {
		return ApplicationName;
	}
	public void setApplicationName(String applicationName) {
		ApplicationName = applicationName;
	}
	public String getPurchase_Date() {
		return Purchase_Date;
	}
	public void setPurchase_Date(String purchase_Date) {
		Purchase_Date = purchase_Date;
	}

}
