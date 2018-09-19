package car_rental_app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import car_rental_app.data.UserDAO;
import car_rental_app.model.User;
import car_rental_app.model.UserErrorMsgs;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		
		String url = "/login.jsp";
		
		if (request.getParameter("loginBtn")!=null) //press login button
		{
			String username = request.getParameter("username");
			String password = request.getParameter("password");		
			
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);		
			UserErrorMsgs UerrorMsgs = new UserErrorMsgs();		
			user.verifyUser(user, UerrorMsgs);
			session.setAttribute("User",user);
			session.setAttribute("errorMsgs",UerrorMsgs);

			if (UerrorMsgs.getErrorMsg().equals("")) { //username & pw matches
				session.removeAttribute("User");
				session.removeAttribute("errorMsgs");
				
				HttpSession currentSession = request.getSession();							
				
				user = UserDAO.getUser(username);				
				
				currentSession.setAttribute("currentUser",user);
				
				//redirect to appropriate home page based on role
				String role = user.getRole();
				if(role.equals("Customer"))
				  url = "/customerHome.jsp"; 
				else if(role.equals("Manager"))
				  url = "/managerHome.jsp";
				else
				  url = "/adminHome.jsp";
			}
		}
		else { //register button pressed
			session.removeAttribute("User");
			session.removeAttribute("errorMsgs");
			url = "/register.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
			
	}

}

