package workordersystem.model;

public class profileErrorMsgs {

	private String errorMsg;
	private String usernameerror;
	private String passworderror;
	private String lastnamerror;
	private String firstnameerror;
	private String phoneerror;
	private String emailerror;
	private String utaiderror;
	private String addresserror;
	private String stateerror;
	private String zipcodeerror;
	private String cityerror;

	
	public profileErrorMsgs() {
		this.errorMsg = "";
		this.usernameerror = "";
		this.passworderror = "";
		this.lastnamerror = "";
		this.firstnameerror = "";
		this.phoneerror = "";
		this.emailerror = "";
		this.utaiderror = "";
		this.addresserror = "";
		this.stateerror = "";
		this.zipcodeerror = "";
		this.cityerror = "";

		
	}

	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg() {
		if (!usernameerror.equals("")||!passworderror.equals("") || !lastnamerror.equals("") || !firstnameerror.equals("") || !phoneerror.equals("")|| 
				!emailerror.equals("") || !utaiderror.equals("") || !addresserror.equals("")|| !zipcodeerror.equals("") )
			this.errorMsg = "Please correct the following errors";
		else {
			this.errorMsg = "";
		}
	}
	
	

	
	
	
	public String getUsernameError() {
		return usernameerror;
	}
	public void setUsernameError(String usernameerror) {
		this.usernameerror = usernameerror;
	}
	public String getPasswordError() {
		return passworderror;
	}
	public void setPasswordError(String passworderror) {
		this.passworderror = passworderror;
	}
	public String getLastNameError() {
		return lastnamerror;
	}
	public void setLastNameError(String lastnamerror) {
		this.lastnamerror = lastnamerror;
	}
	public String getFirstNameError() {
		return firstnameerror;
	}
	public void setFirstNameError(String firstnameerror) {
		this.firstnameerror = firstnameerror;
	}
	public String getPhoneError() {
		return phoneerror;
	}
	public void setPhoneError(String phoneerror) {
		this.phoneerror = phoneerror;
	}
	public String getEmailError() {
		return emailerror;
	}
	public void setEmailError(String emailerror) {
		this.emailerror = emailerror;
	}
	public String getutaidError() {
		return utaiderror;
	}
	public void setutaidError(String utaiderror) {
		this.utaiderror = utaiderror;
	}
	public String getaddressError() {
		return addresserror;
	}
	public void setaddressError(String addresserror) {
		this.addresserror = addresserror;
	}

	/*
	 * public String getStateError() { return stateerror; } public void
	 * setStateError(String stateerror) { this.stateerror = stateerror; }
	 */
	public String getZipcodeError() {
		return zipcodeerror;
	}
	public void setZipcodeError(String zipcodeerror) {
		this.zipcodeerror = zipcodeerror;
	}
	
//	public String getCityError() {
//		return cityerror;
//	}
//	public void setCityError(String cityerror) {
//		this.cityerror = cityerror;
//	}
}
