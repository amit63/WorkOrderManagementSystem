package workordersystem.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class report {
	private static String facilitytype;
	private static String facilityname;
	private static String urgency;
	private static String description;
	private static String reportedby;
	private static String reporteddate;
	private static String reporteddate1;
	private static String marnumber;
	private static String assignedto;
	private static String assigneddate;
	private static String estimateofrepair;
	private static String interval;
	private static String repairdate;
	private static String venue;
	private static String repairer;
	private static String reservationnumber;

	public void setMARReport(String facilitytype, String facilityname, String urgency, String description,
			String reportedby, String reporteddate)

	{
		setFacilityType(facilitytype);
		setFacilityName(facilityname);
		setUrgency(urgency);
		setDescription(description);
		setReportedby(reportedby);
		setReportedDate(reporteddate);
	}

	public void setAssignMARReport(String marnumber, String assignedto, String assigneddate, String estimateofrepair)

	{
		setMarNumber(marnumber);
		setAssignedTo(assignedto);
		setAssignedDate(assigneddate);
		setEstimateOfRepair(estimateofrepair);

	}

	public void setSearchMAR(String reporteddate1) {
		setReportedDate1(reporteddate1);
	}

	public void setFacilityType(String facilitytype) {
		this.facilitytype = facilitytype;
	}

	public String getFacilityType() {
		return facilitytype;
	}

	public void setFacilityName(String facilityname) {
		this.facilityname = facilityname;

	}

	public String getFacilityName() {
		return facilityname;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;

	}

	public String getUrgency() {
		return urgency;
	}

	public void setDescription(String description) {
		this.description = description;

	}

	public String getDescription() {
		return description;
	}

	public void setReportedby(String reportedby) {
		this.reportedby = reportedby;

	}

	public String getReportedby() {
		return reportedby;
	}

	public void setReportedDate(String reporteddate) {
		this.reporteddate = reporteddate;

	}

	public String getReportedDate() {
		return reporteddate;
	}

	public void setReportedDate1(String reporteddate1) {
		this.reporteddate1 = reporteddate1;

	}

	public String getReportedDate1() {
		return reporteddate1;
	}

	public void setMarNumber(String marnumber) {
		this.marnumber = marnumber;

	}

	public String getMarNumber() {
		return marnumber;
	}

	public void setAssignedTo(String assignedto) {
		this.assignedto = assignedto;

	}

	public String getAssignedTo() {
		return assignedto;
	}

	public void setAssignedDate(String assigneddate) {
		this.assigneddate = assigneddate;

	}

	public String getAssignedDate() {
		return assigneddate;
	}

	public void setEstimateOfRepair(String estimateofrepair) {
		this.estimateofrepair = estimateofrepair;

	}

	public String getEstimateOfRepair() {
		return estimateofrepair;
	}

	public static void validateDate(String action, report write_mar, reportErrorMsgs errorMsgs) {

		// System.out.println("Validate facility");

		if (action.equals("writemar")) {
			// System.out.println("writemarwritemar");
			errorMsgs.setFacilityDateError(validateFacilityDate(write_mar.getReportedDate()));
			errorMsgs.setFacilityDescriptionError(validateDescription(write_mar.getDescription()));
			errorMsgs.setErrorMsg();
		}

		else if (action.equals("assignmar")) {
			// System.out.println("drrrrrrrrrrrr");
			errorMsgs.setAssignFacilityDateError(validateAssignFacilityDate(write_mar.getAssignedDate()));
			// errorMsgs.setEstimateOfRepairError(isNumeric(assign_mar.getEstimateOfRepair()));
			errorMsgs.setErrorMsg();

		}

		else /* if (action.equals("viewmar")) */ {
			// System.out.println("drrrrrrrrrrrr");
			errorMsgs.setFacilityDateError(validateFacilityDate(write_mar.getReportedDate1()));
			// errorMsgs.setEstimateOfRepairError(isNumeric(assign_mar.getEstimateOfRepair()));
			errorMsgs.setErrorMsg();

		}



	}

	/*
	 * public static void validateAssignDate (String action, report assign_mar,
	 * reportErrorMsgs errorMsgs) { if (action.equals("assignmar")) {
	 * System.out.println("drrrrrrrrrrrr");
	 * errorMsgs.setFacilityDateError(validateAssignFacilityDate(assign_mar.
	 * getAssignedDate()));
	 * //errorMsgs.setEstimateOfRepairError(isNumeric(assign_mar.getEstimateOfRepair
	 * ())); errorMsgs.setErrorMsg();
	 * 
	 * 
	 * }
	 * 
	 * 
	 * }
	 */

	/*
	 * public static void validateEsitimateOfRepair (String action, report
	 * assign_mar, reportErrorMsgs errorMsgs) { if (action.equals("assignmar")) {
	 * System.out.println("deeerrrrrr");
	 * //errorMsgs.setFacilityDateError(validateAssignFacilityDate(assign_mar.
	 * getAssignedDate()));
	 * errorMsgs.setEstimateOfRepairError(isNumeric(assign_mar.getEstimateOfRepair()
	 * )); errorMsgs.setErrorMsg();
	 * 
	 * 
	 * }
	 * 
	 * 
	 * }
	 */

	private static String validateDescription(String description) {
		String result = "";
		// System.out.println("In Validate description");

		if (description.equals("")) {
			// System.out.println("In Validate description empty");
			result = "this field required";
		} else {

			if (!stringSize(description, 3, 100)) {
				result = "Your Description must between 3 and 100 characters";
			}

			else {

				result = "";

			}
		}

		return result;
	}

	private static boolean stringSize(String string, int min, int max) {
		return string.length() >= min && string.length() <= max;
	}

	public static String validateFacilityDate(String reporteddate) {

		String result = "";
		if (reporteddate.equals("")) {
			result = "this field required";

		} else {

			String regex = "^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher((CharSequence) reporteddate);
			boolean res = matcher.matches();
			if (res == false) {
				result = "Please enter a valid date";
			} else {
				result = "";
			}

		}
		return result;
	}

	public static String validateAssignFacilityDate(String assigneddate) {

		String result = "";
		if (assigneddate.equals("")) {
			result = "this field required";

		} else {

			String regex = "^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher((CharSequence) assigneddate);
			boolean res = matcher.matches();
			if (res == false) {
				result = "Pleasse enter a valid date";
			} else {
				result = "";
			}

		}
		return result;
	}


}
