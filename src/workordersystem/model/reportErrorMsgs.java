package workordersystem.model;

public class reportErrorMsgs {

	private String facilitydateerror="";
	private String facilitydecriptionerror="";
	private String errorMsg="";
	private String assignfacilitydateerror="";
	private String estimateofrepairerror = "";
	
	public reportErrorMsgs() {
	this.facilitydateerror = "";
}


public String getErrorMsg() {
	return errorMsg;
}

public void setErrorMsg() {
	//this.errorMsg = "";
		if (!facilitydateerror.equals("") || !facilitydecriptionerror.equals("")
				|| !assignfacilitydateerror.equals("")/* || !estimateofrepairerror.equals("") */)
	{
		this.errorMsg = "Please correct the following errors";
	}
	else {
		this.errorMsg = "";
	}
	
}	
	public String getFacilityDateError() {
		return facilitydateerror;
	}
	public void setFacilityDateError(String facilitydateerror) {
		this.facilitydateerror = facilitydateerror;
	}
	public String getFacilityDescriptionError() {
		return facilitydecriptionerror;
	}
	public void setFacilityDescriptionError(String facilitydecriptionerror) {
		this.facilitydecriptionerror = facilitydecriptionerror;
	}
	
	public String getAssignFacilityDateError() {
		return assignfacilitydateerror;
	}
	
	public void setAssignFacilityDateError(String assignfacilitydateerror) {
		this.assignfacilitydateerror = assignfacilitydateerror;
	}
	
	 public String getEstimateOfRepairError() { return estimateofrepairerror; }
	 
	 public void setEstimateOfRepairError(String estimateofrepairerror) {
	  this.estimateofrepairerror = estimateofrepairerror; }
	 
}