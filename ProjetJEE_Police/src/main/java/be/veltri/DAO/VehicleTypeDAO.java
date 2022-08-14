package be.veltri.DAO;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import be.veltri.JAVABEANS.VehicleType;

public class VehicleTypeDAO extends DAO<VehicleType>{

	@Override
	public boolean create(VehicleType obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(VehicleType obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(VehicleType obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int findId(VehicleType obj) {
		MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
		paramsPost.add("name", String.valueOf(obj.getVehicleName()));
		
		ClientResponse res = resource.path("vehicleType/find").post(ClientResponse.class, paramsPost);
		int id = res.getEntity(Integer.class);
		
		int httpResponseCode = res.getStatus();
		
		if(httpResponseCode == 201)
			return id;
		else
			return 0;
	}

	@Override
	public VehicleType find(String str1, String str2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehicleType find(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VehicleType> findAll() {
		ArrayList<VehicleType> lst_types = new ArrayList<>();
		try {
			String responseJSON = resource.path("vehicleType")
					.accept(MediaType.APPLICATION_JSON)
					.get(String.class);
			
			lst_types = mapper.readValue(responseJSON, mapper.getTypeFactory().constructCollectionType(ArrayList.class, VehicleType.class));
			
			return lst_types;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public ArrayList<VehicleType> findAll(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
