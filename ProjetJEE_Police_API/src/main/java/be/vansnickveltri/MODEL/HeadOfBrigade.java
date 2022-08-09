package be.vansnickveltri.MODEL;

import java.util.ArrayList;

public class HeadOfBrigade extends User {
	
	// Parameters
	private ArrayList<Policeman> lst_policeman;

	// Default constructor
	public HeadOfBrigade() {}

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
	public void addPoliceman(String matricule) {
		Policeman policeman = new Policeman();
		this.lst_policeman.add(policeman.find(matricule));
	}
	
	public HeadOfBrigade find (int i) {
		HeadOfBrigade h = (HeadOfBrigade) userDAO.find(i);
		return h;
	}

	
}
