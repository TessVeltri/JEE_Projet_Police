package be.vansnickveltri.MODEL;

public class VehicleType {
	
	// Parameters
	private String vehicleName;
	
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
	
}
