package be.vansnickveltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.vansnickveltri.MODEL.Vehicle;

public class VehicleDAO extends DAO<Vehicle>{

	public VehicleDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Vehicle obj) {
		try {
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
            .executeUpdate(
                    "INSERT INTO JEE_Vehicle (plateNumberVehicle, isInsurance, idCivil, idVehicleType)"
                    + "Values('"
                        + obj.getPlateNumberVehicle() + "','"
                        + obj.isInsurance() + "','"
                        + obj.getCivil().findId() + "','"
                        + obj.getVehicleType().findId()
                        + "')");
            return true;
        }
        catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public boolean delete(Vehicle obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("DELETE FROM JEE_Vehicle WHERE plateNumberVehicle = '" + obj.getPlateNumberVehicle() + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Update only the insurance
	@Override
	public boolean update(Vehicle obj) {
		try {
			this.connect.createStatement()
				.executeUpdate("UPDATE JEE_Vehicle SET isInsurance '" + obj.isInsurance() 
				+ "' WHERE plateNumberVehicle = '" + obj.getPlateNumberVehicle() + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int findId(Vehicle obj) {
		int id = 0;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT idVehicle FROM JEE_Vehicle WHERE plateNumberVehicle = '" + obj.getPlateNumberVehicle() + "'");
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
	public Vehicle find(String str1, String str2) {
		return null;
	}

	@Override
	public Vehicle find(int i) {
		return null;
	}

}
