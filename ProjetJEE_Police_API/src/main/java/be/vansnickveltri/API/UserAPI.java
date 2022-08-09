package be.vansnickveltri.API;

import java.sql.Connection;
import be.vansnickveltri.DAO.DBConnection;
import be.vansnickveltri.DAO.PolicemanDAO;
import be.vansnickveltri.DAO.UserDAO;
import be.vansnickveltri.MODEL.Admin;
import be.vansnickveltri.MODEL.FineCollector;
import be.vansnickveltri.MODEL.HeadOfBrigade;
import be.vansnickveltri.MODEL.Policeman;
import be.vansnickveltri.MODEL.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserAPI {
	
	private Connection conn;
	private Response response;
	
	@GET
	@Path("{matricule}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response logIn (@PathParam("matricule") String matricule, @PathParam("password") String password) {
		conn = DBConnection.getInstance();
        
		User user = new UserDAO(conn).find(matricule, password);

        if (user != null)
    		response = Response.status(Response.Status.OK).entity(user).build();
        else
            response = Response.status(Response.Status.NO_CONTENT).build();

        return response;
	}
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
	public Response createUser (
			@FormParam("name") String name, 
			@FormParam("firstname") String firstname,
			@FormParam("email") String email,
			@FormParam("matricule") String matricule,
			@FormParam("password") String password,
			@FormParam("typeUser") String typeUser,
			@FormParam("idHeadOfBrigade") int idHeadOfBrigade
			) {
		User user = null;
		HeadOfBrigade head = new HeadOfBrigade();
		head = head.find(idHeadOfBrigade);
		switch (typeUser) {
		case "Head of brigade":
			user = new HeadOfBrigade(name, firstname, email, matricule, password, typeUser);
			break;
		case "Policeman":
			user = new Policeman(name, firstname, email, matricule, password, typeUser, head);
			break;
		case "Fine collector":
			user = new FineCollector(name, firstname, email, matricule, password, typeUser);
			break;
		case "Admin":
			user = new Admin(name, firstname, email, matricule, password, typeUser);
			break;
		}
		
		conn = DBConnection.getInstance();
		
		boolean insert = false;
		if (typeUser.equals("Policeman")) {
			insert = new PolicemanDAO(conn).create((Policeman)user);
		} else {
			insert = new UserDAO(conn).create(user);
		}
		
		
		if (insert)
            response = Response.status(Response.Status.CREATED).entity(true).build();
        else
        	response = Response.status(Response.Status.BAD_REQUEST).entity(false).build();
		
		return response;
		
	}
}
