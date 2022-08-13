package be.vansnickveltri.DAO;

import java.sql.Connection;
import java.util.ArrayList;

public abstract class DAO<T> {

	protected Connection connect = null;

	public DAO(Connection conn) {
		this.connect = DBConnection.getInstance();
	}

	public abstract boolean create(T obj);

	public abstract boolean delete(T obj);

	public abstract boolean update(T obj);

	public abstract int findId(T obj);

	public abstract T find(String str1, String str2);

	public abstract T find(int i);
	
	public abstract ArrayList<T> findAll ();
	
	public abstract ArrayList<T> findAll (int i);	
	
}
