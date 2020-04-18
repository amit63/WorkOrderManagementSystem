package workordersystem.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import workordersystem.model.report;
import workordersystem.model.reportErrorMsgs;
import workordersystem.util.SQLConnection;
public class reportDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();

	
	public static void insertMAR (report write_mar) {


		//System.out.println(reg.getUtaId());
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
/*		System.out.println("after conncetion write mar");
		System.out.println(write_mar.getFacilityType());
		System.out.println(write_mar.getFacilityName());
		System.out.println(write_mar.getDescription());
		System.out.println(write_mar.getReportedby());
		System.out.println(write_mar.getReportedDate());
		System.out.println(write_mar.getUrgency());*/
		try {
			stmt = conn.createStatement();
			//String insertCompany =   "insert into profile(idcompany,company_name) values('"+x+"','"+y+"')";
			String insertprofile =   "insert into action_report(facilitytype,facilityname,description,reportedby,reporteddate,urgency)"
					+ " values('"+write_mar.getFacilityType()+"','"+write_mar.getFacilityName()+"','"+write_mar.getDescription()+"','"+write_mar.getReportedby()+"','"
					+write_mar.getReportedDate()+"','"+write_mar.getUrgency()+"')";
			stmt.execute(insertprofile);	
			conn.commit(); 
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	
	
	public static String assignMAR (report assign_mar) {



		System.out.println(assign_mar.getAssignedTo());
		System.out.println(assign_mar.getAssignedDate());
		System.out.println(assign_mar.getMarNumber());
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		int total = 0;
		String check = null;
		try {
			
			stmt = conn.createStatement();
			//String insertCompany =   "insert into profile(idcompany,company_name) values('"+x+"','"+y+"')";

			String countmar = "SELECT COUNT(*) AS total FROM action_report WHERE assignedto='"+assign_mar.getAssignedTo()+"' AND assigneddate='"+assign_mar.getAssignedDate()+"'";
			//stmt.execute(countmar);
			
			ResultSet rs = stmt.executeQuery(countmar);
			while(rs.next()) {
				
				total = rs.getInt("total");
			}
			
			conn.commit(); 
			System.out.println(total);
			if (total < 26)
			{
			stmt = conn.createStatement();
			String assignmar = "update action_report set assignedto='"+assign_mar.getAssignedTo()+"', assigneddate='"+assign_mar.getAssignedDate()+
			"', estimateofrepair='"+assign_mar.getEstimateOfRepair()+"' where mar_number='"+assign_mar.getMarNumber()+"'";
			
			System.out.println("After query");
			stmt.execute(assignmar);	
			conn.commit(); }
			else {
				//reportErrorMsgs senderror = new reportErrorMsgs();
				//senderror.setFiveMARError("5 Assigned already");
				check = "five";
				System.out.println("Error");
				//url="/assign_mar.jsp";
			}
			

		} catch (SQLException e) {
			//System.out.println(e);
		}
		
		return check;
	}

	
	}
	
	
	
	
