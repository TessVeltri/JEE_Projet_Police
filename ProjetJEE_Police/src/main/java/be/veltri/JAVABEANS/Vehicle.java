package be.veltri.JAVABEANS;

import java.io.Serializable;
import java.util.ArrayList;

import be.veltri.DAO.VehicleDAO;

public class Vehicle implements Serializable {

	// Parameters
	private static final long serialVersionUID = -1998197185837177184L;
	private String plateNumberVehicle;
	private boolean insurance;
	private Civil civil;
	private VehicleType vehicleType;
	private ArrayList<Ticket> lst_ticket;

	// Default constructor
	public Vehicle() {
	}

	// Constructor
	public Vehicle(String plateNumberVehicle, boolean insurance, Civil civil, VehicleType vehicleType) {
		this.plateNumberVehicle = plateNumberVehicle;
		this.insurance = insurance;
		this.civil = civil;
		this.vehicleType = vehicleType;
		lst_ticket = new ArrayList<Ticket>();
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

	public ArrayList<Ticket> getLst_ticket() {
		return lst_ticket;
	}

	public void setLst_ticket(ArrayList<Ticket> lst_ticket) {
		this.lst_ticket = lst_ticket;
	}
	
	// Methods
	public int findId() {
		VehicleDAO dao = new VehicleDAO();
		return dao.findId(this);
	}
	
}
