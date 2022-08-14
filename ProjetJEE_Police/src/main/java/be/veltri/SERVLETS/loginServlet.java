package be.veltri.SERVLETS;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.veltri.JAVABEANS.User;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/logIn.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matricule = request.getParameter("inputMatricule");
		String password = request.getParameter("inputPassword");
		String error = "";
		
		if (matricule == null || matricule.equals("") || password == null || password.equals("")) {
			error = "Please complete all the fields correctly";
		}
		if (matricule != null && password != null && error.equals("")) {
			User user = User.login (matricule, password);
			if (user != null) {
				HttpSession session = request.getSession();
				if (!session.isNew()) {
					session.invalidate();
					session = request.getSession(true);
				}
				session.setAttribute("user", user);
				if (user.getTypeUser().equals("Head of brigade")) {
					response.sendRedirect(request.getContextPath() + "/headHome");
				} else if (user.getTypeUser().equals("Admin")) {
					response.sendRedirect(request.getContextPath() + "/adminHome");
				} else if (user.getTypeUser().equals("Policeman")) {
					response.sendRedirect(request.getContextPath() + "/policemanHome");
				} else if (user.getTypeUser().equals("Fine collector")) {
					response.sendRedirect(request.getContextPath() + "/fineCollectorHome");
				}
				
			} else {
				request.setAttribute("error", error);
				doGet (request, response);
			}
		} else {
			request.setAttribute("error", error);
			doGet (request, response);
		}
	}

}
