package be.vansnickveltri.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import be.vansnickveltri.MODEL.Infraction;
import be.vansnickveltri.MODEL.InfractionType;
import be.vansnickveltri.MODEL.Policeman;
import be.vansnickveltri.MODEL.Ticket;
import be.vansnickveltri.MODEL.User;
import be.vansnickveltri.MODEL.Vehicle;

public class TicketDAO extends DAO<Ticket> {

	public TicketDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Ticket obj) {
		String validate;
		String payed;
		if (obj.isValidate())
			validate = "Y";
		else
			validate = "N";
		if (obj.isPayed())
			payed = "Y";
		else
			payed = "N";
		try {
			Ticket t = null;
			t = t.find(obj.findId());
			if (t == null) {
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				String myDate = format.format(obj.getDate());
				
				this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
						.executeUpdate("INSERT INTO JEE_Ticket (ticketDate, isValidate, isPayed, idVehicle, idUser, ticketHour) "
								+ "Values('" + myDate + "','" + validate + "','" + payed + "','" + obj.getVehicle().findId() + "','"
								+ obj.getPoliceman().findId() + "','" + obj.getHour() + "')");
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Ticket obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("DELETE FROM JEE_Ticket WHERE idTicket = '" + obj.findId() + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Ticket obj) {
		String validate;
		String payed;
		if (obj.isValidate())
			validate = "Y";
		else
			validate = "N";
		if (obj.isPayed())
			payed = "Y";
		else
			payed = "N";
		try {
			this.connect.createStatement().executeUpdate(
					"UPDATE JEE_Ticket SET isValidate = '" + validate + "', isPayed = '" + payed + "' WHERE idTicket = '" + obj.findId() + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// TODO Vérif si la date passe bien
	@Override
	public int findId(Ticket obj) {
		int id = 0;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String myDate = format.format(obj.getDate());
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT idTicket FROM JEE_Ticket WHERE ticketDate = '" + myDate
							+ "' AND idVehicle = '" + obj.getVehicle().findId() + "'");
			if (result.first()) {
				id = result.getInt(1);
			}
			result.close();
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public Ticket find(String str1, String str2) {
		return null;
	}

	@Override
	public Ticket find(int i) {
		Ticket ticket = null;
		boolean validate;
		boolean payed;
		Vehicle vehicle = new Vehicle();
		Policeman policeman = new Policeman ();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT ticketDate, ticketHour, isValidate, isPayed, idVehicle, idUser FROM JEE_Ticket WHERE idTicket = "
									+ i);
			if (result.first()) {
				if (result.getString("isValidate").equals("Y")) 
					validate = true;
				else 
					validate = false;
				if (result.getString("isPayed").equals("Y")) 
					payed = true;
				else 
					payed = false;
				vehicle = vehicle.find(result.getInt("idVehicle"));
				policeman = policeman.find(result.getInt("idUser"));
				ticket = new Ticket(result.getDate("ticketDate"), result.getString("ticketHour"), 0, validate, payed, policeman, vehicle);
				/*ArrayList<Infraction> lst_infractions = new ArrayList<Infraction>();
				lst_infractions = new Infraction().findAll(ticket.findId());
				ticket.setLst_infraction(lst_infractions);
				ticket.calculate();*/
				result.close();
			}
			
			return ticket;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Ticket> findAll() {
		ArrayList<Ticket> lst_ticket = new ArrayList<>();
		boolean payed;
		Vehicle vehicle = new Vehicle();
		Policeman policeman = new Policeman ();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT ticketDate, ticketHour, isValidate, isPayed, idVehicle, idUser FROM JEE_Ticket "
							+ "WHERE isValidate = 'N' ORDER BY idTicket");
			while (result.next()) {
				if (result.getString("isPayed").equals("Y")) 
					payed = true;
				else 
					payed = false;
				vehicle = vehicle.find(result.getInt("idVehicle"));
				policeman = policeman.find(result.getInt("idUser"));
				Ticket ticket = new Ticket(result.getDate("ticketDate"), result.getString("ticketHour"), 0, false, payed, policeman, vehicle);
				/*ArrayList<Infraction> lst_infractions = new ArrayList<Infraction>();
				lst_infractions = new Infraction().findAll(ticket.findId());
				ticket.setLst_infraction(lst_infractions);
				ticket.calculate();*/
				lst_ticket.add(ticket);
			}
			
			for(Ticket ticket : lst_ticket) {
				ticket.findTotalAmount();
				ticket.initLstInfcations();
			}
			return lst_ticket;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Ticket> findAll(int i) {
		return null;
	}

}
