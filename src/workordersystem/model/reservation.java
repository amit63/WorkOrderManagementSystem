package workordersystem.model;
public class reservation {
	
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
	
	
	public void setRequestReserve(String marnumber,String facilitytype,String facilityname,String interval,String repairdate,String repairer) 

	{
		setMarNumber(marnumber);
		setFacilityType(facilitytype);
		setFacilityName(facilityname);
		setInterval(interval);
		setRepairdate(repairdate);
		setRepairer(repairer);

	}
	
	
	
	public void setViewSchedule(String repairer) 
	{
		setRepairer(repairer);
	}
	
	
	
	
	public void setModifyReserve(String reservationnumber,String interval) 
	{
		setReservationNumber(reservationnumber);
		setInterval(interval);
	}
	
	public void setDeleteReserve(String reservationnumber) 
	{
		setReservationNumber(reservationnumber);
	}
	
	
	public void setReservationNumber(String reservationnumber) {
		this.reservationnumber=reservationnumber;
		
	}
	
	public String getReservationNumber() {
		return reservationnumber;
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
	

	
	public void setMarNumber(String marnumber) {
		this.marnumber=marnumber;
		
	}
	public String getMarNumber() {
		return marnumber;
	}
	


	
	public void setInterval(String interval) {
		this.interval=interval;
		
	}
	public String getInterval() {
		return interval;
	}
	
	public void setRepairdate(String repairdate) {
		this.repairdate=repairdate;
		
	}
	public String getRepairdate() {
		return repairdate;
	}

	
	public void setRepairer(String repairer) {
		this.repairer=repairer;
		
	}
	public String getRepairer() {
		return repairer;
	}
	



}

