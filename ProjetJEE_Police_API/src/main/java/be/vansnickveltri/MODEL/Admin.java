package be.vansnickveltri.MODEL;

public class Admin extends User{

	// Default constructor
	public Admin() {}

	// Constructor
	public Admin(String name, String firstname, String email, String matricule, String password, String type) {
		super(name, firstname, email, matricule, password, type);
	}
	
}
