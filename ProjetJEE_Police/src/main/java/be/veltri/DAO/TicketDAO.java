package be.veltri.DAO;

import java.util.ArrayList;

import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import be.veltri.JAVABEANS.Ticket;

public class TicketDAO extends DAO<Ticket>{

	@Override
	public boolean create(Ticket obj) {
		MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
		paramsPost.add("date", String.valueOf(obj.getDate()));
		paramsPost.add("hour",obj.getHour());
		paramsPost.add("isValidate", String.valueOf(obj.isValidate()));
		paramsPost.add("isPayed", String.valueOf(obj.isPayed()));
		paramsPost.add("idVehicle", String.valueOf(obj.getVehicle().findId()));
		paramsPost.add("idUser", String.valueOf(obj.getPoliceman().findId()));
		
		ClientResponse res = resource.path("ticket").post(ClientResponse.class, paramsPost);
	
		int httpResponseCode = res.getStatus();
		
		if(httpResponseCode == 201)
			return true;
		else
			return false;
	}

	@Override
	public boolean delete(Ticket obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Ticket obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int findId(Ticket obj) {
		MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
		paramsPost.add("date", String.valueOf(obj.getDate()));
		paramsPost.add("hour",obj.getHour());
		paramsPost.add("isValidate", String.valueOf(obj.isValidate()));
		paramsPost.add("isPayed", String.valueOf(obj.isPayed()));
		paramsPost.add("idVehicle", String.valueOf(obj.getVehicle().findId()));
		paramsPost.add("idUser", String.valueOf(obj.getPoliceman().findId()));
		
		ClientResponse res = resource.path("ticket/find").post(ClientResponse.class, paramsPost);
		String id = res.getEntity(String.class);
		
		int httpResponseCode = res.getStatus();
		
		if(httpResponseCode == 200)
			return Integer.parseInt(id);
		else
			return 0;
	}

	@Override
	public Ticket find(String str1, String str2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket find(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Ticket> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Ticket> findAll(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
