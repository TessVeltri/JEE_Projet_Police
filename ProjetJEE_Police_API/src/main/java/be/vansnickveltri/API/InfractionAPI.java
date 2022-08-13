package be.vansnickveltri.API;

import java.sql.Connection;
import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import be.vansnickveltri.DAO.DBConnection;
import be.vansnickveltri.DAO.InfractionDAO;
import be.vansnickveltri.MODEL.Infraction;
import be.vansnickveltri.MODEL.InfractionType;
import be.vansnickveltri.MODEL.Ticket;

@Path("/infraction")
public class InfractionAPI {

	private Connection conn;
	private Response response;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createInfraction(@FormParam("comment") String comment, @FormParam("idTicket") int idTicket,
			@FormParam("idInfractionType") int idInfractionType) {
		Ticket ticket = new Ticket();
		InfractionType type = new InfractionType();
		ticket = ticket.find(idTicket);
		type = type.find(idInfractionType);
		Infraction infraction = new Infraction (comment, ticket, type);
		
		conn = DBConnection.getInstance();

		boolean insert = new InfractionDAO(conn).create(infraction);

		if (insert)
			response = Response.status(Response.Status.CREATED).entity(true).build();
		else
			response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();

		return response;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteInfraction(@FormParam("comment") String comment, @FormParam("idTicket") int idTicket,
			@FormParam("idInfractionType") int idInfractionType) {
		Ticket ticket = new Ticket();
		InfractionType type = new InfractionType();
		ticket = ticket.find(idTicket);
		type = type.find(idInfractionType);
		Infraction infraction = new Infraction (comment, ticket, type);
		
		conn = DBConnection.getInstance();

		boolean delete = new InfractionDAO(conn).delete(infraction);

		if (delete)
			response = Response.status(Response.Status.ACCEPTED).entity(true).build();
		else
			response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();

		return response;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateInfraction(@FormParam("comment") String comment, @FormParam("idTicket") int idTicket,
			@FormParam("idInfractionType") int idInfractionType) {
		Ticket ticket = new Ticket();
		InfractionType type = new InfractionType();
		ticket = ticket.find(idTicket);
		type = type.find(idInfractionType);
		Infraction infraction = new Infraction (comment, ticket, type);
		
		conn = DBConnection.getInstance();

		boolean update = new InfractionDAO(conn).update(infraction);

		if (update)
			response = Response.status(Response.Status.ACCEPTED).entity(true).build();
		else
			response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();

		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllInfractions() {
		conn = DBConnection.getInstance();
	    
		ArrayList<Infraction> infractions = new InfractionDAO(conn).findAll();
	    
		if (!infractions.isEmpty())
			response = Response.status(Response.Status.OK).entity(infractions).build();
	    else
	        response = Response.status(Response.Status.NO_CONTENT).build();
	
	    return response;
	}
	
	@GET
	@Path("{idTicket}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllInfractionsByTicket(@PathParam("idTicket") int idTicket) {
		conn = DBConnection.getInstance();
	    
		ArrayList<Infraction> infractions = new InfractionDAO(conn).findAll(idTicket);
	    
		if (!infractions.isEmpty())
			response = Response.status(Response.Status.OK).entity(infractions).build();
	    else
	        response = Response.status(Response.Status.NO_CONTENT).build();
	
	    return response;
	}
	
	@POST
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findId(@FormParam("comment") String comment, @FormParam("idTicket") int idTicket,
			@FormParam("idInfractionType") int idInfractionType) {
		Ticket ticket = new Ticket();
		InfractionType type = new InfractionType();
		ticket = ticket.find(idTicket);
		type = type.find(idInfractionType);
		Infraction infraction = new Infraction (comment, ticket, type);
		
		conn = DBConnection.getInstance();

		int id = new InfractionDAO(conn).findId(infraction);

		if (id > 0)
			response = Response.status(Response.Status.OK).entity(id).build();
		else
			response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();

		return response;
	}
	
}
