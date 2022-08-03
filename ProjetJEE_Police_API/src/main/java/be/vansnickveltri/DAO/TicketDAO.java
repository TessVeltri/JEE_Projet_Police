package be.vansnickveltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.vansnickveltri.MODEL.Ticket;

public class TicketDAO extends DAO<Ticket>{

	public TicketDAO(Connection conn) {
		super(conn);
	}

	// TODO Methode calculateDate dans ticket pour insert en sql
	@Override
	public boolean create(Ticket obj) {
		try {
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
            .executeUpdate(
                    "INSERT INTO JEE_Ticket (ticketDate, isValidate, idVehicle, idUser)"
                    + "Values('"
                        + obj.calculateDate() + "','"
                        + obj.isValidate() + "','"
                        + obj.getVehicle().findId() + "','"
                        + obj.getPoliceman().findId()
                        + "')");
            return true;
        }
        catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public boolean delete(Ticket obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Ticket obj) {
		// TODO Auto-generated method stub
		return false;
	}

	// TODO Vérif si la date passe bien 
	@Override
	public int findId(Ticket obj) {
		int id = 0;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT idTicket FROM JEE_Ticket WHERE ticketDate = '" + obj.getDate() + "' AND idVehicle = '" + obj.getVehicle().findId() + "'");
			if (result.first()) {
				id = result.getInt(1);
			}
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

}
