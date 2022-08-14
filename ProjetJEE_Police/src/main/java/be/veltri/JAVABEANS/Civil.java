package be.veltri.JAVABEANS;

import java.io.Serializable;
import java.util.ArrayList;

import be.veltri.DAO.PersonDAO;

public class Civil extends Person implements Serializable{
	
	// Parameters
	private static final long serialVersionUID = -5412694765914399803L;
	public ArrayList<Vehicle> lst_vehicle;

	// Default constructor
	public Civil() {
	}

	// Constructor
	public Civil(String name, String firstname, String email) {
		super(name, firstname, email);
		lst_vehicle = new ArrayList<Vehicle>();
	}
	
	// Methods 
	
	public int findId() {
		PersonDAO dao = new PersonDAO();
		return dao.findId(this);
	}
}
