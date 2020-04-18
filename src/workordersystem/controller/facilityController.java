package workordersystem.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import workordersystem.data.facilityDAO;
import workordersystem.model.*;

@WebServlet("/facilityController")
public class facilityController extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	
	
	
	private void getAddFacilityParam(HttpServletRequest request, facility add_facility) {
		add_facility.setAddFacility(request.getParameter("facilitytype"),request.getParameter("facilityname"),request.getParameter("interval")
				,request.getParameter("venue"));  
	}
	
	

	
	private void getViewSpecificFacilityParam (HttpServletRequest request, facility view_specific_facility) {
		view_specific_facility.setViewSpecificFacility(request.getParameter("facilitytype"),request.getParameter("facilityname"));  
	}
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	String action = request.getParameter("action");
		//session.removeAttribute("errorMsgs");
//		List companies
	//	if (action.equalsIgnoreCase("listCompany")) {
		//ArrayList<Company> companyInDB = new ArrayList<Company>();
//		companyInDB=CompanyDAO.listCompanies();
//		session.setAttribute("COMPANIES", companyInDB);				
//		getServletContext().getRequestDispatcher("/listCompany.jsp").forward(request, response);
////		}
//		else // redirect all other gets to post
		System.out.println("test");
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");
		String action = request.getParameter("action"), url=""; 
		HttpSession session = request.getSession();   
		facilityErrorMsgs UerrorMsgs = new facilityErrorMsgs();
		facility add_facility = new facility();
		//UserErrorMsgs UerrorMsgs = new UserErrorMsgs();
		//int selectedCompanyIndex;
		
		session.removeAttribute("errorMsgs");
		if (action.equalsIgnoreCase("viewaddfacility") ) { 
			//HttpSession session = request.getSession();

		url="/addFacility.jsp";
		
		}
		
		
		
		else if (action.equalsIgnoreCase("addfacility") ) { 
			
			getAddFacilityParam(request,add_facility);
			
			
			
			add_facility.validateFacility(action,add_facility,UerrorMsgs);

			if (!UerrorMsgs.getErrorMsg().equals("")) {
				//if error messages
				System.out.println("error p[age");
				session.setAttribute("facilitynameerror", UerrorMsgs.getFacilityNameError() );
				session.setAttribute("facilitytypeerror", UerrorMsgs.getFacilityTypeError());
				url="/addFacility.jsp";
			}
			else {

				
			//HttpSession session = request.getSession();
		//session.setAttribute("register", create_mar);
		System.out.println("This is before insert");
		facilityDAO.addFacility(add_facility);
		System.out.println("This is after insert");
		session.setAttribute("facilitynameerror", "" );
		session.setAttribute("facilitytypeerror", "");
		url="/home_fm.jsp";
		
		}
		}
		else if (action.equalsIgnoreCase("viewfacility") ) { 

		url="/search_facility.jsp";
		
		}
		
		
		
		else if (action.equalsIgnoreCase("viewspecificfacility") ) { 
			//HttpSession session = request.getSession();
			facility view_specific_facility = new facility();
			getViewSpecificFacilityParam(request,view_specific_facility);
			session.setAttribute("facilitytype", view_specific_facility.getFacilityType());
			session.setAttribute("facilityname", view_specific_facility.getFacilityName());
		url="/view_specific_facility.jsp";
		
		}
		
		
		

		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}
	}

//<fmt:formatDate type="date" var="date" value="${now}" name="xgt" pattern="yyyy.MM.dd" />
//<td>${date}</td>

//<td> <input type="text" id="start" name="reporteddate" value=""placeholder="yyyy-mm-dd"> </td>
