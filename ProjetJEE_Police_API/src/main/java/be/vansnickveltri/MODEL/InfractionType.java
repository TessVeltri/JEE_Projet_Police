package be.vansnickveltri.MODEL;

import java.util.ArrayList;

import be.vansnickveltri.DAO.AbstractDAOFactory;
import be.vansnickveltri.DAO.DAO;

public class InfractionType {

	// Parameters
	private String infractionName;
	private double infractionPrice;
	
	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<InfractionType> infractionTypeDAO = dao.getInfractionTypeDAO();

	
	// Default constructor
	public InfractionType() {}
	
	// Default
	public InfractionType(String infractionName, double infractionPrice) {
		this.infractionName = infractionName;
		this.infractionPrice = infractionPrice;
	}

	// Getters and Setters
	public String getInfractionName() {
		return infractionName;
	}

	public void setInfractionName(String infractionName) {
		this.infractionName = infractionName;
	}

	public double getInfractionPrice() {
		return infractionPrice;
	}

	public void setInfractionPrice(double infractionPrice) {
		this.infractionPrice = infractionPrice;
	}
	
	// Methods
	public boolean create (InfractionType obj) {
		return infractionTypeDAO.create(obj);
	}
	
	public boolean delete (InfractionType obj) {
		return infractionTypeDAO.delete(obj);
	}
	
	public boolean update (InfractionType obj) {
		return infractionTypeDAO.update(obj);
	}
	
	public int findId () {
		return infractionTypeDAO.findId(this);
	}
	
	public InfractionType find (String str1, String str2) {
		return infractionTypeDAO.find(str1, str2);
	}
	
	public InfractionType find (int i) {
		return infractionTypeDAO.find(i);
	}
	
	public ArrayList<InfractionType> findAll(int i){
		return infractionTypeDAO.findAll(i);
	}
	
	
}
