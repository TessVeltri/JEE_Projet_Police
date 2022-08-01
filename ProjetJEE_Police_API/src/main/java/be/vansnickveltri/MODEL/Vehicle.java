package be.vansnickveltri.MODEL;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Vehicle {
	
	// Parameters
	private String plateNumberVehicle;
	private boolean insurance;
	private Civil civil;
	private VehicleType vehicleType;
	private ArrayList <Ticket> lst_ticket;
	
	// Default constructor
	public Vehicle() {}
	
	// Constructor
	public Vehicle(String plateNumberVehicle, boolean insurance, Civil civil, VehicleType vehicleType) {
		this.plateNumberVehicle = plateNumberVehicle;
		this.insurance = insurance;
		this.civil = civil;
		this.vehicleType = vehicleType;
		lst_ticket = new ArrayList <Ticket>();
	}

	// Getters and Setters
	public String getPlateNumberVehicle() {
		return plateNumberVehicle;
	}

	public void setPlateNumberVehicle(String plateNumberVehicle) {
		this.plateNumberVehicle = plateNumberVehicle;
	}

	public boolean isInsurance() {
		return insurance;
	}

	public void setInsurance(boolean insurance) {
		this.insurance = insurance;
	}

	public Civil getCivil() {
		return civil;
	}

	public void setCivil(Civil civil) {
		this.civil = civil;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	public void addTicket(Date date, Time hour, double totalAmount, Policeman policeman) {
		this.lst_ticket.add(new Ticket(date, hour, totalAmount, false, policeman, this));
	}
	
	
}
