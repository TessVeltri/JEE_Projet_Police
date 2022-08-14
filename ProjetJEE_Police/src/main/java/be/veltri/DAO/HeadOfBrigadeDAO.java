package be.veltri.DAO;

import java.util.ArrayList;

import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import be.veltri.JAVABEANS.HeadOfBrigade;

public class HeadOfBrigadeDAO extends DAO<HeadOfBrigade>{

	@Override
	public boolean create(HeadOfBrigade obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(HeadOfBrigade obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(HeadOfBrigade obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int findId(HeadOfBrigade obj) {
		MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
		paramsPost.add("name", String.valueOf(obj.getName()));
		paramsPost.add("firstname",String.valueOf(obj.getFirstname()));
		paramsPost.add("email", String.valueOf(obj.getEmail()));
		paramsPost.add("matricule", String.valueOf(obj.getMatricule()));
		paramsPost.add("password", String.valueOf(obj.getPassword()));
		paramsPost.add("typeUser", String.valueOf(obj.getTypeUser()));
		paramsPost.add("idHeadOfBrigade", null);
		
		ClientResponse res = resource.path("user/find").post(ClientResponse.class, paramsPost);
		int id = res.getEntity(Integer.class);
		
		int httpResponseCode = res.getStatus();
		
		if(httpResponseCode == 201)
			return id;
		else
			return 0;
	}

	@Override
	public HeadOfBrigade find(String str1, String str2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HeadOfBrigade find(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HeadOfBrigade> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HeadOfBrigade> findAll(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
