package workordersystem.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import workordersystem.data.profileDAO;
import workordersystem.model.*;
@WebServlet("/profileController")
public class profileController extends HttpServlet{


private static final long serialVersionUID = 1L;
   
private void getRegisterParam (HttpServletRequest request, profile reg) {
	reg.setRegister(request.getParameter("username"),request.getParameter("password"),
			request.getParameter("lastname"),request.getParameter("firstname"),request.getParameter("phone"),
			request.getParameter("email"),request.getParameter("address"),request.getParameter("state")
			,request.getParameter("zipcode"),request.getParameter("role"),request.getParameter("uta_id"));  
}

private void getLoginParam (HttpServletRequest request, profile log) {
	log.setLogin(request.getParameter("username"),request.getParameter("password"));  
}
private void getViewProfileParam (HttpServletRequest request, profile view_profile) {

	view_profile.setViewProfile(request.getParameter("username"));  
}
private void getUpdateProfileParam (HttpServletRequest request, profile update_profile) {
	update_profile.setRegister(request.getParameter("username"),request.getParameter("password"),
			request.getParameter("lastname"),request.getParameter("firstname"),request.getParameter("phone"),
			request.getParameter("email"),request.getParameter("address"),request.getParameter("state")
			,request.getParameter("zipcode"),request.getParameter("role"),request.getParameter("uta_id"));  
}



private void getViewUserProfileParam (HttpServletRequest request, profile view_user_profile) {
	view_user_profile.setViewUserProfile(request.getParameter("user"));  
}


private void getChangeroleParam (HttpServletRequest request, profile change_role) {
	change_role.setChangeUserProfile(request.getParameter("user"),request.getParameter("role"));  
}




protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession();
	String action = request.getParameter("action");

	System.out.println("test");
	doPost(request,response);
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("hello");
	String action = request.getParameter("action"), url=""; 
	HttpSession session = request.getSession();   
	profile reg = new profile();
	
	profileErrorMsgs UerrorMsgs = new profileErrorMsgs();
	//int selectedCompanyIndex;
	session.removeAttribute("errorMsgs");

	if (action.equalsIgnoreCase("register") ) {  
		
		session.setAttribute("usernameerror", "");
		session.setAttribute("passworderror", "");
		session.setAttribute("lastnameerror", "");
		session.setAttribute("firstnameerror", "");
		session.setAttribute("emailerror", "");
		session.setAttribute("utaiderror", "");
		session.setAttribute("phoneerror", "");
		session.setAttribute("stateerror", "");
		session.setAttribute("addresserror", "");
		session.setAttribute("zipcodeerror", "");
		
		
		
		
		session.setAttribute("firstname", "");
		session.setAttribute("lastname", "");
		session.setAttribute("username", "");
		session.setAttribute("phone", "");
		session.setAttribute("uta_id", "");
		session.setAttribute("email", "");
		session.setAttribute("address", "");
		session.setAttribute("state", "");
		session.setAttribute("zipcode", "");
		
		
		
		
		getRegisterParam(request,reg);
		reg.validateUser(action,reg,UerrorMsgs);

		if (!UerrorMsgs.getErrorMsg().equals("")) {
			//if error messages
			System.out.println("error p[age");
			session.setAttribute("usernameerror", UerrorMsgs.getUsernameError());
			session.setAttribute("passworderror", UerrorMsgs.getPasswordError());
			session.setAttribute("lastnameerror", UerrorMsgs.getLastNameError());
			session.setAttribute("firstnameerror", UerrorMsgs.getFirstNameError());
			session.setAttribute("emailerror", UerrorMsgs.getEmailError());
			session.setAttribute("utaiderror", UerrorMsgs.getutaidError());
			session.setAttribute("phoneerror", UerrorMsgs.getPhoneError());
			//session.setAttribute("stateerror", UerrorMsgs.getStateError());
			session.setAttribute("addresserror", UerrorMsgs.getaddressError());
			session.setAttribute("zipcodeerror", UerrorMsgs.getZipcodeError());
			
			
			
			
			session.setAttribute("firstname", reg.getFirstName());
			session.setAttribute("lastname", reg.getLastName());
			session.setAttribute("username", reg.getUserName());
			session.setAttribute("phone", reg.getPhone());
			session.setAttribute("uta_id", reg.getUtaId());
			session.setAttribute("email", reg.getEmail());
			session.setAttribute("address", reg.getAddress());
			session.setAttribute("state", reg.getState());
			session.setAttribute("zipcode", reg.getZipCode());
			
			
			url="/register.jsp";
		}
		
		else {
			System.out.println("insert");
		//session.setAttribute("errorMsgs", UerrorMsgs.getUsernameError());
		profileDAO.insertCompany(reg);
		
		
		session.setAttribute("usernameerror", "");
		session.setAttribute("passworderror", "");
		session.setAttribute("lastnameerror", "");
		session.setAttribute("firstnameerror", "");
		session.setAttribute("emailerror", "");
		session.setAttribute("utaiderror", "");
		session.setAttribute("phoneerror", "");
		session.setAttribute("stateerror", "");
		session.setAttribute("addresserror", "");
		session.setAttribute("zipcodeerror", "");
		
		session.setAttribute("firstname", "");
		session.setAttribute("lastname", "");
		session.setAttribute("username", "");
		session.setAttribute("phone", "");
		session.setAttribute("uta_id", "");
		session.setAttribute("email", "");
		session.setAttribute("address", "");
		session.setAttribute("state", "");
		session.setAttribute("zipcode", "");
		
		url="/index.jsp";
		}

		//session.setAttribute("register", reg);
	}
		
	
	
	else if(action.equalsIgnoreCase("login") )
	{
		session.setAttribute("usernameerror","");
		session.setAttribute("passworderror", "");
		System.out.println("Logging in");
		profile log = new profile();
		getLoginParam(request,log);
		log.validateLogin(action,log,UerrorMsgs);
		
		
		if (!UerrorMsgs.getErrorMsg().equals("")) {
			//if error messages
			System.out.println("hi");
			session.setAttribute("usernameerror", UerrorMsgs.getUsernameError());
			session.setAttribute("passworderror", UerrorMsgs.getPasswordError());

			//session.setAttribute("username", reg.getUserName());
			

			
			url="/index.jsp";
		}
		
		else {
			session.setAttribute("check1", log.getUserName1());
			String x = (String)session.getAttribute("check1");
			System.out.println(x);
//				System.out.println("This is login4");
			String status = profileDAO.checklogin(log);
			System.out.println(status);
			session.setAttribute("usernameerror","");
			session.setAttribute("passworderror", "");
			if(status.equalsIgnoreCase("no")) {
				session.setAttribute("loginerror", "Login Failed  user not found ");
				url="/index.jsp";
			}
			
			else if(status.equalsIgnoreCase("User")){
			url="/home.jsp";
			}
			else if(status.equalsIgnoreCase("FacilityManager")) {
				url="/home_fm.jsp";
			}
			else if(status.equalsIgnoreCase("Repairer")) {
				url="/home_repair.jsp";
			}
			
			else if(status.equalsIgnoreCase("Admin")) {
				System.out.println("This is admin");
				url="/home_admin.jsp";
			}
		}
			
		}
	else if(action.equalsIgnoreCase("viewprofile") ){
			//System.out.println("This is login");
			//HttpSession session = request.getSession();
//				System.out.println("This is login");
		
		
		session.setAttribute("usernameerror", "");
		session.setAttribute("passworderror", "");
		session.setAttribute("lastnameerror", "");
		session.setAttribute("firstnameerror", "");
		session.setAttribute("emailerror", "");
		session.setAttribute("utaiderror", "");
		session.setAttribute("phoneerror", "");
		session.setAttribute("stateerror", "");
		session.setAttribute("addresserror", "");
		session.setAttribute("zipcodeerror", "");	

			profile view_profile = new profile();
//				System.out.println("This is login2");
			getViewProfileParam(request,view_profile);
			System.out.println("This is login3");
			//session.setAttribute("check2", view_profile.getUserName());
		/*
		 * String x = (String)session.getAttribute("check"); System.out.println(x);
		 */
//				System.out.println("This is login4");
			String[] profile_list = profileDAO.viewprofile(view_profile);
			System.out.println("This is login5");
			session.setAttribute("username",profile_list[0] );
			session.setAttribute("password",profile_list[1] );
			session.setAttribute("lastname",profile_list[2] );
			session.setAttribute("firstname",profile_list[3] );
			session.setAttribute("uta_id1",profile_list[4] );
			session.setAttribute("phone1",profile_list[5] );
			session.setAttribute("email",profile_list[6] );
			session.setAttribute("role",profile_list[7] );
			session.setAttribute("address",profile_list[8] );
			session.setAttribute("state",profile_list[9] );
			session.setAttribute("zipcode1",profile_list[10] );
			//session.setAttribute("city",profile_list[11] );
			url="/profile.jsp";
			
		
	}
	
	else if(action.equalsIgnoreCase("viewprofile1") ){
		//HttpSession session = request.getSession();
//			System.out.println("This is login");
		profile view_profile = new profile();
//			System.out.println("This is login2");
		profileErrorMsgs UerrorMsgs2 = new profileErrorMsgs();
		getViewProfileParam(request,view_profile);
		
		view_profile.validateUser(action,view_profile,UerrorMsgs2);

		if (!UerrorMsgs2.getErrorMsg().equals("")) {
			//if error messages
			System.out.println("error p[age");
			session.setAttribute("usernameerror", UerrorMsgs2.getUsernameError());
			url="/home_admin.jsp";

		}
		
		else {
		
		
		
		
		
		System.out.println("This is login3");
		//session.setAttribute("check2", view_profile.getUserName());
	/*
	 * String x = (String)session.getAttribute("check"); System.out.println(x);
	 */
//			System.out.println("This is login4");
		String[] profile_list = profileDAO.viewprofile(view_profile);
		System.out.println("This is login5");
		session.setAttribute("username",profile_list[0] );
		session.setAttribute("password",profile_list[1] );
		session.setAttribute("lastname",profile_list[2] );
		session.setAttribute("firstname",profile_list[3] );
		session.setAttribute("uta_id1",profile_list[4] );
		session.setAttribute("phone1",profile_list[5] );
		session.setAttribute("email",profile_list[6] );
		session.setAttribute("role",profile_list[7] );
		session.setAttribute("address",profile_list[8] );
		session.setAttribute("state",profile_list[9] );
		session.setAttribute("zipcode1",profile_list[10] );
		//session.setAttribute("city",profile_list[11] );
		url="/user_profile.jsp";
		}
	
}
	
	
	
	else if(action.equalsIgnoreCase("updateprofile") ){
		System.out.println("in controller update");
		getRegisterParam(request,reg);
		reg.validateUpdateUser(action,reg,UerrorMsgs);
		if (!UerrorMsgs.getErrorMsg().equals("")) {
			//if error messages
			System.out.println("error p[age");
			session.setAttribute("usernameerror", UerrorMsgs.getUsernameError());
			session.setAttribute("passworderror", UerrorMsgs.getPasswordError());
			session.setAttribute("lastnameerror", UerrorMsgs.getLastNameError());
			session.setAttribute("firstnameerror", UerrorMsgs.getFirstNameError());
			session.setAttribute("emailerror", UerrorMsgs.getEmailError());
			session.setAttribute("utaiderror", UerrorMsgs.getutaidError());
			session.setAttribute("phoneerror", UerrorMsgs.getPhoneError());
			//session.setAttribute("cityerror", UerrorMsgs.getCityError());
			session.setAttribute("addresserror", UerrorMsgs.getaddressError());
			session.setAttribute("zipcodeerror", UerrorMsgs.getZipcodeError());		
			session.setAttribute("firstname", reg.getFirstName());
			session.setAttribute("lastname", reg.getLastName());
			session.setAttribute("username", reg.getUserName());
			session.setAttribute("phone", reg.getPhone());
			session.setAttribute("uta_id", reg.getUtaId());
			session.setAttribute("email", reg.getEmail());
			session.setAttribute("address", reg.getAddress());
			session.setAttribute("state", reg.getState());
			session.setAttribute("zipcode", reg.getZipCode());
			
			
			url="/profile.jsp";
		}
		
		else {
		
		
		
		System.out.println("This is update profile");
		//HttpSession session = request.getSession();
//			System.out.println("This is login");
		profile update_profile = new profile();
		System.out.println("This is in update controller");
		getUpdateProfileParam(request,update_profile);
//			System.out.println("This is login3");
//			session.setAttribute("check1", log.getUserName());
//			String x = (String)session.getAttribute("check1");
//			System.out.println(x);
//			System.out.println("This is login4");
		String[] updated_profile_list = profileDAO.updateprofile(update_profile);
		System.out.println("This is in updated");
		
		
		
		session.setAttribute("usernameerror", "");
		session.setAttribute("passworderror", "");
		session.setAttribute("lastnameerror", "");
		session.setAttribute("firstnameerror", "");
		session.setAttribute("emailerror", "");
		session.setAttribute("utaiderror", "");
		session.setAttribute("phoneerror", "");
		session.setAttribute("stateerror", "");
		session.setAttribute("addresserror", "");
		session.setAttribute("zipcodeerror", "");	
		//session.setAttribute("cityerror", "");
		session.setAttribute("firstname", "");
		session.setAttribute("lastname", "");
		session.setAttribute("username", "");
		session.setAttribute("phone", "");
		session.setAttribute("uta_id", "");
		session.setAttribute("email", "");
		session.setAttribute("address", "");
		session.setAttribute("state", "");
		session.setAttribute("zipcode", "");
		
		
		
		
		
		session.removeAttribute("usernameerror");
		session.removeAttribute("passworderror");
		session.removeAttribute("lastnameerror");
		session.removeAttribute("firstnameerror");
		session.removeAttribute("emailerror");
		//session.removeAttribute("utaiderror");
		session.removeAttribute("phoneerror");
		session.removeAttribute("addresserror");
		session.removeAttribute("zipcodeerror");

		
		
		
		
		
		//session.setAttribute("username",updated_profile_list[0] );
		session.setAttribute("password",updated_profile_list[1] );
		session.setAttribute("lastname",updated_profile_list[2] );
		session.setAttribute("firstname",updated_profile_list[3] );
		//session.setAttribute("uta_id1",updated_profile_list[4] );
		session.setAttribute("phone1",updated_profile_list[5] );
		session.setAttribute("email",updated_profile_list[6] );
		session.setAttribute("role",updated_profile_list[7] );
		session.setAttribute("address",updated_profile_list[8] );
		session.setAttribute("state",updated_profile_list[9] );
		session.setAttribute("zipcode1",updated_profile_list[10] );
		
		System.out.println(updated_profile_list[7]);
		if (updated_profile_list[7].equals("FacilityManager")) {
		url="/home_fm.jsp";
		}
		else if (updated_profile_list[7].equals("Repairer")) {
			url="/home_repair.jsp";
			}
		
		else if (updated_profile_list[7].equals("Admin")) {
			url="/home_admin.jsp";
			}
		
		else {
			url="/home.jsp";
		}
		}
	}
		
	
	else if(action.equalsIgnoreCase("updateprofile1") ){
		System.out.println("in controller update");
		getRegisterParam(request,reg);
		reg.validateUpdateUser(action,reg,UerrorMsgs);
		if (!UerrorMsgs.getErrorMsg().equals("")) {
			//if error messages
			System.out.println("error p[age");
			session.setAttribute("usernameerror", UerrorMsgs.getUsernameError());
			session.setAttribute("passworderror", UerrorMsgs.getPasswordError());
			session.setAttribute("lastnameerror", UerrorMsgs.getLastNameError());
			session.setAttribute("firstnameerror", UerrorMsgs.getFirstNameError());
			session.setAttribute("emailerror", UerrorMsgs.getEmailError());
			session.setAttribute("utaiderror", UerrorMsgs.getutaidError());
			session.setAttribute("phoneerror", UerrorMsgs.getPhoneError());
			//session.setAttribute("cityerror", UerrorMsgs.getCityError());
			session.setAttribute("addresserror", UerrorMsgs.getaddressError());
			session.setAttribute("zipcodeerror", UerrorMsgs.getZipcodeError());		
			session.setAttribute("firstname", reg.getFirstName());
			session.setAttribute("lastname", reg.getLastName());
			session.setAttribute("username", reg.getUserName());
			session.setAttribute("phone", reg.getPhone());
			
		session.setAttribute("uta_id", reg.getUtaId());
			session.setAttribute("email", reg.getEmail());
			session.setAttribute("address", reg.getAddress());
			session.setAttribute("state", reg.getState());
			session.setAttribute("zipcode", reg.getZipCode());
			
			
			url="/profile.jsp";
		}
		
		else {
		
		
		
		System.out.println("This is update profile");
		//HttpSession session = request.getSession();
//			System.out.println("This is login");
		profile update_profile = new profile();
		System.out.println("This is in update controller");
		getUpdateProfileParam(request,update_profile);
//			System.out.println("This is login3");
//			session.setAttribute("check1", log.getUserName());
//			String x = (String)session.getAttribute("check1");
//			System.out.println(x);
//			System.out.println("This is login4");
		String[] updated_profile_list = profileDAO.updateprofile(update_profile);
		System.out.println("This is in updated");
		
		
		
		session.setAttribute("usernameerror", "");
		session.setAttribute("passworderror", "");
		session.setAttribute("lastnameerror", "");
		session.setAttribute("firstnameerror", "");
		session.setAttribute("emailerror", "");
		session.setAttribute("utaiderror", "");
		session.setAttribute("phoneerror", "");
		session.setAttribute("stateerror", "");
		session.setAttribute("addresserror", "");
		session.setAttribute("zipcodeerror", "");	
		//session.setAttribute("cityerror", "");
		session.setAttribute("firstname", "");
		session.setAttribute("lastname", "");
		session.setAttribute("username", "");
		session.setAttribute("phone", "");
		session.setAttribute("uta_id", "");
		session.setAttribute("email", "");
		session.setAttribute("address", "");
		session.setAttribute("state", "");
		session.setAttribute("zipcode", "");
		
		
		
		
		
		session.removeAttribute("usernameerror");
		session.removeAttribute("passworderror");
		session.removeAttribute("lastnameerror");
		session.removeAttribute("firstnameerror");
		session.removeAttribute("emailerror");
		session.removeAttribute("utaiderror");
		session.removeAttribute("phoneerror");
		session.removeAttribute("addresserror");
		session.removeAttribute("zipcodeerror");

		
		
		
		
		
		//session.setAttribute("username",updated_profile_list[0] );
		session.setAttribute("password",updated_profile_list[1] );
		session.setAttribute("lastname",updated_profile_list[2] );
		session.setAttribute("firstname",updated_profile_list[3] );
		session.setAttribute("uta_id1",updated_profile_list[4] );
		session.setAttribute("phone1",updated_profile_list[5] );
		session.setAttribute("email",updated_profile_list[6] );
		session.setAttribute("role",updated_profile_list[7] );
		session.setAttribute("address",updated_profile_list[8] );
		session.setAttribute("state",updated_profile_list[9] );
		session.setAttribute("zipcode1",updated_profile_list[10] );
		
		System.out.println(updated_profile_list[7]);

			url="/home_admin.jsp";

		}
	}
	
	
	
	
		
		
		else if (action.equalsIgnoreCase("viewuserprofile") ) { 
			
			
			profile view_user_profile = new profile();
			
			//UserErrorMsgs UerrorMsgs1 = new UserErrorMsgs();
			getViewUserProfileParam(request,view_user_profile);
			view_user_profile.validateUser(action,view_user_profile,UerrorMsgs);
			
			if (!UerrorMsgs.getErrorMsg().equals("")) {
				//if error messages
				//System.out.println("error p[age");
				session.setAttribute("usernameerror", UerrorMsgs.getUsernameError());
				url="/home_admin.jsp";

			}
			
			else {
			
				String[] profile_list1 = profileDAO.viewuserprofile(view_user_profile);
				System.out.println("This is login5");
				System.out.println(profile_list1[0]);
				System.out.println(profile_list1[6]);
				session.setAttribute("username1",profile_list1[0] );
				session.setAttribute("password1",profile_list1[1] );
				session.setAttribute("lastname1",profile_list1[2] );
				session.setAttribute("firstname1",profile_list1[3] );
				//session.setAttribute("uta_id11",profile_list1[4] );
				session.setAttribute("phone11",profile_list1[5] );
				session.setAttribute("email1",profile_list1[6] );
				session.setAttribute("role1",profile_list1[7] );
				session.setAttribute("address1",profile_list1[8] );
				session.setAttribute("state1",profile_list1[9] );
				session.setAttribute("zipcode11",profile_list1[10] );
				url="/user_profile.jsp";
		
		}
			
			
			
			
		
		}
		
		else if(action.equalsIgnoreCase("updaterole") ){
			System.out.println("This is update profile");
			//HttpSession session = request.getSession();
//			System.out.println("This is login");
			profile update_profile = new profile();
			System.out.println("This is in update controller");
			getUpdateProfileParam(request,update_profile);
//			System.out.println("This is login3");
//			session.setAttribute("check1", log.getUserName());
//			String x = (String)session.getAttribute("check1");
//			System.out.println(x);
//			System.out.println("This is login4");
			String[] updated_profile_list = profileDAO.updateprofile(update_profile);
			System.out.println("This is in updated");
			

			//session.setAttribute("username",updated_profile_list[0] );
			session.setAttribute("password",updated_profile_list[1] );
			session.setAttribute("lastname",updated_profile_list[2] );
			session.setAttribute("firstname",updated_profile_list[3] );
			//session.setAttribute("uta_id1",updated_profile_list[4] );
			session.setAttribute("phone1",updated_profile_list[5] );
			session.setAttribute("email",updated_profile_list[6] );
			session.setAttribute("role",updated_profile_list[7] );
			session.setAttribute("address",updated_profile_list[8] );
			session.setAttribute("state",updated_profile_list[9] );
			session.setAttribute("zipcode1",updated_profile_list[10] );
			
			System.out.println(updated_profile_list[7]);
			if (updated_profile_list[7].equals("FacilityManager")) {
			url="/home_fm.jsp";
			}
			else if (updated_profile_list[7].equals("Repairer")) {
				url="/home_repair.jsp";
				}
			
			else if (updated_profile_list[7].equals("Admin")) {
				url="/home_admin.jsp";
				}
			
			else {
				url="/home.jsp";
			}
		}
		
		else if (action.equalsIgnoreCase("changerole") ) { 
			//HttpSession session = request.getSession();
			profile change_role = new profile();
			profileErrorMsgs UerrorMsgs1 = new profileErrorMsgs();
			getChangeroleParam(request,change_role);
			change_role.validateUser(action,change_role,UerrorMsgs1);

			if (!UerrorMsgs1.getErrorMsg().equals("")) {
				//if error messages
				System.out.println("error p[age");
				session.setAttribute("usernameerror1", UerrorMsgs1.getUsernameError());
				url="/home_admin.jsp";

			}
			
			else {
			
			profileDAO.changerole(change_role);
			System.out.println("This is login5");
			session.setAttribute("usernameerror1", "");
			session.removeAttribute("usernameerror1");
			url="/home_admin.jsp";
		
		}
		}
	

	
	
	

	getServletContext().getRequestDispatcher(url).forward(request, response);		
}





}
