package be.vansnickveltri.API;

import java.sql.Connection;
import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import be.vansnickveltri.DAO.DBConnection;
import be.vansnickveltri.DAO.InfractionDAO;
import be.vansnickveltri.DAO.PersonDAO;
import be.vansnickveltri.MODEL.Civil;
import be.vansnickveltri.MODEL.Infraction;
import be.vansnickveltri.MODEL.InfractionType;
import be.vansnickveltri.MODEL.Person;
import be.vansnickveltri.MODEL.Ticket;

@Path("/civil")
public class PersonAPI {

	private Connection conn;
	private Response response;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createPerson(@FormParam("name") String name, @FormParam("firstname") String firstname,
			@FormParam("email") String email) {
		
		Civil civil = new Civil (name, firstname, email);
		
		conn = DBConnection.getInstance();

		boolean insert = new PersonDAO(conn).create(civil);

		if (insert)
			response = Response.status(Response.Status.CREATED).entity(true).build();
		else
			response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();

		return response;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePerson(@FormParam("name") String name, @FormParam("firstname") String firstname,
			@FormParam("email") String email) {
		
		Civil civil = new Civil (name, firstname, email);
		
		conn = DBConnection.getInstance();

		boolean update = new PersonDAO(conn).update(civil);

		if (update)
			response = Response.status(Response.Status.OK).entity(true).build();
		else
			response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();

		return response;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePerson(@FormParam("name") String name, @FormParam("firstname") String firstname,
			@FormParam("email") String email) {
		
		Civil civil = new Civil (name, firstname, email);
		
		conn = DBConnection.getInstance();

		boolean delete = new PersonDAO(conn).delete(civil);

		if (delete)
			response = Response.status(Response.Status.ACCEPTED).entity(true).build();
		else
			response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();

		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPersons() {
		conn = DBConnection.getInstance();
	    
		ArrayList<Person> civils = new PersonDAO(conn).findAll();
	    
		if (!civils.isEmpty())
			response = Response.status(Response.Status.OK).entity(civils).build();
	    else
	        response = Response.status(Response.Status.NO_CONTENT).build();
	
	    return response;
	}
	
	@POST
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findId(@FormParam("name") String name, @FormParam("firstname") String firstname,
			@FormParam("email") String email) {
		
		Civil civil = new Civil (name, firstname, email);
		
		conn = DBConnection.getInstance();

		int id = new PersonDAO(conn).findId(civil);

		if (id > 0)
			response = Response.status(Response.Status.OK).entity(id).build();
		else
			response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();

		return response;
	}
	
}
