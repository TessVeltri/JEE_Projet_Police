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
	public boolean create (Policeman obj) {
		return policemanDAO.create(obj);
	}
	
	public int findId (Policeman obj) {
		return policemanDAO.findId(obj);
	}
	
	public Policeman find (String matricule, String password) {
		return policemanDAO.find(matricule, password);
	}
	
	public Policeman find (int i) {
		return policemanDAO.find(i);
	}
	
	public ArrayList<Policeman> findAllPoliceman (){
		return policemanDAO.findAll();
	}

}
