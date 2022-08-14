package be.veltri.SERVLETS;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.veltri.JAVABEANS.Infraction;
import be.veltri.JAVABEANS.InfractionType;

/**
 * Servlet implementation class addInfraction
 */
public class addInfraction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addInfraction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/policemanHome.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("infractionType");
		String comment = request.getParameter("comment");
		
		HttpSession session = request.getSession(false);
		if (session != null) {
			ArrayList<String> infractions = (ArrayList<String>) session.getAttribute("infractions");
			infractions.add(type);
			session.setAttribute("infractions", infractions);
			ArrayList<Infraction> lstInfractions = (ArrayList<Infraction>) session.getAttribute("lstInfractions");
			InfractionType infType = InfractionType.find(type);
			Infraction inf = new Infraction (comment, null , infType);
			lstInfractions.add(inf);
			session.setAttribute("lstInfractions", lstInfractions);
		} else {
			response.sendRedirect(request.getContextPath() + "/login");
		}
		
		
		doGet(request, response);
	}

}
