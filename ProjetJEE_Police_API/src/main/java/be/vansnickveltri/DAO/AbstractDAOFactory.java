package be.vansnickveltri.DAO;

import be.vansnickveltri.MODEL.*;

public abstract class AbstractDAOFactory {
	public static final int DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;
	
	public abstract DAO<Infraction> getInfractionDAO();
	
	public abstract DAO<InfractionType> getInfractionTypeDAO();
	
	public abstract DAO<Person> getPersonDAO();
	
	public abstract DAO<Ticket> getTicketDAO();
	
	public abstract DAO<User> getUserDAO();
	
	public abstract DAO<Policeman> getPolicemanDAO();
	
	public abstract DAO<Vehicle> getVehicleDAO();
	
	public abstract DAO<VehicleType> getVehicleTypeDAO();
	
	public static AbstractDAOFactory getFactory(int type){
		switch(type){
		case DAO_FACTORY:
			return new DAOFactory();
			default:
				return null;
		}
	}
}
