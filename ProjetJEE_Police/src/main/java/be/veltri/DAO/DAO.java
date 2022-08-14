package be.veltri.DAO;

import java.net.URI;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.UriBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public abstract class DAO<T> {

	private static String baseURL = null;
	private Client c;
	protected WebResource resource;
	protected ObjectMapper mapper;

	public DAO() {
		try {
			Context context = (Context) new InitialContext().lookup("java:comp/env");
			baseURL = (String) context.lookup("baseURL");
		} catch (NamingException e) {
			e.printStackTrace();
		}

		ClientConfig config = new DefaultClientConfig();
		c = Client.create(config);
		resource = c.resource(getBaseURI());
		mapper = new ObjectMapper();
	}

	public static URI getBaseURI() {
		return UriBuilder.fromUri(baseURL).build();
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
