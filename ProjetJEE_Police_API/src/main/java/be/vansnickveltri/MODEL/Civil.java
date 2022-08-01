package be.vansnickveltri.MODEL;

import java.util.ArrayList;

public class Civil extends Person{
	
	public ArrayList <Vehicle> lst_vehicle;

	// Default constructor
	public Civil() {}

	// Constructor
	public Civil(String name, String firstname, String email) {
		super(name, firstname, email);
		lst_vehicle = new ArrayList<Vehicle>();
	}
	
	// Methods
	public void addVehicle(String plate, VehicleType vehicleType) {
		this.lst_vehicle.add(new Vehicle(plate, false, this, vehicleType));
	}
	

}
