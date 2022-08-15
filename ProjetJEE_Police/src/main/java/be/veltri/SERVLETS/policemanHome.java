package be.veltri.SERVLETS;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
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
import be.veltri.JAVABEANS.Policeman;
import be.veltri.JAVABEANS.Ticket;
import be.veltri.JAVABEANS.User;
import be.veltri.JAVABEANS.Vehicle;
import be.veltri.JAVABEANS.VehicleType;

/**
 * Servlet implementation class policemanHome
 */
public class policemanHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public policemanHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> infractions = new ArrayList<>();
		ArrayList<Infraction> lstInfraction = new ArrayList<>();
		HttpSession session = request.getSession(false);
		if(session != null)
		{	
			User user = (User)session.getAttribute("user");
			session.setAttribute("infractions", infractions);
			session.setAttribute("lstInfractions", lstInfraction);
			if(user != null)
			{	
				session.setAttribute("userName", user.getName());
				session.setAttribute("userFirstname", user.getFirstname());
				ArrayList<VehicleType> vehicleTypes = new ArrayList<>();
				vehicleTypes = VehicleType.findAll();
				ArrayList<String> lstVehicleTypes = new ArrayList<>();
				for (VehicleType v : vehicleTypes) {
					lstVehicleTypes.add(v.getVehicleName());
				}
				session.setAttribute("lstVehicleTypes", lstVehicleTypes);
				ArrayList<InfractionType> infractionTypes = new ArrayList<>();
				infractionTypes = InfractionType.findAll();
				ArrayList<String> lstInfractionTypes = new ArrayList<>();
				for (InfractionType i : infractionTypes) {
					lstInfractionTypes.add(i.getInfractionName());
				}
				session.setAttribute("lstInfractionTypes",lstInfractionTypes);
				request.setAttribute("lstInfraction", session.getAttribute("infractions"));
				request.setAttribute("lstInfractionTypes", lstInfractionTypes);
				request.setAttribute("lstVehicleTypes", session.getAttribute("lstVehicleTypes"));
				request.setAttribute("userName", session.getAttribute("userName") + " " + session.getAttribute("userFirstname"));
				this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/policemanHome.jsp").forward(request, response);
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
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		String str_date = request.getParameter("date");
		try {
			date = new Date(formatter.parse(str_date).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String plateNumber = request.getParameter("plateNumber");
		String hour = request.getParameter("hour");
		String name = request.getParameter("name");
		String firstname = request.getParameter("firstname");
		String email = request.getParameter("email");
		String vehicleType = request.getParameter("vehicleType");
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			ArrayList<Infraction> infractions = (ArrayList<Infraction>) session.getAttribute("lstInfractions");
			Policeman policeman = (Policeman) session.getAttribute("user");
			Vehicle vehicle = new Vehicle(plateNumber,false,null,null);
			Ticket ticket = new Ticket(date,hour,0,false,false,policeman,vehicle);
			boolean ticketCreate = ticket.create(ticket);
			boolean infractionCreate= false;
			
			for(Infraction infraction : infractions)
			{
				infraction.setTicket(ticket);
				infractionCreate = Infraction.create(infraction);
			}
			if (ticketCreate && infractionCreate) {
				session.setAttribute("plateNumber", plateNumber);
				session.setAttribute("date", date);
				session.setAttribute("hour", hour);
				session.setAttribute("name", name);
				session.setAttribute("firstname", firstname);
				session.setAttribute("email", email);
				session.setAttribute("vehicleType", vehicleType);
				response.sendRedirect(request.getContextPath() + "/checkTicket");
			}
		
		}
		
	}

}
