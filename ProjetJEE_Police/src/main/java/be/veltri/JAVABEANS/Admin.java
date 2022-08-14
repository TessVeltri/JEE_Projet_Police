package be.veltri.JAVABEANS;

import java.io.Serializable;

public class Admin extends User implements Serializable{

	// Parameters
	private static final long serialVersionUID = 5099907812151566209L;

	// Default constructor
	public Admin() {
	}

	// Constructor
	public Admin(String name, String firstname, String email, String matricule, String password, String type) {
		super(name, firstname, email, matricule, password, type);
	}
}
