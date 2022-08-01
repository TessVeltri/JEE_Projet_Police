package be.vansnickveltri.MODEL;

public class InfractionType {

	// Parameters
	private String infractionName;
	private double infractionPrice;
	
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
	
	
	
}
