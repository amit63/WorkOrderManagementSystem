package workordersystem.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import workordersystem.data.reportDAO;
import workordersystem.model.*;

@WebServlet("/reportController")
public class reportController extends HttpServlet {
 
	private static final long serialVersionUID = 1L;
       
	
	private void getCreateMARParam (HttpServletRequest request, report write_mar) {
		write_mar.setMARReport(request.getParameter("facilitytype"),request.getParameter("facilityname"),request.getParameter("urgency")
				,request.getParameter("description"),request.getParameter("reportedby"),request.getParameter("reporteddate"));  
	}
	
	
	private void getAssignMARParam (HttpServletRequest request, report assign_mar) {
		assign_mar.setAssignMARReport(request.getParameter("marnumber"),request.getParameter("assignedto"),request.getParameter("assigneddate")
				,request.getParameter("estimateofrepair"));  
	}
	
	
	
	
	
	private void getSearchMARParam (HttpServletRequest request, report search_mar) {
		search_mar.setSearchMAR(request.getParameter("reporteddate"));  
		
	
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
		report write_mar = new report();
		
		reportErrorMsgs UerrorMsgs = new reportErrorMsgs();
		//int selectedCompanyIndex;
		session.removeAttribute("errorMsgs");

		
		
		if (action.equalsIgnoreCase("createmar") ) { 
			//HttpSession session = request.getSession();
			
			//session.setAttribute("check1", log.getUserName());
			//report write_mar = new report();
 
		
			url="/mar_report.jsp";
		}

		//session.setAttribute("register", create_mar);

		//registerDAO.insertMAR(create_mar);

		
		
		
		
		else if (action.equalsIgnoreCase("writemar") ) { 

		//session.setAttribute("register", create_mar);


		
		//report write_mar = new report();
		//UserErrorMsgs UerrorMsgs2 = new UserErrorMsgs();
			
			
			getCreateMARParam(request,write_mar);
			write_mar.validateDate(action,write_mar,UerrorMsgs);
			//write_mar.validateDate(action,write_mar,UerrorMsgs);
			if (!UerrorMsgs.getErrorMsg().equals("")) {
				//if error messages
				System.out.println("error p[age");
				session.setAttribute("facilitydateerror", UerrorMsgs.getFacilityDateError() );
				session.setAttribute("facilitydecriptionerror", UerrorMsgs.getFacilityDescriptionError() );
				url="/mar_report.jsp";
			}
			
			else {
				
				System.out.println("This is login5");
		//write_mar.validateUser(action,write_mar,UerrorMsgs2);	
		reportDAO.insertMAR(write_mar);
		session.setAttribute("facilitydateerror", "" );
		session.setAttribute("facilitydecriptionerror", "" );

		session.removeAttribute("usernameerror2");
		session.removeAttribute("facilitydecriptionerror");
		url="/mar_report.jsp";
	
	}
		
		}
		else if (action.equalsIgnoreCase("assignmar") ) { 
			//HttpSession session = request.getSession();
			report assign_mar = new report();
			System.out.println("This is write conrtoller");
			getAssignMARParam(request,assign_mar);
			//assign_mar.validateAssignDate(action,assign_mar,UerrorMsgs);
			
			assign_mar.validateDate(action,assign_mar,UerrorMsgs);
			//assign_mar.validateEsitimateOfRepair(action, assign_mar, UerrorMsgs);
			//assign_mar.
			if (!UerrorMsgs.getErrorMsg().equals("")) {
				//if error messages
				System.out.println("error p[age"+UerrorMsgs.getAssignFacilityDateError());
				//System.out.println("error p[age"+UerrorMsgs.getEstimateOfRepairError());
				session.setAttribute("assignfacilitydateerror", UerrorMsgs.getAssignFacilityDateError() );
				//session.setAttribute("estimateofrepairerror", UerrorMsgs.getEstimateOfRepairError() );
				url="/assign_mar.jsp";
			}else
			{

		//session.setAttribute("register", create_mar);
		System.out.println("This is before insert");
		String status = reportDAO.assignMAR(assign_mar);
		session.setAttribute("assignfacilitydateerror", "" );
		session.setAttribute("estimateofrepairerror", "" );
		System.out.println("This is after insert");
		url="/assign_mar.jsp";
		/*if(status.equalsIgnoreCase("five")) {
		session.setAttribute("fivemarerror1", "5 already assigned! Cant assign anymore MAR");
		url="/assign_mar.jsp";
		}*/
		/*if(status.equalsIgnoreCase("five")) {
			session.setAttribute("fivemarerror1", "5 Assigned already");
			url="/assign_mar.jsp";
		}
		else{
			url="/home_fm.jsp";
			
		}
			}*/
		}}

		
		
		else if (action.equalsIgnoreCase("viewmar") ) { 
			//HttpSession session = request.getSession();
			report search_mar = new report();
			getSearchMARParam(request,search_mar);
			session.setAttribute("reporteddate1", search_mar.getReportedDate1());
			search_mar.validateDate(action,search_mar,UerrorMsgs);
			if (!UerrorMsgs.getErrorMsg().equals("")) {
				//if error messages
				System.out.println("error p[age"+UerrorMsgs.getFacilityDateError());
				//System.out.println("error p[age"+UerrorMsgs.getEstimateOfRepairError());
				session.setAttribute("assignfacilitydateerror", UerrorMsgs.getFacilityDateError() );
				//session.setAttribute("estimateofrepairerror", UerrorMsgs.getEstimateOfRepairError() );
				url="/home_fm.jsp";
			}else {
				session.removeAttribute("assignfacilitydateerror");
			
		url="/search_mar.jsp";
			}
		
		}
		

		

		
		

		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}
}