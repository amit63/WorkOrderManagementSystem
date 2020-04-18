package workordersystem.model;

import java.util.Calendar;
import java.util.Date;

public class facility {

	private static String facilitytype;
	private static String facilityname;
	private static String urgency;
	private static String description;
	private static String reportedby;
	private static String reporteddate;
	
	private static String marnumber;
	private static String assignedto;
	private static String assigneddate;
	private static String estimateofrepair;
	private static String interval;
	private static String repairdate;
	private static String venue;
	private static String repairer;
	private static String reservationnumber;
	private static String facilitydate;
	
	
	public void setAddFacility(String facilitytype,String facilityname,String interval,String venue) 
	{
	
		setFacilityType(facilitytype);
		setFacilityName(facilityname);
		setInterval(interval);
		setVenue(venue);
	}
	
		
	
	

	
	public void setViewSpecificFacility(String facilitytype,String facilityname) 
	{
		setFacilityType(facilitytype);
		setFacilityName(facilityname);
	}
	

	
	public void setFacilityType(String facilitytype) {
		this.facilitytype=facilitytype;
		}
		

	
	
	
	
	public String getFacilityType() {
		return facilitytype;
	}
	
	public void setFacilityName(String facilityname) {
		this.facilityname=facilityname;
		
	}
	public String getFacilityName() {
		return facilityname;
	}

	
	
	public void setInterval(String interval) {
		this.interval=interval;
		
	}
	public String getInterval() {
		return interval;
	}

	public void setVenue(String venue) {
		this.venue=venue;
		
	}
	public String getVenue() {
		return venue;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void validateFacility (String action, facility add_facility, facilityErrorMsgs errorMsgs) {
		
		
		//System.out.println("Validate facility");
		
		/*if (action.equals("addfacility")) {*/
			//System.out.println("addfaclity");
			errorMsgs.setFacilityNameError(validateFacilityName(add_facility.getFacilityName()));
			errorMsgs.setFacilityTypeError(validateFacilityType(add_facility.getFacilityType()));
			errorMsgs.setErrorMsg();

	}

	

private static String validateFacilityName(String facilityname) {
String result="";

//System.out.println("Before");
if (facilityname.equals("")) {
	//System.out.println("Before here");
	result= "this field required";
}
	else {

if (!stringSize(facilityname,3,7)) {
	result= "Facility Name must between 3 and 7 characters";
}
else
	if(Character.isLowerCase(facilityname.charAt(0))) {
		result="Your Facility Name must start with a Uppercase";
	}

}
return result;		
}


private static String validateFacilityType(String facilitytype) {
String result="";

//System.out.println("Before");
if (facilitytype.equals("")) {
	//System.out.println("Before here");
	result= "this field required";
}
	else {

if (!stringSize(facilitytype,5,50)) {
	result= "Facility Type must between 5 and 50 characters";
}
else
	if (Character.isLowerCase(facilitytype.charAt(0))) {
		result="Your Facility Type must start with a Uppercase";
	}

}
return result;		
}

private static boolean stringSize(String string, int min, int max) {
return string.length()>=min && string.length()<=max;
}




}

