package be.veltri.SERVLETS;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.veltri.JAVABEANS.Infraction;
import be.veltri.JAVABEANS.InfractionType;
import be.veltri.JAVABEANS.User;
import be.veltri.JAVABEANS.VehicleType;

/**
 * Servlet implementation class checkTicket
 */
public class checkTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkTicket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null)
		{	
			User user = (User)session.getAttribute("user");
			
			if(user != null)
			{					
				Date date = (Date) session.getAttribute("date");
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				String myDate = format.format(date);
				request.setAttribute("plateNumber", session.getAttribute("plateNumber"));
				request.setAttribute("date", myDate);
				request.setAttribute("hour", session.getAttribute("hour"));
				request.setAttribute("name", session.getAttribute("name"));
				request.setAttribute("firstname", session.getAttribute("firstname"));
				request.setAttribute("email", session.getAttribute("email"));
				request.setAttribute("vehicleType", session.getAttribute("vehicleType"));
				request.setAttribute("lstInfractions", session.getAttribute("infractions"));
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/checkTicket.jsp").forward(request, response);
			}
			else
			{
				response.sendRedirect(request.getContextPath() + "/login");
			}			
		}
		else 
		{
			response.sendRedirect(request.getContextPath() + "/login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
