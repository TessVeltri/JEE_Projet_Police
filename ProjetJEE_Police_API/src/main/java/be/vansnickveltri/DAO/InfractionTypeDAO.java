package be.vansnickveltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.vansnickveltri.MODEL.InfractionType;

public class InfractionTypeDAO extends DAO<InfractionType>{

	public InfractionTypeDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(InfractionType obj) {
		try {
			InfractionType it = new InfractionType();
			it = it.find(obj.findId());
			if(it == null) {
				this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
	            .executeUpdate(
	                    "INSERT INTO JEE_InfractionType (infractionName, infractionPrice)"
	                    + " Values('"
	                        + obj.getInfractionName() + "',"
	                        + obj.getInfractionPrice()
	                        + ")");
	            return true;
			} else {
				return false;
			}
            
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
				.executeUpdate("UPDATE JEE_InfractionType SET infractionPrice = " + obj.getInfractionPrice() 
				+ " WHERE infractionName = '" + obj.getInfractionName() + "'");
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
		InfractionType type = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT infractionName, infractionPrice FROM JEE_InfractionType WHERE infractionName = '" + str1 + "'");
			if (result.first()) {
				type = new InfractionType (result.getString("infractionName"), result.getDouble("infractionPrice"));
			}
			return type;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public InfractionType find(int i) {
		InfractionType type = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT infractionName, infractionPrice FROM JEE_InfractionType WHERE idInfractionType = " + i );
			if (result.first()) {
				type = new InfractionType (result.getString("infractionName"), result.getDouble("infractionPrice"));
			}
			return type;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<InfractionType> findAll() {
		ArrayList<InfractionType> lst_infractionTypes = new ArrayList<>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT infractionName, infractionPrice FROM JEE_InfractionType ORDER BY idInfractionType");
			while (result.next()) {
				InfractionType type = new InfractionType(result.getString("infractionName"), result.getDouble("infractionPrice"));
				lst_infractionTypes.add(type);
			}
			return lst_infractionTypes;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<InfractionType> findAll(int i) {
		return null;
	}

}
