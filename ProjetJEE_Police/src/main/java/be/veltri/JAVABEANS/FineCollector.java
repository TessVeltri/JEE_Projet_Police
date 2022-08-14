package be.veltri.JAVABEANS;

import java.io.Serializable;

public class FineCollector extends User implements Serializable{

	// Parameters
	private static final long serialVersionUID = -7117226028562015744L;

	// Default constructor
	public FineCollector() {
	}

	// Constructor
	public FineCollector(String name, String firstname, String email, String matricule, String password, String type) {
		super(name, firstname, email, matricule, password, type);
	}
}
