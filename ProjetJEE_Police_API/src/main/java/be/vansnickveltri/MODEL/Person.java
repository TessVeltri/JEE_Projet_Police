package be.vansnickveltri.MODEL;

import be.vansnickveltri.DAO.AbstractDAOFactory;
import be.vansnickveltri.DAO.DAO;

public abstract class Person {
	
	// Parameters
	private String name;
	private String firstname;
	private String email;
	
	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Person> personDAO = dao.getPersonDAO();

	
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
	
	public int findId () {
		int id = personDAO.findId(this);
		return id;
	}
	
}
