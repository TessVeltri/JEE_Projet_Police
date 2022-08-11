package be.vansnickveltri.MODEL;

import java.util.ArrayList;

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
	
	// Methods
	public boolean create (Person obj) {
		return personDAO.create(obj);
	}
	
	public boolean delete (Person obj) {
		return personDAO.delete(obj);
	}
	
	public boolean update (Person obj) {
		return personDAO.update(obj);
	}
	public int findId () {
		return personDAO.findId(this);
	}
	
	public Person find (int i) {
		return personDAO.find(i);
	}
	
	public ArrayList<Person> getAll (){
		return personDAO.getAll();
	}
	
}
