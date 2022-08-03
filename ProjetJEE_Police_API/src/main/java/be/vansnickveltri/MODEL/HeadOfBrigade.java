package be.vansnickveltri.MODEL;

import java.util.ArrayList;

public class HeadOfBrigade extends User {
	
	// Parameters
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
	public void addPoliceman(String matricule) {
		// TODO rechercher le policier avec le matricule et le rajouter à la liste
		this.lst_policeman.add(new Policeman());
	}

	
}
