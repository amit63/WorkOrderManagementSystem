package workordersystem.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import workordersystem.model.profile;
import workordersystem.util.SQLConnection;
public class profileDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();
	

	private static void StoreListinDB (profile reg,String queryString) {

//		System.out.println("before conncetion");
//		System.out.println(reg.getUserName());
//		x = reg.getUserName();
//		y = reg.getPassword();
		//System.out.println(reg.getUtaId());
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		System.out.println("after conncetion");
		try {
			stmt = conn.createStatement();
			//String insertCompany =   "insert into profile(idcompany,company_name) values('"+x+"','"+y+"')";
			String insertprofile =   "insert into profile(username,password,lastname,firstname,phone,email,address,state,zipcode,role)"
					+ " values('"+reg.getUserName()+"','"+reg.getPassword()+"','"+reg.getLastName()+"','"
					+reg.getFirstName()+"','"+reg.getPhone()+"','"+reg.getEmail()+"','"+reg.getAddress()+"','"+
					reg.getState()+"','"+reg.getZipCode()+"','"+reg.getRole()+"')";
			stmt.execute(insertprofile);	
			conn.commit(); 
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static void insertCompany(profile reg) {
		StoreListinDB(reg, "insert" );
	}
	
	public static String checklogin(profile log) {
		
		String role = "no";
		System.out.println("Before after conncetion");
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		System.out.println("login after conncetion");
		int count = 0;
		try {
			stmt = conn.createStatement();
			//String insertCompany =   "insert into profile(idcompany,company_name) values('"+x+"','"+y+"')";
//			String insertprofile =   "insert into profile(uta_id,username,password,lastname,firstname,phone,email,address,state,zipcode,role)"
//					+ " values('"+reg.getUtaId()+"','"+reg.getUserName()+"','"+reg.getPassword()+"','"+reg.getLastName()+"','"
//					+reg.getFirstName()+"','"+reg.getPhone()+"','"+reg.getEmail()+"','"+reg.getAddress()+"','"+
//					reg.getState()+"','"+reg.getZipCode()+"','"+reg.getRole()+"')";
//			stmt.execute(insertprofile);
			String checkprofile = "select role from profile where username='"+log.getUserName1()+"'and password='"+log.getPassword1()+"'";
			ResultSet rs = stmt.executeQuery(checkprofile);
			System.out.println(rs);
			rs.last();
			count = rs.getRow();
			rs.beforeFirst();
			while(rs.next()) {
				
				role = rs.getString("role");
			}
			System.out.println(count);
			conn.commit(); 
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	return role;
	}
	
	
	
	public static String[] viewprofile(profile view_profile) {
		
		String username = null;
		String password = null;
		String lastname = null;
		String firstname = null;
		Long uta_id = 0L;
		Long phone = 0L;
		String email = null;
		String role = null;
		String address = null;
		String state = null;
		String city = null;
		Long zipcode = 0L;
		System.out.println("Before after conncetion");
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		System.out.println("login after conncetion lol");
		System.out.println(view_profile.getUserName());
		try {
			stmt = conn.createStatement();
			String viewprofile = "select * from profile where username='"+view_profile.getUserName()+"'";
//			ResultSet rs = stmt.executeQuery(checkprofile);
//			System.out.println(rs);
//			rs.last();
//			int count = rs.getRow();
//			rs.beforeFirst();
//			System.out.println(count);
			ResultSet rs = stmt.executeQuery(viewprofile);
			while(rs.next()) {
				
				username = rs.getString("username");
				password = rs.getString("password");
				lastname = rs.getString("lastname");
				firstname = rs.getString("firstname");
				uta_id = rs.getLong("uta_id");
				phone = rs.getLong("phone");
				email = rs.getString("email");
				role = rs.getString("role");
				address = rs.getString("address");
				state = rs.getString("state");
				zipcode = rs.getLong("zipcode");		
				//city = rs.getString("city");	
				
			}
			
			System.out.println(firstname);
			//System.out.println(uta_id);
			System.out.println(email);
			System.out.println(zipcode);
			System.out.println("exceuted");
			conn.commit(); 
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		String uta_id1=String.valueOf(uta_id);
		String zipcode1=String.valueOf(zipcode);
		String phone1=String.valueOf(phone);
		String[] profile_list = {username,password,lastname,firstname,uta_id1,phone1,email,role,address,state,zipcode1};
		
		return profile_list;
	}
	
	
	
	
	
	public static String[] viewuserprofile(profile view_user_profile) {
		
		String username = null;
		String password = null;
		String lastname = null;
		String firstname = null;
		Long uta_id = 0L;
		Long phone = 0L;
		String email = null;
		String role = null;
		String address = null;
		String state = null;
		Long zipcode = 0L;
		System.out.println("Before after conncetion");
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		System.out.println("login after conncetion lol");
		System.out.println(view_user_profile.getUser());
		try {
			stmt = conn.createStatement();
			String viewuserprofile = "select * from profile where username='"+view_user_profile.getUser()+"'";

			ResultSet rs = stmt.executeQuery(viewuserprofile);
			while(rs.next()) {
				
				username = rs.getString("username");
				password = rs.getString("password");
				lastname = rs.getString("lastname");
				firstname = rs.getString("firstname");
				uta_id = rs.getLong("uta_id");
				phone = rs.getLong("phone");
				email = rs.getString("email");
				role = rs.getString("role");
				address = rs.getString("address");
				state = rs.getString("state");
				zipcode = rs.getLong("zipcode");			
				
			}
			
			System.out.println(firstname);
			//System.out.println(uta_id);
			System.out.println(email);
			System.out.println(zipcode);
			System.out.println("exceuted");
			conn.commit(); 
		} catch (SQLException e) {
			System.out.println("Login failed");
			System.out.println(e);
		}
		
		String uta_id1=String.valueOf(uta_id);
		String zipcode1=String.valueOf(zipcode);
		String phone1=String.valueOf(phone);
		String[] profile_list1 = {username,password,lastname,firstname,uta_id1,phone1,email,role,address,state,zipcode1};
		
		return profile_list1;
	}
	
	
	
	
	
	public static String[] updateprofile(profile update_profile) {
		
		
		System.out.println(update_profile.getUserName());
		System.out.println(update_profile.getLastName());
		String username = null;
		String password = null;
		String lastname = null;
		String firstname = null;
		int uta_id = 0;
		int phone = 0;
		String email = null;
		String role = null;
		String address = null;
		String state = null;
		int zipcode = 0;
		System.out.println("Before update conncetion");
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		System.out.println("login after update conncetion lol");
		System.out.println(update_profile.getUserName());
		try {
			stmt = conn.createStatement();
			/*
			 * String updateprofile =
			 * "update profile set lastname = '"+update_profile.getLastName()
			 * +"'where username = '"+update_profile.getUserName()+"'";
			 */
					
			String updateprofile =   "update profile set password ='"+ update_profile.getPassword()+"',lastname ='" +update_profile.getLastName()+"',firstname = '"+update_profile.getFirstName()+"' ";
			String updateprofile1 =  ",phone = '"+update_profile.getPhone()+"',email ='"+update_profile.getEmail()+"',address = '"+update_profile.getAddress()+"',state ='"+ update_profile.getState()+ "',zipcode ='"+ update_profile.getZipCode()+"' ,role = '"+update_profile.getRole()+"' where username='"+update_profile.getUserName()+"'";
			String updateprofile3 = updateprofile+updateprofile1;
			
			
			stmt.execute(updateprofile3);


			System.out.println("exceuted");
			conn.commit(); 
		} catch (SQLException e) {
			System.out.println("Login failed");
			System.out.println(e);
		}
		
		String uta_id1=String.valueOf(uta_id);
		String zipcode1=String.valueOf(zipcode);
		String phone1=String.valueOf(phone);
		String[] profile_list = {username,password,lastname,firstname,uta_id1,phone1,email,update_profile.getRole(),address,state,zipcode1};
		
		return profile_list;
	}
	
	
public static void  changerole(profile user_role) {
		

		System.out.println("Before update conncetion");
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		System.out.println("login after update conncetion lol");
		System.out.println(user_role.getUser());
		try {
			stmt = conn.createStatement();
			/*
			 * String updateprofile =
			 * "update profile set lastname = '"+update_profile.getLastName()
			 * +"'where username = '"+update_profile.getUserName()+"'";
			 */
					
			String changingrole =   "update profile set role ='"+ user_role.getRole()+"' where username='"+user_role.getUser()+"'";
			
			
			stmt.execute(changingrole);


			System.out.println("exceuted");
			conn.commit(); 
		} catch (SQLException e) {
			System.out.println("Login failed");
			System.out.println(e);
		}
		


	}
	
	
	
	
	
	
	
}
