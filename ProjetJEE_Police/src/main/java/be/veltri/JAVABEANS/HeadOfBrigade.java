package be.veltri.JAVABEANS;

import java.io.Serializable;
import java.util.ArrayList;

import be.veltri.DAO.HeadOfBrigadeDAO;

public class HeadOfBrigade extends User implements Serializable{
	
	// Parameters
	private static final long serialVersionUID = 4775601400071618275L;
	private ArrayList<Policeman> lst_policeman;

	// Default constructor
	public HeadOfBrigade() {
	}

	// Constructor
	public HeadOfBrigade(String name, String firstname, String email, String matricule, String password, String type) {
		super(name, firstname, email, matricule, password, type);
		lst_policeman = new ArrayList<Policeman>();
	}

	// Getters and Setters
	public ArrayList<Policeman> getLst_policeman() {
		return lst_policeman;
	}

	public void setLst_policeman(ArrayList<Policeman> lst_policeman) {
		this.lst_policeman = lst_policeman;
	}
	
	// Methods
	public int findId() {
		HeadOfBrigadeDAO dao = new HeadOfBrigadeDAO();
		return dao.findId(this);
	}
	
}
