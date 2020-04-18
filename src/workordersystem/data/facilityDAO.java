package workordersystem.data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import workordersystem.model.facility;
import workordersystem.util.SQLConnection;
public class facilityDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	
	

	
	public static void addFacility (facility add_facility) {

		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			String adddingfacility =   "insert into facilities(facilitytype,facilityname,intervalto,venue)"
					+ " values('"+add_facility.getFacilityType()+"','"+add_facility.getFacilityName()+"','"+add_facility.getInterval()+"','"+add_facility.getVenue()+"')";
			stmt.execute(adddingfacility);	
			conn.commit(); 
		} catch (SQLException e) {
			System.out.println(e);
		}
	}}
	
