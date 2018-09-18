package car_rental_app.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import car_rental_app.data.UserDAO;
import car_rental_app.model.*;

@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();		
		
		String url = "/register.jsp";
		
		User user = new User();	
		user.setUser(request.getParameter("firstName"), request.getParameter("lastName"), 
				request.getParameter("username"), request.getParameter("password"), 
				request.getParameter("email"), request.getParameter("utaId"), 
				request.getParameter("age"), request.getParameter("aac"),
				request.getParameter("role"));
		UserErrorMsgs UerrorMsgs = new UserErrorMsgs();
		user.validateUser(user, UerrorMsgs);
		session.setAttribute("User",user);
		session.setAttribute("errorMsgs",UerrorMsgs);
		if (UerrorMsgs.getErrorMsg().equals("")) {
			UserDAO.registerUser(user); //save employee if no errors
			session.removeAttribute("User");
			url = "/login.jsp"; //if successful, redirect to login page
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
			
	}
}