package be.veltri.DAO;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.ClientResponse;

import be.veltri.JAVABEANS.Admin;
import be.veltri.JAVABEANS.FineCollector;
import be.veltri.JAVABEANS.HeadOfBrigade;
import be.veltri.JAVABEANS.Policeman;
import be.veltri.JAVABEANS.User;

public class UserDAO extends DAO<User> {

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User find(String matricule, String password) {
		try {
			User user = null;
			
			String res = resource.path("user")
					.path(matricule)
					.path(password)
					.accept(MediaType.APPLICATION_JSON)
					.get(String.class);
			
			String responseJSON = res.toString();
			
			final ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readValue(responseJSON.toString(), JsonNode.class);
			String typeUser = jsonNode.get("typeUser").textValue();
						
			switch (typeUser) {
				case "Admin":
					user = mapper.readValue(responseJSON.toString(), Admin.class);
					break;
				case "Head of brigade":
					user = mapper.readValue(responseJSON.toString(), HeadOfBrigade.class);
					break;
				case "Fine collector":
					user = mapper.readValue(responseJSON.toString(), FineCollector.class);
					break;
				case "Policeman":
					user = mapper.readValue(responseJSON.toString(), Policeman.class);
					break;
			}
			return user;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public User find(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> findAll(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
