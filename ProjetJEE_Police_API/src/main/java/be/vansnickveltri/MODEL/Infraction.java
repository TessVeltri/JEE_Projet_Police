package be.vansnickveltri.MODEL;

import java.util.ArrayList;

import be.vansnickveltri.DAO.AbstractDAOFactory;
import be.vansnickveltri.DAO.DAO;

public class Infraction {

	// Parameters
	private String comment;
	private Ticket ticket;
	private InfractionType infractionType;
	
	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Infraction> infractionDAO = dao.getInfractionDAO();

	
	// Default constructor
	public Infraction () {}
	
	// Constructor
	public Infraction (String comment, Ticket ticket, InfractionType infractionType) {
		this.comment = comment;
		this.ticket = ticket;
		this.infractionType = infractionType;
	}

	// Getters and Setters
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public InfractionType getInfractionType() {
		return infractionType;
	}

	public void setInfractionType(InfractionType infractionType) {
		this.infractionType = infractionType;
	}
	
	// Methods
	public boolean create (Infraction obj) {
		return infractionDAO.create(obj);
	}
	
	public boolean delete (Infraction obj) {
		return infractionDAO.delete(obj);
	}
	
	public boolean update (Infraction obj) {
		return infractionDAO.update(obj);
	}
	
	public int findId () {
		return infractionDAO.findId(this);
	}
	
	public Infraction find (int i) {
		return infractionDAO.find(i);
	}
	
	public ArrayList<Infraction> findAll (){
		return infractionDAO.findAll();
	}
	
	public ArrayList<Infraction> findAll (int i){
		return infractionDAO.findAll(i);
	}
	
}
