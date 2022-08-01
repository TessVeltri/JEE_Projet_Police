package be.vansnickveltri.MODEL;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Policeman extends User{
	
	// Parameters
	private HeadOfBrigade headOfBrigade;
	private ArrayList<Ticket> lst_ticket;

	// Default constructor
	public Policeman() {
	}

	// Constructor
	public Policeman(String name, String firstname, String email, String matricule, String password, HeadOfBrigade headOfBrigade) {
		super(name, firstname, email, matricule, password);
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
	
	// Methods
	public void addTicket(Date date, Time hour, double totalAmount, Vehicle vehicle) {
		this.lst_ticket.add(new Ticket(date, hour, totalAmount, false, this, vehicle));
	}

}
