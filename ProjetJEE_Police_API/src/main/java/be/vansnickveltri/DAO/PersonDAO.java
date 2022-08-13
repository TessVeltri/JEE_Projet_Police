package be.vansnickveltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.vansnickveltri.MODEL.Civil;
import be.vansnickveltri.MODEL.Person;

public class PersonDAO extends DAO<Person> {

	public PersonDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Person obj) {
		try {
			Person p = null;
			p = p.find(obj.findId());
			if (p == null) {
				this.connect.createStatement()
					.executeUpdate("INSERT INTO JEE_Civil(name, firstname, email) " 
							+ "Values('" + obj.getName() + "', '" + obj.getFirstname() + "', '" + obj.getEmail()
							+ "')");
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
	public boolean delete(Person obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("DELETE FROM JEE_Civil WHERE idCivil = '" + obj.findId() + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Person obj) {
		try {
			this.connect.createStatement()
				.executeUpdate("UPDATE JEE_Civil SET email = '" + obj.getEmail() 
				+ "' WHERE name = '" + obj.getName() + "' AND firstname = '" + obj.getFirstname() + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int findId(Person obj) {
		int id = 0;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT idCivil FROM JEE_Civil WHERE name = '" + obj.getName() + "' AND firstname = '"
							+ obj.getFirstname() + "'");
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
	public Person find(String str1, String str2) {
		return null;
	}

	@Override
	public Person find(int i) {
		Person person = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT name, firstname, email FROM JEE_Civil WHERE idCivil = " + i );
			if (result.first()) {
				person = new Civil (result.getString("name"), result.getString("firstname"), result.getString("email"));
			}
			return person;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Person> findAll() {
		ArrayList<Person> lst_persons = new ArrayList<>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT name, firstname, email FROM JEE_Civil ORDER BY idCivil");
			while (result.next()) {
				Person person = new Civil(result.getString("name"), result.getString("firstname"), result.getString("email"));
				lst_persons.add(person);
			}
			return lst_persons;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Person> findAll(int i) {
		return null;
	}

}
