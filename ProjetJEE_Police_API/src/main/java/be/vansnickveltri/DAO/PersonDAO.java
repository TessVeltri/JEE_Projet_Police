package be.vansnickveltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.vansnickveltri.MODEL.Person;

public class PersonDAO extends DAO<Person> {

	public PersonDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Person obj) {
		try {
			this.connect.createStatement()
					.executeUpdate("INSERT INTO JEE_Civil(name, firstname, email) " 
							+ "Values('" + obj.getName() + "', '" + obj.getFirstname() + "', '" + obj.getEmail()
							+ "')");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Person obj) {
		return false;
	}

	@Override
	public boolean update(Person obj) {
		return false;
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
		return null;
	}

}
