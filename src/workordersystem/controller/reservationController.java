package workordersystem.controller;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import workordersystem.data.reservationDAO;
import workordersystem.model.*;

@WebServlet("/reservationController")
public class reservationController extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	
	private void getRequestReserve (HttpServletRequest request, reservation request_reserve) {
		request_reserve.setRequestReserve(request.getParameter("marnumber"),request.getParameter("facilitytype"),request.getParameter("facilityname"),request.getParameter("interval")
				,request.getParameter("repairdate"),request.getParameter("repairer"));  
	}
	
	private void getViewScheduleParam (HttpServletRequest request, reservation view_schedule) {
		view_schedule.setViewSchedule(request.getParameter("repairer"));  
		System.out.println("checking");
		System.out.println(request.getParameter("repairer"));
		//view_schedule.setViewProfile(request.getParameter("username"));  
	}
	

	
	
	
	private void getModifyReserveParam (HttpServletRequest request, reservation modify_reserve) {
		modify_reserve.setModifyReserve(request.getParameter("reservationnumber"),request.getParameter("interval"));  
	}
	
	
	private void getDeleteReserveParam (HttpServletRequest request, reservation delete_reserve) {
		delete_reserve.setDeleteReserve(request.getParameter("reservationnumber"));  
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
		reservation reg = new reservation();
		
		
		session.removeAttribute("errorMsgs");

		if (action.equalsIgnoreCase("requestreservation") ) { 
			//HttpSession session = request.getSession();
			reservation request_reserve = new reservation();
			getRequestReserve(request,request_reserve);

		//session.setAttribute("register", create_mar);
		System.out.println("This is before insert");
		reservationDAO.requestReserve(request_reserve);
		System.out.println("This is after insert");

		url="/index.jsp";
		
		}
		else if (action.equalsIgnoreCase("viewaddfacility") ) { 
			//HttpSession session = request.getSession();

		url="/addFacility.jsp";
		
		}
		
		
	
		else if (action.equalsIgnoreCase("viewrepairschedule") ) { 
			//HttpSession session = request.getSession();
			reservation view_schedule = new reservation();
			getViewScheduleParam(request,view_schedule);
			session.setAttribute("repairer", view_schedule.getRepairer());
		url="/view_repair_schedule.jsp";
		
		}
	
		
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}
}
