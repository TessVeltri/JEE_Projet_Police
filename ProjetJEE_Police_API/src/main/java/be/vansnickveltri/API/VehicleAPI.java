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
import be.vansnickveltri.DAO.PersonDAO;
import be.vansnickveltri.DAO.VehicleDAO;
import be.vansnickveltri.MODEL.Civil;
import be.vansnickveltri.MODEL.Infraction;
import be.vansnickveltri.MODEL.InfractionType;
import be.vansnickveltri.MODEL.Person;
import be.vansnickveltri.MODEL.Ticket;
import be.vansnickveltri.MODEL.Vehicle;
import be.vansnickveltri.MODEL.VehicleType;

@Path("/vehicle")
public class VehicleAPI {
	
	private Connection conn;
	private Response response;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createVehicle(@FormParam("plateNumberVehicle") String plateNumberVehicle, @FormParam("isInsurance") boolean isInsurance,
			@FormParam("idCivil") int idCivil, @FormParam("idVehicleType") int idVehicleType) {
		Person civil = new Civil();
		VehicleType type = new VehicleType();
		civil = civil.find(idCivil);
		type = type.find(idVehicleType);
		
		Vehicle vehicle = new Vehicle (plateNumberVehicle, isInsurance, (Civil)civil, type);
		
		conn = DBConnection.getInstance();

		boolean insert = new VehicleDAO(conn).create(vehicle);

		if (insert)
			response = Response.status(Response.Status.CREATED).entity(true).build();
		else
			response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();

		return response;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteVehicle(@FormParam("plateNumberVehicle") String plateNumberVehicle, @FormParam("isInsurance") boolean isInsurance,
			@FormParam("idCivil") int idCivil, @FormParam("idVehicleType") int idVehicleType) {
		Person civil = new Civil();
		VehicleType type = new VehicleType();
		civil = civil.find(idCivil);
		type = type.find(idVehicleType);
		
		Vehicle vehicle = new Vehicle (plateNumberVehicle, isInsurance, (Civil)civil, type);
		
		conn = DBConnection.getInstance();

		boolean delete = new VehicleDAO(conn).delete(vehicle);

		if (delete)
			response = Response.status(Response.Status.ACCEPTED).entity(true).build();
		else
			response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();

		return response;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateVehicle(@FormParam("plateNumberVehicle") String plateNumberVehicle, @FormParam("isInsurance") boolean isInsurance,
			@FormParam("idCivil") int idCivil, @FormParam("idVehicleType") int idVehicleType) {
		Person civil = new Civil();
		VehicleType type = new VehicleType();
		civil = civil.find(idCivil);
		type = type.find(idVehicleType);
		
		Vehicle vehicle = new Vehicle (plateNumberVehicle, isInsurance, (Civil)civil, type);
		
		conn = DBConnection.getInstance();

		boolean update = new VehicleDAO(conn).update(vehicle);

		if (update)
			response = Response.status(Response.Status.OK).entity(true).build();
		else
			response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();

		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllVehicles() {
		conn = DBConnection.getInstance();
	    
		ArrayList<Vehicle> vehicles = new VehicleDAO(conn).findAll();
	    
		if (!vehicles.isEmpty())
			response = Response.status(Response.Status.OK).entity(vehicles).build();
	    else
	        response = Response.status(Response.Status.NO_CONTENT).build();
	
	    return response;
	}
	
	@GET
	@Path("{idCivil}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllVehiclesByCivil(@PathParam("idCivil") int idCivil) {
		conn = DBConnection.getInstance();
	    
		ArrayList<Vehicle> vehicles = new VehicleDAO(conn).findAll(idCivil);
	    
		if (!vehicles.isEmpty())
			response = Response.status(Response.Status.OK).entity(vehicles).build();
	    else
	        response = Response.status(Response.Status.NO_CONTENT).build();
	
	    return response;
	}
	
	@POST
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findId(@FormParam("plateNumberVehicle") String plateNumberVehicle, @FormParam("isInsurance") boolean isInsurance,
			@FormParam("idCivil") int idCivil, @FormParam("idVehicleType") int idVehicleType) {
		Person civil = new Civil();
		VehicleType type = new VehicleType();
		civil = civil.find(idCivil);
		type = type.find(idVehicleType);
		
		Vehicle vehicle = new Vehicle (plateNumberVehicle, isInsurance, (Civil)civil, type);
		
		conn = DBConnection.getInstance();

		int id = new VehicleDAO(conn).findId(vehicle);

		if (id > 0)
			response = Response.status(Response.Status.OK).entity(id).build();
		else
			response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();

		return response;
	}
	
}
