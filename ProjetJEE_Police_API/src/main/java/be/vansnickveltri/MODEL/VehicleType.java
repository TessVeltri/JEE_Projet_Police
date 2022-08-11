package be.vansnickveltri.MODEL;

import java.util.ArrayList;

import be.vansnickveltri.DAO.AbstractDAOFactory;
import be.vansnickveltri.DAO.DAO;

public class VehicleType {
	
	// Parameters
	private String vehicleName;
	
	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<VehicleType> vehicleTypeDAO = dao.getVehicleTypeDAO();

	
	// Default constructor
	public VehicleType() {}
	
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
	public boolean create (VehicleType obj) {
		return vehicleTypeDAO.create(obj);
	}
	
	public boolean delete (VehicleType obj) {
		return vehicleTypeDAO.delete(obj);
	}
	
	public int findId () {
		return vehicleTypeDAO.findId(this);
	}
	
	public VehicleType find (int i) {
		return vehicleTypeDAO.find(i);
	}
	
	public ArrayList<VehicleType> getAll (){
		return vehicleTypeDAO.getAll();
	}
	
}
