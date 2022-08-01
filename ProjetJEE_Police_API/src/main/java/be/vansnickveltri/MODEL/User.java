package be.vansnickveltri.MODEL;

public abstract class User extends Person{
	// Parameters
	private String matricule;
	private String password;
	
	// Default constructor
	public User() {}
	
	// Constructor
	public User(String name, String firstname, String email, String matricule, String password) {
		super(name, firstname, email);
		this.matricule = matricule;
		this.password = password;
	}

	// Getters and Setters
	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
