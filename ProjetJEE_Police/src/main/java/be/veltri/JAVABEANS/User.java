package be.veltri.JAVABEANS;

import java.io.Serializable;

import be.veltri.DAO.UserDAO;

public abstract class User extends Person implements Serializable{
	
	// Parameters
	private static final long serialVersionUID = -8847189526994814510L;
	private String matricule;
	private String password;
	private String typeUser;

	// Default constructor
	public User() {
	}

	// Constructor
	public User(String name, String firstname, String email, String matricule, String password, String typeUser) {
		super(name, firstname, email);
		this.matricule = matricule;
		this.password = password;
		this.typeUser = typeUser;
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

	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}
	
	// Methods
	public static User login (String matricule, String password) {
		UserDAO dao = new UserDAO();
		return dao.find(matricule, password);
	}
}
