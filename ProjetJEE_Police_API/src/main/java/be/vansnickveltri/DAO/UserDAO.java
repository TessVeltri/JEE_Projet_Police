package be.vansnickveltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.vansnickveltri.MODEL.User;

public class UserDAO extends DAO<User>{

	public UserDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User obj) {
		// TODO Auto-generated method stub
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

}
