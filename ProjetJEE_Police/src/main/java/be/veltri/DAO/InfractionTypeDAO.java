package be.veltri.DAO;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import be.veltri.JAVABEANS.Admin;
import be.veltri.JAVABEANS.InfractionType;
import be.veltri.JAVABEANS.VehicleType;

public class InfractionTypeDAO extends DAO<InfractionType>{

	@Override
	public boolean create(InfractionType obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(InfractionType obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(InfractionType obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int findId(InfractionType obj) {
		MultivaluedMap<String, String> paramsPost = new MultivaluedMapImpl();
		paramsPost.add("infractionName", String.valueOf(obj.getInfractionName()));
		
		ClientResponse res = resource.path("infractionType/find").post(ClientResponse.class, paramsPost);
		String id = res.getEntity(String.class);
		
		int httpResponseCode = res.getStatus();
		
		if(httpResponseCode == 200)
			return Integer.parseInt(id);
		else
			return 0;
	}

	@Override
	public InfractionType find(String str1, String str2) {
		try {
			InfractionType inf = null;
			String responseJSON = resource.path("infractionType/find")
					.path(str1)
					.accept(MediaType.APPLICATION_JSON)
					.get(String.class);
			
			inf = mapper.readValue(responseJSON, InfractionType.class);
			
			return inf;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public InfractionType find(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InfractionType> findAll() {
		ArrayList<InfractionType> lst_types = new ArrayList<>();
		try {
			String responseJSON = resource.path("infractionType")
					.accept(MediaType.APPLICATION_JSON)
					.get(String.class);
			
			lst_types = mapper.readValue(responseJSON, mapper.getTypeFactory().constructCollectionType(ArrayList.class, InfractionType.class));
			
			return lst_types;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public ArrayList<InfractionType> findAll(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
