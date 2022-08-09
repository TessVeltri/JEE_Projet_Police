package be.vansnickveltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.vansnickveltri.MODEL.InfractionType;

public class InfractionTypeDAO extends DAO<InfractionType>{

	public InfractionTypeDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(InfractionType obj) {
		try {
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
            .executeUpdate(
                    "INSERT INTO JEE_InfractionType (infractionName, infractionPrice)"
                    + "Values('"
                        + obj.getInfractionName() + "','"
                        + obj.getInfractionPrice()
                        + "')");
            return true;
        }
        catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public boolean delete(InfractionType obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("DELETE FROM JEE_InfractionType WHERE idInfractionType = '" + obj.findId() + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(InfractionType obj) {
		try {
			this.connect.createStatement()
				.executeUpdate("UPDATE JEE_InfractionType SET infractionPrice '" + obj.getInfractionPrice() 
				+ "' WHERE infractionName = '" + obj.getInfractionName() + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int findId(InfractionType obj) {
		int id = 0;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT idInfractionType FROM JEE_InfractionType WHERE infractionName = '" + obj.getInfractionName() + "'");
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
	public InfractionType find(String str1, String str2) {
		return null;
	}

	@Override
	public InfractionType find(int i) {
		return null;
	}

}
