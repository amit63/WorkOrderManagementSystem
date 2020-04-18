package workordersystem.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import workordersystem.model.reservation;
import workordersystem.util.SQLConnection;
public class reservationDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();
	

	
	
	
	public static void requestReserve (reservation request_reserve) {

		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
					
			String updatestatus = "update action_report set status='Resolved' where mar_number='"+request_reserve.getMarNumber()+"'";
			stmt.execute(updatestatus);	
			
			conn.commit(); 
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	

	
	/*public static void  modifyreserve(reservation modify_reserve) {
		

		System.out.println("Before update conncetion");
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		System.out.println("login after update conncetion lol");
		//System.out.println(modify_reserve.getUser());
		try {
			stmt = conn.createStatement();

					
			String modifyingreserve =   "update reservation set intervalto ='"+ modify_reserve.getInterval()+"' where reservationid='"+modify_reserve.getReservationNumber()+"'";
			
			
			stmt.execute(modifyingreserve);


			System.out.println("exceuted");
			conn.commit(); 
		} catch (SQLException e) {
			System.out.println("failed");
			System.out.println(e);
		}
		


	}
	
	
	public static void  deletereserve(reservation delete_reserve) {
		

		System.out.println("Before update conncetion");
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		System.out.println("login after update conncetion lol");
		//System.out.println(delete_reserve.getUser());
		try {
			stmt = conn.createStatement();

					
			String modifyingreserve =   "delete from reservation where reservationid='"+delete_reserve.getReservationNumber()+"'";
			
			
			stmt.execute(modifyingreserve);


			System.out.println("exceuted");
			conn.commit(); 
		} catch (SQLException e) {
			System.out.println("failed");
			System.out.println(e);
		}
		


	}
	*/
	
	
	
	
	
	
	
}