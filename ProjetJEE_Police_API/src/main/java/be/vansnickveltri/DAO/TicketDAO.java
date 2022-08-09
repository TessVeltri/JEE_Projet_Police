package be.vansnickveltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.vansnickveltri.MODEL.Ticket;

public class TicketDAO extends DAO<Ticket>{

	public TicketDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Ticket obj) {
		try {
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
            .executeUpdate(
                    "INSERT INTO JEE_Ticket (ticketDate, isValidate, idVehicle, idUser, ticketHour)"
                    + "Values('"
                        + obj.getDate() + "','"
                        + obj.isValidate() + "','"
                        + obj.getVehicle().findId() + "','"
                        + obj.getPoliceman().findId() + "','"
                        + obj.getHour()
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
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("DELETE FROM JEE_Ticket WHERE idTicket = '" + obj.findId() + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Ticket obj) {
		try {
			this.connect.createStatement()
				.executeUpdate("UPDATE JEE_Ticket SET isValidate '" + obj.isValidate() 
				+ "' WHERE idTicket = '" + obj.findId() + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
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

	@Override
	public Ticket find(String str1, String str2) {
		return null;
	}

	@Override
	public Ticket find(int i) {
		return null;
	}

}
