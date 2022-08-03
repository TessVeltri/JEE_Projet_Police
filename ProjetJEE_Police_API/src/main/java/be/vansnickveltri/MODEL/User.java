package be.vansnickveltri.MODEL;

import be.vansnickveltri.DAO.AbstractDAOFactory;
import be.vansnickveltri.DAO.DAO;

public abstract class User extends Person{
	// Parameters
	private String matricule;
	private String password;
	private String typeUser;
	
	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<User> userDAO = dao.getUserDAO();

	
	// Default constructor
	public User() {}
	
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

	@Override
	public int findId() {
		int id = userDAO.findId(this);
		return id;
	}
	
}
