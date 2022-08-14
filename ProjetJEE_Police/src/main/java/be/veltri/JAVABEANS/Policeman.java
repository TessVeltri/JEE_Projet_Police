package be.veltri.JAVABEANS;

import java.io.Serializable;
import java.util.ArrayList;

import be.veltri.DAO.PolicemanDAO;

public class Policeman extends User implements Serializable{
	
	// Parameters
	private static final long serialVersionUID = 2775816004693142764L;
	private HeadOfBrigade headOfBrigade;
	private ArrayList<Ticket> lst_ticket;

	// Default constructor
	public Policeman() {
	}

	// Constructor
	public Policeman(String name, String firstname, String email, String matricule, String password, String typeUser,
			HeadOfBrigade headOfBrigade) {
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
	public int findId() {
		PolicemanDAO dao = new PolicemanDAO();
		return dao.findId(this);
	}
	
}
