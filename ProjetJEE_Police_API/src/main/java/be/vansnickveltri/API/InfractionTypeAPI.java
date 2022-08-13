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
import be.vansnickveltri.DAO.InfractionTypeDAO;
import be.vansnickveltri.MODEL.Infraction;
import be.vansnickveltri.MODEL.InfractionType;
import be.vansnickveltri.MODEL.Ticket;

@Path("/infractionType")
public class InfractionTypeAPI {

	private Connection conn;
	private Response response;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createInfractionType(@FormParam("infractionName") String infractionName,
			@FormParam("infractionPrice") double infractionPrice) {
		InfractionType type = new InfractionType(infractionName, infractionPrice);

		conn = DBConnection.getInstance();

		boolean insert = new InfractionTypeDAO(conn).create(type);

		if (insert)
			response = Response.status(Response.Status.CREATED).entity(true).build();
		else
			response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();

		return response;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateInfractionType(@FormParam("infractionName") String infractionName,
			@FormParam("infractionPrice") double infractionPrice) {
		InfractionType type = new InfractionType(infractionName, infractionPrice);

		conn = DBConnection.getInstance();

		boolean update = new InfractionTypeDAO(conn).update(type);

		if (update)
			response = Response.status(Response.Status.OK).entity(true).build();
		else
			response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();

		return response;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteInfractionType(@FormParam("infractionName") String infractionName,
			@FormParam("infractionPrice") double infractionPrice) {
		InfractionType type = new InfractionType(infractionName, infractionPrice);

		conn = DBConnection.getInstance();

		boolean delete = new InfractionTypeDAO(conn).delete(type);

		if (delete)
			response = Response.status(Response.Status.ACCEPTED).entity(true).build();
		else
			response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();

		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllInfractionType() {
		conn = DBConnection.getInstance();
	    
		ArrayList<InfractionType> lst_types = new InfractionTypeDAO(conn).findAll();
	    
		if (!lst_types.isEmpty())
			response = Response.status(Response.Status.OK).entity(lst_types).build();
	    else
	        response = Response.status(Response.Status.NO_CONTENT).build();
	
	    return response;
	}
	
	@POST
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findId(@FormParam("infractionName") String infractionName,
			@FormParam("infractionPrice") double infractionPrice) {
		InfractionType type = new InfractionType(infractionName, infractionPrice);

		conn = DBConnection.getInstance();

		int id = new InfractionTypeDAO(conn).findId(type);

		if (id > 0)
			response = Response.status(Response.Status.OK).entity(id).build();
		else
			response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();

		return response;
	}
	
}
