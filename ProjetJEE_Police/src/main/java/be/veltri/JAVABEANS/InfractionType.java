package be.veltri.JAVABEANS;

import java.io.Serializable;
import java.util.ArrayList;

import be.veltri.DAO.InfractionTypeDAO;

public class InfractionType implements Serializable{

	// Parameters
	private static final long serialVersionUID = -4198561076113968127L;
	private String infractionName;
	private double infractionPrice;

	// Default constructor
	public InfractionType() {
	}

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
	public static ArrayList<InfractionType> findAll(){
		InfractionTypeDAO dao = new InfractionTypeDAO();
		return dao.findAll();
	}
	
	public static InfractionType find (String str1) {
		InfractionTypeDAO dao = new InfractionTypeDAO();
		return dao.find(str1, "");
	}
	
	public int findId() {
		InfractionTypeDAO dao = new InfractionTypeDAO();
		return dao.findId(this);
	}
}
