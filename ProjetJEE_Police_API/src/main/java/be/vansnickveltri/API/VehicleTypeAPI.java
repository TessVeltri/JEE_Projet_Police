package be.vansnickveltri.API;

import java.sql.Connection;
import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import be.vansnickveltri.DAO.DBConnection;
import be.vansnickveltri.DAO.InfractionDAO;
import be.vansnickveltri.DAO.VehicleTypeDAO;
import be.vansnickveltri.MODEL.Infraction;
import be.vansnickveltri.MODEL.InfractionType;
import be.vansnickveltri.MODEL.Ticket;
import be.vansnickveltri.MODEL.VehicleType;

@Path("/vehicleType")
public class VehicleTypeAPI {

	private Connection conn;
	private Response response;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createVehicleType(@FormParam("vehicleName") String vehicleName) {
		
		VehicleType type = new VehicleType (vehicleName);
		
		conn = DBConnection.getInstance();

		boolean insert = new VehicleTypeDAO(conn).create(type);

		if (insert)
			response = Response.status(Response.Status.CREATED).entity(true).build();
		else
			response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();

		return response;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteVehicleType(@FormParam("vehicleName") String vehicleName) {
		
		VehicleType type = new VehicleType (vehicleName);
		
		conn = DBConnection.getInstance();

		boolean delete = new VehicleTypeDAO(conn).delete(type);

		if (delete)
			response = Response.status(Response.Status.ACCEPTED).entity(true).build();
		else
			response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();

		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllVehicleTypes() {
		conn = DBConnection.getInstance();
	    
		ArrayList<VehicleType> vehicleTypes = new VehicleTypeDAO(conn).findAll();
	    
		if (!vehicleTypes.isEmpty())
			response = Response.status(Response.Status.OK).entity(vehicleTypes).build();
	    else
	        response = Response.status(Response.Status.NO_CONTENT).build();
	
	    return response;
	}
	
	@POST
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findId(@FormParam("vehicleName") String vehicleName) {
		
		VehicleType type = new VehicleType (vehicleName);
		
		conn = DBConnection.getInstance();

		int id = new VehicleTypeDAO(conn).findId(type);

		if (id > 0)
			response = Response.status(Response.Status.OK).entity(id).build();
		else
			response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();

		return response;
	}
	
}
