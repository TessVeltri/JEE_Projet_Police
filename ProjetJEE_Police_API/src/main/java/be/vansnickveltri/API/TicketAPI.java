package be.vansnickveltri.API;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
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
import be.vansnickveltri.DAO.PersonDAO;
import be.vansnickveltri.DAO.TicketDAO;
import be.vansnickveltri.DAO.UserDAO;
import be.vansnickveltri.MODEL.Civil;
import be.vansnickveltri.MODEL.Policeman;
import be.vansnickveltri.MODEL.Ticket;
import be.vansnickveltri.MODEL.User;
import be.vansnickveltri.MODEL.Vehicle;

@Path("/ticket")
public class TicketAPI {

	private Connection conn;
	private Response response;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTicket(@FormParam("ticketDate") Date ticketDate, @FormParam("ticketHour") String ticketHour,
			@FormParam("isValidate") boolean isValidate, @FormParam("isPayed") boolean isPayed,
			@FormParam("idVehicle") int idVehicle, @FormParam("idUser") int idUser) {
		Policeman policeman = new Policeman();
		Vehicle vehicle = new Vehicle();
		policeman = policeman.find(idUser);
		vehicle = vehicle.find(idVehicle);
		Ticket ticket = new Ticket (ticketDate, ticketHour, 0, isValidate, isPayed, policeman, vehicle);

		conn = DBConnection.getInstance();

		boolean insert = new TicketDAO(conn).create(ticket);

		if (insert)
			response = Response.status(Response.Status.CREATED).entity(true).build();
		else
			response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();

		return response;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteTicket(@FormParam("ticketDate") Date ticketDate, @FormParam("ticketHour") String ticketHour,
			@FormParam("isValidate") boolean isValidate, @FormParam("isPayed") boolean isPayed,
			@FormParam("idVehicle") int idVehicle, @FormParam("idUser") int idUser) {
		Policeman policeman = new Policeman();
		Vehicle vehicle = new Vehicle();
		policeman = policeman.find(idUser);
		vehicle = vehicle.find(idVehicle);
		Ticket ticket = new Ticket (ticketDate, ticketHour, 0, isValidate, isPayed, policeman, vehicle);

		conn = DBConnection.getInstance();

		boolean delete = new TicketDAO(conn).delete(ticket);

		if (delete)
			response = Response.status(Response.Status.ACCEPTED).entity(true).build();
		else
			response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();

		return response;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateTicket(@FormParam("ticketDate") Date ticketDate, @FormParam("ticketHour") String ticketHour,
			@FormParam("isValidate") boolean isValidate, @FormParam("isPayed") boolean isPayed,
			@FormParam("idVehicle") int idVehicle, @FormParam("idUser") int idUser) {
		Policeman policeman = new Policeman();
		Vehicle vehicle = new Vehicle();
		policeman = policeman.find(idUser);
		vehicle = vehicle.find(idVehicle);
		Ticket ticket = new Ticket (ticketDate, ticketHour, 0, isValidate, isPayed, policeman, vehicle);

		conn = DBConnection.getInstance();

		boolean update = new TicketDAO(conn).update(ticket);

		if (update)
			response = Response.status(Response.Status.OK).entity(true).build();
		else
			response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();

		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTickets() {
		conn = DBConnection.getInstance();
	    
		ArrayList<Ticket> tickets = new TicketDAO(conn).findAll();
	    
		if (!tickets.isEmpty())
			response = Response.status(Response.Status.OK).entity(tickets).build();
	    else
	        response = Response.status(Response.Status.NO_CONTENT).build();
	
	    return response;
	}
	
	@POST
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findId(@FormParam("ticketDate") Date ticketDate, @FormParam("ticketHour") String ticketHour,
			@FormParam("isValidate") boolean isValidate, @FormParam("isPayed") boolean isPayed,
			@FormParam("idVehicle") int idVehicle, @FormParam("idUser") int idUser) {
		Policeman policeman = new Policeman();
		Vehicle vehicle = new Vehicle();
		policeman = policeman.find(idUser);
		vehicle = vehicle.find(idVehicle);
		Ticket ticket = new Ticket (ticketDate, ticketHour, 0, isValidate, isPayed, policeman, vehicle);
		
		conn = DBConnection.getInstance();

		int id = new TicketDAO(conn).findId(ticket);

		if (id > 0)
			response = Response.status(Response.Status.OK).entity(id).build();
		else
			response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();

		return response;
	}
	
}
