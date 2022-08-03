package be.vansnickveltri.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

import be.vansnickveltri.MODEL.Infraction;

public class InfractionDAO  extends DAO<Infraction>{

	public InfractionDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Infraction obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
            .executeUpdate(
                    "INSERT INTO JEE_Infraction (infractionComment, idTicket, idInfractiontType)"
                    + "Values('"
                        + obj.getComment() + "','"
                    	+ obj.getTicket().findId() + "','"
                        + obj.getInfractionType().findId() + "')");
            return true;
			
		}
		catch (SQLException e) {
			e.printStackTrace();
            return false;
		}
	}

	@Override
	public boolean delete(Infraction obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("DELETE FROM JEE_Infraction WHERE idInfraction = '" + obj.findId() + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Infraction obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int findId(Infraction obj) {
		int id = 0;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT idInfraction FROM JEE_Infraction WHERE idTicket = '" + obj.getTicket().findId() + "' AND idInfractiontType = '" + obj.getInfractionType().findId()+ "'");
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
