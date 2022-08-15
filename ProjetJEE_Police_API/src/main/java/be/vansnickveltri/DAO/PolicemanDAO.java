package be.vansnickveltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.vansnickveltri.MODEL.Policeman;
import be.vansnickveltri.MODEL.HeadOfBrigade;

public class PolicemanDAO extends DAO<Policeman> {

	public PolicemanDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Policeman obj) {
		try {
			Policeman p = new Policeman();
			p = p.find(obj.getMatricule(), obj.getPassword());
			if (p == null) {
				this.connect.createStatement()
						.executeUpdate("CALL JEE_INSERT_USER ('" + obj.getName() + "', '" + obj.getFirstname() + "', '"
								+ obj.getMatricule() + "','" + obj.getPassword() + "', '" + obj.getTypeUser() + "', '"
								+ obj.getHeadOfBrigade().findId() + "','" + obj.getEmail() + "')");
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Policeman obj) {
		return false;
	}

	@Override
	public boolean update(Policeman obj) {
		return false;
	}

	@Override
	public int findId(Policeman obj) {
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
	public Policeman find(String matricule, String password) {
		Policeman policeman = null;
		HeadOfBrigade head = new HeadOfBrigade();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT name, firstname, email, matricule, password, typeUser, idHeadOfBrigade "
							+ "FROM JEE_User WHERE matricule = '" + matricule + "' AND password = '" + password + "'");
			if (result.first()) {
				head = head.find(result.getInt("idHeadOfBrigade"));
				policeman = new Policeman(result.getString("name"), result.getString("firstname"),
						result.getString("email"), matricule, password, result.getString("typeUser"), head);
			}
			return policeman;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Policeman find(int i) {
		Policeman policeman = new Policeman();
		HeadOfBrigade head = new HeadOfBrigade();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT name, firstname, email, matricule, password, typeUser, idHeadOfBrigade "
							+ "FROM JEE_User WHERE idUser = " + i);
			if (result.first())
				head = head.find(result.getInt("idHeadOfBrigade"));
			policeman = new Policeman(result.getString("name"), result.getString("firstname"),
					result.getString("email"), result.getString("matricule"), result.getString("password"),
					result.getString("typeUser"), head);
			return policeman;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Policeman> findAll() {
		ArrayList<Policeman> lst_users = new ArrayList<>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT name, firstname, email, matricule, password, typeUser, idHeadOfBrigade FROM JEE_User "
									+ "WHERE idHeadOfBrigade IS NOT NULL");
			while (result.next()) {
				HeadOfBrigade head = new HeadOfBrigade();
				head = head.find(result.getInt("idHeadOfBrigade"));
				Policeman policeman = new Policeman(result.getString("name"), result.getString("firstname"),
						result.getString("email"), result.getString("matricule"), result.getString("password"),
						result.getString("typeUser"), head);

				lst_users.add(policeman);
			}
			return lst_users;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Policeman> findAll(int i) {
		ArrayList<Policeman> lst_users = new ArrayList<>();
		HeadOfBrigade head = new HeadOfBrigade();
		head = head.find(i);
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT name, firstname, email, matricule, password, typeUser, idHeadOfBrigade FROM JEE_User "
									+ "WHERE idHeadOfBrigade = " + i);
			while (result.next()) {
				Policeman policeman = new Policeman(result.getString("name"), result.getString("firstname"),
						result.getString("email"), result.getString("matricule"), result.getString("password"),
						result.getString("typeUser"), head);

				lst_users.add(policeman);
			}
			return lst_users;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
