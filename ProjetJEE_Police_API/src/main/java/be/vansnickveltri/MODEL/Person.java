package be.vansnickveltri.MODEL;

public abstract class Person {
	
	// Parameters
	private String name;
	private String firstname;
	private String email;
	
	// Default constructor
	public Person() {}

	// Constructor
	public Person(String name, String firstname, String email) {
		this.name = name;
		this.firstname = firstname;
		this.email = email;
	}
	
	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
