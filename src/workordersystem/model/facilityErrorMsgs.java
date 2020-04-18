package workordersystem.model;

public class facilityErrorMsgs {
	private String errorMsg;
	private String facilitynameerror;
	private String facilitytypeerror;
	
	public facilityErrorMsgs() {
		this.errorMsg = "";
		this.facilitynameerror = "";
		this.facilitytypeerror = "";
		
}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
	public void setErrorMsg() {
		if (!facilitynameerror.equals("")||!facilitytypeerror.equals(""))
			this.errorMsg = "Please correct the following errors";
		else {
			this.errorMsg = "";
		}
	}
	public String getFacilityNameError() {
		return facilitynameerror;
	}
	public void setFacilityNameError(String facilitynameerror) {
		this.facilitynameerror = facilitynameerror;
	}
	public String getFacilityTypeError() {
		return facilitytypeerror;
	}
	public void setFacilityTypeError(String facilitytypeerror) {
		this.facilitytypeerror = facilitytypeerror;
	}
	
	
}

