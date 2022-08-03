package be.vansnickveltri.MODEL;

import java.sql.Time;
import java.util.ArrayList;

import be.vansnickveltri.DAO.AbstractDAOFactory;
import be.vansnickveltri.DAO.DAO;

import java.sql.Date;

public class Ticket {
	
	// Parameters
	private Date date;
	private Time hour;
	private double totalAmount;
	private boolean validate;
	private Policeman policeman;
	private Vehicle vehicle;
	private ArrayList<Infraction> lst_infraction;
	
	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Ticket> ticketDAO = dao.getTicketDAO();

	
	// Default constructor
	public Ticket () {}
	
	// Constructor
	public Ticket(Date date, Time hour, double totalAmount, boolean validate, Policeman policeman, Vehicle vehicle) {
		this.date = date;
		this.hour = hour;
		this.totalAmount = totalAmount;
		this.validate = validate;
		this.policeman = policeman;
		this.vehicle = vehicle;
		lst_infraction = new ArrayList<Infraction>();
	}

	// Getters and Setters
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getHour() {
		return hour;
	}

	public void setHour(Time hour) {
		this.hour = hour;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public Policeman getPoliceman() {
		return policeman;
	}

	public void setPoliceman(Policeman policeman) {
		this.policeman = policeman;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ArrayList<Infraction> getLst_infraction() {
		return lst_infraction;
	}

	public void setLst_infraction(ArrayList<Infraction> lst_infraction) {
		this.lst_infraction = lst_infraction;
	}

	// Methods
	public void addInfraction(String comment, InfractionType infractionType) {
		this.lst_infraction.add(new Infraction(comment, this, infractionType));
	}
	
	public int findId () {
		int id = ticketDAO.findId(this);
		return id;
	}
	

}
