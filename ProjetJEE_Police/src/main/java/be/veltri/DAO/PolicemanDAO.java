package be.veltri.DAO;

import java.util.ArrayList;

import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import be.veltri.JAVABEANS.Policeman;

public class PolicemanDAO extends DAO<Policeman>{

	@Override
	public boolean create(Policeman obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Policeman obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Policeman obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	
	public int findId(Policeman obj) {
		MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
		paramsPost.add("name", String.valueOf(obj.getName()));
		paramsPost.add("firstname",String.valueOf(obj.getFirstname()));
		paramsPost.add("email", String.valueOf(obj.getEmail()));
		paramsPost.add("matricule", String.valueOf(obj.getMatricule()));
		paramsPost.add("password", String.valueOf(obj.getPassword()));
		paramsPost.add("typeUser", String.valueOf(obj.getTypeUser()));
		paramsPost.add("idHeadOfBrigade", String.valueOf(obj.getHeadOfBrigade().findId()));
		
		String res = resource.path("user/find").post(String.class, paramsPost);
		int id = Integer.parseInt(res);
		
		return id;

	}

	@Override
	public Policeman find(String str1, String str2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Policeman find(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Policeman> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Policeman> findAll(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
