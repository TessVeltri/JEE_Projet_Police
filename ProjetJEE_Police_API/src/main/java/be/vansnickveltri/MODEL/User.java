package be.vansnickveltri.MODEL;

import java.util.ArrayList;

import be.vansnickveltri.DAO.AbstractDAOFactory;
import be.vansnickveltri.DAO.DAO;

public abstract class User extends Person{
	// Parameters
	private String matricule;
	private String password;
	private String typeUser;
	
	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	protected static DAO<User> userDAO = dao.getUserDAO();

	
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

	// Methods
	public boolean create (User user) {
		return userDAO.create(user);
	}
	
	public boolean delete (User user) {
		return userDAO.delete(user);
	}
	
	public boolean update (User user) {
		return userDAO.update(user);
	}
	
	@Override
	public int findId() {
		return userDAO.findId(this);
	}
	
	public User find (String matricule, String password) {
		return userDAO.find(matricule, password);
	}
	
	public User find (int i) {
		return userDAO.find(i);
	}
	
	public ArrayList<User> findAllUser(){
		return userDAO.findAll();
	}
	
}
