package be.vansnickveltri.DAO;

import java.sql.Connection;

import be.vansnickveltri.MODEL.Infraction;
import be.vansnickveltri.MODEL.InfractionType;
import be.vansnickveltri.MODEL.Person;
import be.vansnickveltri.MODEL.Ticket;
import be.vansnickveltri.MODEL.User;
import be.vansnickveltri.MODEL.Vehicle;
import be.vansnickveltri.MODEL.VehicleType;

public class DAOFactory extends AbstractDAOFactory{
	
	protected static final Connection conn = DBConnection.getInstance();

	public DAO<Infraction> getInfractionDAO() {
		return new InfractionDAO (conn);
	}

	public DAO<InfractionType> getInfractionTypeDAO() {
		return new InfractionTypeDAO (conn);
	}

	public DAO<Person> getPersonDAO() {
		return new PersonDAO (conn);
	}

	public DAO<Ticket> getTicketDAO() {
		return new TicketDAO(conn);
	}

	public DAO<User> getUserDAO() {
		return new UserDAO (conn);
	}

	public DAO<Vehicle> getVehicleDAO() {
		return new VehicleDAO (conn);
	}

	public DAO<VehicleType> getVehicleTypeDAO() {
		return new VehicleTypeDAO (conn);
	}

}
