package be.veltri.DAO;

import java.util.ArrayList;

import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import be.veltri.JAVABEANS.Infraction;

public class InfractionDAO extends DAO <Infraction>{

	@Override
	public boolean create(Infraction obj) {
		MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
		paramsPost.add("comment", String.valueOf(obj.getComment()));
		paramsPost.add("idTicket", String.valueOf(obj.getTicket().findId()));
		paramsPost.add("idInfractionType", String.valueOf(obj.getInfractionType().findId()));
		
		ClientResponse res = resource.path("infraction").post(ClientResponse.class, paramsPost);
		String bit = res.getEntity(String.class);
	
		int httpResponseCode = res.getStatus();
		
		if(httpResponseCode == 201)
			return true;
		else
			return false;
	}

	@Override
	public boolean delete(Infraction obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Infraction obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int findId(Infraction obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Infraction find(String str1, String str2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Infraction find(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Infraction> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Infraction> findAll(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
