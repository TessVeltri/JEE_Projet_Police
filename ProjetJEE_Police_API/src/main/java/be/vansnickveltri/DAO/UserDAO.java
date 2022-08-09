package be.vansnickveltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.vansnickveltri.MODEL.Admin;
import be.vansnickveltri.MODEL.FineCollector;
import be.vansnickveltri.MODEL.HeadOfBrigade;
import be.vansnickveltri.MODEL.Policeman;
import be.vansnickveltri.MODEL.User;

public class UserDAO extends DAO<User> {

	public UserDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(User obj) {
		try {
			this.connect.createStatement().executeUpdate(
					"INSERT INTO JEE_User(name, firstname, matricule, password, typeUser, email ,  idHeadOfBrigade) "
							+ "Values('" + obj.getName() + "', '" + obj.getFirstname() + "', '" + obj.getMatricule()
							+ "', '" + obj.getPassword() + "', '" + obj.getTypeUser() + "', '" + obj.getEmail() + "', NULL)");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(User obj) {
		return false;
	}

	@Override
	public boolean update(User obj) {
		return false;
	}

	@Override
	public int findId(User obj) {
		int id = 0;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT idUser FROM JEE_User WHERE matricule = '" + obj.getMatricule()
							+ "' AND password = '" + obj.getPassword() + "'");
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
	public User find(String matricule, String password) {
		User user = null;
		HeadOfBrigade head = new HeadOfBrigade();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT name, firstname, email, matricule, password, typeUser, idHeadOfBrigade"
							+ "FROM JEE_User WHERE matricule = '" + matricule + "' AND password = '" + password + "'");
			if (result.first())
				switch (result.getString("typeUser")) {
				case "HeadOfBrigade":
					user = new HeadOfBrigade(result.getString("name"), result.getString("firstname"),
							result.getString("email"), matricule, password, result.getString("typeUser"));
					break;
				case "Policeman":
					head = head.find(result.getInt("idHeadOfBrigade"));
					user = new Policeman(result.getString("name"), result.getString("firstname"),
							result.getString("email"), matricule, password, result.getString("typeUser"), head);
					break;
				case "FineCollector":
					user = new FineCollector(result.getString("name"), result.getString("firstname"),
							result.getString("email"), matricule, password, result.getString("typeUser"));
				}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User find(int i) {
		User user = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT name, firstname, email, matricule, password, typeUser"
							+ "FROM JEE_User WHERE idUser = '" + i + "'");
			if (result.first()) {
				if (result.getString("typeUser").equals("HeadOfBrigade")) {
					user = new HeadOfBrigade(result.getString("name"), result.getString("firstname"),
							result.getString("email"), result.getString("maticule"), result.getString("password"),
							result.getString("typeUser"));
				} else if (result.getString("typeUser").equals("Admin")) {
					user = new Admin(result.getString("name"), result.getString("firstname"), result.getString("email"),
							result.getString("maticule"), result.getString("password"), result.getString("typeUser"));
				} else {
					user = new FineCollector(result.getString("name"), result.getString("firstname"),
							result.getString("email"), result.getString("maticule"), result.getString("password"),
							result.getString("typeUser"));
				}
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
