package be.veltri.JAVABEANS;

import java.io.Serializable;
import java.util.ArrayList;

import be.veltri.DAO.VehicleTypeDAO;

public class VehicleType implements Serializable{

	// Parameters
	private static final long serialVersionUID = 2982398112417582035L;
	private String vehicleName;

	// Default constructor
	public VehicleType() {
	}

	// Constructor
	public VehicleType(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	// Getters and Setters
	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	// Methods
	
	public static ArrayList<VehicleType> findAll(){
		VehicleTypeDAO dao = new VehicleTypeDAO();
		return dao.findAll();
	}
	
	public int findId () {
		VehicleTypeDAO dao = new VehicleTypeDAO();
		return dao.findId(this);
	}
}
