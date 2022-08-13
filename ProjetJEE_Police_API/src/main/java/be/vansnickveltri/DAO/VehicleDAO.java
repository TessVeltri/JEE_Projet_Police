package be.vansnickveltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.vansnickveltri.MODEL.Civil;
import be.vansnickveltri.MODEL.Person;
import be.vansnickveltri.MODEL.Vehicle;
import be.vansnickveltri.MODEL.VehicleType;

public class VehicleDAO extends DAO<Vehicle>{

	public VehicleDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Vehicle obj) {
		String insurance;
		if (obj.isInsurance()) 
			insurance = "Y";
		else 
			insurance = "N";
		try {
			Vehicle v = null;
			v = v.find(obj.findId());
			if (v == null) {
				this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
	            .executeUpdate(
	                    "INSERT INTO JEE_Vehicle (plateNumberVehicle, isInsurance, idCivil, idVehicleType) "
	                    + "Values('"
	                        + obj.getPlateNumberVehicle() + "','"
	                        + insurance + "','"
	                        + obj.getCivil().findId() + "','"
	                        + obj.getVehicleType().findId()
	                        + "')");
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
		String insurance;
		if (obj.isInsurance()) 
			insurance = "Y";
		else 
			insurance = "N";
		try {
			this.connect.createStatement()
				.executeUpdate("UPDATE JEE_Vehicle SET isInsurance = '" + insurance 
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
		Vehicle vehicle = null;
		boolean insurance;
		Person civil = new Civil();
		VehicleType type = new VehicleType();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT plateNumberVehicle, isInsurance, idCivil, idVehicleType FROM JEE_Vehicle WHERE idVehicle = " + i );
			if (result.first()) {
				if (result.getString("isInsurance").equals("Y"))
					insurance = true;
				else
					insurance = false;
				civil = civil.find(result.getInt("idCivil"));
				type = type.find(result.getInt("idVehicleType"));
				vehicle = new Vehicle(result.getString("plateNumberVehicle"), insurance, (Civil)civil, type);
			}
			return vehicle;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Vehicle> findAll() {
		ArrayList<Vehicle> lst_vehicle = new ArrayList<>();
		boolean insurance;
		Person civil = new Civil();
		VehicleType type = new VehicleType();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT plateNumberVehicle, isInsurance, idCivil, idVehicleType FROM JEE_Vehicle ORDER BY idVehicle");
			while (result.next()) {
				if (result.getString("isInsurance").equals("Y"))
					insurance = true;
				else
					insurance = false;
				civil = civil.find(result.getInt("idCivil"));
				type = type.find(result.getInt("idVehicleType"));
				Vehicle vehicle = new Vehicle(result.getString("plateNumberVehicle"), insurance, (Civil)civil, type);
				lst_vehicle.add(vehicle);
			}
			return lst_vehicle;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Vehicle> findAll(int i) {
		ArrayList<Vehicle> lst_vehicle = new ArrayList<>();
		boolean insurance;
		Person civil = new Civil();
		VehicleType type = new VehicleType();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT plateNumberVehicle, isInsurance, idCivil, idVehicleType FROM JEE_Vehicle "
							+ "WHERE idCivil = " + i + " ORDER BY idVehicle");
			while (result.next()) {
				if (result.getString("isInsurance").equals("Y"))
					insurance = true;
				else
					insurance = false;
				civil = civil.find(i);
				type = type.find(result.getInt("idVehicleType"));
				Vehicle vehicle = new Vehicle(result.getString("plateNumberVehicle"), insurance, (Civil)civil, type);
				lst_vehicle.add(vehicle);
			}
			return lst_vehicle;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
