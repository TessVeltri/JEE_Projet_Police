package be.vansnickveltri.MODEL;

import java.util.ArrayList;

import be.vansnickveltri.DAO.AbstractDAOFactory;
import be.vansnickveltri.DAO.DAO;

import java.sql.Date;

public class Ticket {
	
	// Parameters
	private Date date;
	private String hour;
	private double totalAmount;
	private boolean validate;
	private boolean payed;
	private Policeman policeman;
	private Vehicle vehicle;
	private ArrayList<Infraction> lst_infraction;
	
	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Ticket> ticketDAO = dao.getTicketDAO();

	
	// Default constructor
	public Ticket () {}
	
	// Constructor
	public Ticket(Date date, String hour, double totalAmount, boolean validate, boolean payed, Policeman policeman, Vehicle vehicle) {
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

	public double findTotalAmount() {
		this.initLstInfcations();
		this.calculate();
		return totalAmount;
	}
	
	public void initLstInfcations () {
		ArrayList<Infraction> lst_infractions = new ArrayList<Infraction>();
		lst_infractions = new Infraction().findAll(this.findId());
		this.setLst_infraction(lst_infractions);
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

	public ArrayList<Infraction> findLst_infraction() {
		this.findTotalAmount();
		return lst_infraction;
	}
	
	public ArrayList<Infraction> getLst_infraction() {
		return lst_infraction;
	}

	public void setLst_infraction(ArrayList<Infraction> lst_infraction) {
		this.lst_infraction = lst_infraction;
	}

	// Methods
	private void calculate () {
		double total = 0;
		
		if(this.getLst_infraction() != null)
		{
			for(Infraction infractions : this.getLst_infraction())
			{
				total += infractions.getInfractionType().getInfractionPrice();
			}
		}
		
		setTotalAmount(total);
	}
	
	public boolean create (Ticket obj) {
		return ticketDAO.create(obj);
	}
	
	public boolean delete (Ticket obj) {
		return ticketDAO.delete(obj);
	}
	
	public boolean update (Ticket obj) {
		return ticketDAO.update(obj);
	}
	
	public int findId () {
		return ticketDAO.findId(this);
	}
	
	public Ticket find (int i) {
		return ticketDAO.find(i);
	}
	
	public ArrayList<Ticket> findAll(){
		return ticketDAO.findAll();
	}
	
	public ArrayList<Ticket> findAll (int i){
		return ticketDAO.findAll(i);
	}

}
