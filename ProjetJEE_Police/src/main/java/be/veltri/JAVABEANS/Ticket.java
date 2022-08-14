package be.veltri.JAVABEANS;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import be.veltri.DAO.TicketDAO;

public class Ticket implements Serializable {
	
	// Parameters
	private static final long serialVersionUID = -5254805063103497806L;
	private Date date;
	private String hour;
	private double totalAmount;
	private boolean validate;
	private boolean payed;
	private Policeman policeman;
	private Vehicle vehicle;
	private ArrayList<Infraction> lst_infraction;

	// Default constructor
	public Ticket() {
	}

	// Constructor
	public Ticket(Date date, String hour, double totalAmount, boolean validate, boolean payed, Policeman policeman,
			Vehicle vehicle) {
		this.date = date;
		this.hour = hour;
		this.totalAmount = totalAmount;
		this.validate = validate;
		this.payed = payed;
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

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
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

	public boolean isPayed() {
		return payed;
	}

	public void setPayed(boolean payed) {
		this.payed = payed;
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
	public boolean create (Ticket obj) {
		TicketDAO dao = new TicketDAO();
		return dao.create(obj);
	}
	
	public int findId() {
		TicketDAO dao = new TicketDAO();
		return dao.findId(this);
	}
	
}
