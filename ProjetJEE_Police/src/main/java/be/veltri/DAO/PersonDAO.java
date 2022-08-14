package be.veltri.DAO;

import java.util.ArrayList;

import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import be.veltri.JAVABEANS.Person;

public class PersonDAO extends DAO<Person>{

	@Override
	public boolean create(Person obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Person obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Person obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int findId(Person obj) {
		MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
		paramsPost.add("name", String.valueOf(obj.getName()));
		paramsPost.add("firstname", String.valueOf(obj.getFirstname()));
		paramsPost.add("email", String.valueOf(obj.getEmail()));
		
		ClientResponse res = resource.path("civil/find").post(ClientResponse.class, paramsPost);
		int id = res.getEntity(Integer.class);
		
		int httpResponseCode = res.getStatus();
		
		if(httpResponseCode == 201)
			return id;
		else
			return 0;
	}

	@Override
	public Person find(String str1, String str2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person find(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Person> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Person> findAll(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
