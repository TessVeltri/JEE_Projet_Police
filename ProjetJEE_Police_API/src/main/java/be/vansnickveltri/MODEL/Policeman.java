package be.vansnickveltri.MODEL;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import be.vansnickveltri.DAO.AbstractDAOFactory;
import be.vansnickveltri.DAO.DAO;

public class Policeman extends User{
	
	// Parameters
	private HeadOfBrigade headOfBrigade;
	private ArrayList<Ticket> lst_ticket;
	
	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Policeman> policemanDAO = dao.getPolicemanDAO();

	// Default constructor
	public Policeman() {
	}

	// Constructor
	public Policeman(String name, String firstname, String email, String matricule, String password, String typeUser, HeadOfBrigade headOfBrigade) {
		super(name, firstname, email, matricule, password, typeUser);
		
		this.headOfBrigade = headOfBrigade;
		lst_ticket = new ArrayList<Ticket>();
	}

	// Getters and Setters
	public HeadOfBrigade getHeadOfBrigade() {
		return headOfBrigade;
	}

	public void setHeadOfBrigade(HeadOfBrigade headOfBrigade) {
		this.headOfBrigade = headOfBrigade;
	}
	
	public ArrayList<Ticket> getLst_ticket() {
		return lst_ticket;
	}

	public void setLst_ticket(ArrayList<Ticket> lst_ticket) {
		this.lst_ticket = lst_ticket;
	}

	// Methods
	public void addTicket(Date date, Time hour, double totalAmount, Vehicle vehicle) {
		this.lst_ticket.add(new Ticket(date, hour, totalAmount, false, this, vehicle));
	}
	
	public Policeman find (String matricule) {
		Policeman p = policemanDAO.find(matricule, "");
		return p;
	}

}
