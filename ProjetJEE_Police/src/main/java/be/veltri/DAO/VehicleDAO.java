package be.veltri.DAO;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import be.veltri.JAVABEANS.Vehicle;

public class VehicleDAO extends DAO<Vehicle>{

	@Override
	public boolean create(Vehicle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Vehicle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Vehicle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int findId(Vehicle obj) {
		
		MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
		paramsPost.add("plateNumberVehicle", obj.getPlateNumberVehicle());
		//paramsPost.add("isInsurance",String.valueOf(obj.isInsurance()));
		//paramsPost.add("idCivil", String.valueOf(obj.getCivil().findId()));
		//paramsPost.add("idVehicleType", String.valueOf(obj.getVehicleType().findId()));
	
		
		ClientResponse res = resource.path("vehicle/find").accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, paramsPost);
		String id = res.getEntity(String.class);
		
		int httpResponseCode = res.getStatus();
		
		if(httpResponseCode == 200)
			return Integer.parseInt(id);
		else
			return 0;
	}

	@Override
	public Vehicle find(String str1, String str2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicle find(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Vehicle> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Vehicle> findAll(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
