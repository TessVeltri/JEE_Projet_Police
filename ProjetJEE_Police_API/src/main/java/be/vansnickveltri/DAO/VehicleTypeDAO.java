package be.vansnickveltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.vansnickveltri.MODEL.VehicleType;

public class VehicleTypeDAO extends DAO<VehicleType> {

	public VehicleTypeDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(VehicleType obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("INSERT INTO JEE_VehicleType(vehicleName)" + 
							"Values('" + obj.getVehicleName() + "')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(VehicleType obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("DELETE FROM JEE_VehicleType WHERE idVehicleType = '" + obj.findId() + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(VehicleType obj) {
		return false;
	}

	@Override
	public int findId(VehicleType obj) {
		int id = 0;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT idVehicleType FROM JEE_VehicleType WHERE vehicleName = '" + obj.getVehicleName() + "'");
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
	public VehicleType find(String str1, String str2) {
		return null;
	}

	@Override
	public VehicleType find(int i) {
		return null;
	}

}
