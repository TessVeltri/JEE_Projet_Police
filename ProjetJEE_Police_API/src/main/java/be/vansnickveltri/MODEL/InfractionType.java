package be.vansnickveltri.MODEL;

import be.vansnickveltri.DAO.AbstractDAOFactory;
import be.vansnickveltri.DAO.DAO;
import be.vansnickveltri.DAO.InfractionTypeDAO;

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
	public int findId () {
		int id = infractionTypeDAO.findId(this);
		return id;
	}
	
	
}
