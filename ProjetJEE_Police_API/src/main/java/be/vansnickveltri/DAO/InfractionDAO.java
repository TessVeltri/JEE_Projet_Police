package be.vansnickveltri.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

import be.vansnickveltri.MODEL.Infraction;
import be.vansnickveltri.MODEL.InfractionType;
import be.vansnickveltri.MODEL.Ticket;

public class InfractionDAO extends DAO<Infraction> {

	public InfractionDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Infraction obj) {
		try {
			Infraction i = new Infraction();
			i = i.find(obj.findId());
			if (i == null) {
				this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("INSERT INTO JEE_Infraction (infractionComment, idTicket, idInfractiontType) "
							+ "Values('" + obj.getComment() + "','" + obj.getTicket().findId() + "','"
							+ obj.getInfractionType().findId() + "')");
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
	public boolean delete(Infraction obj) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate("DELETE FROM JEE_Infraction WHERE idInfraction = '" + obj.findId() + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Infraction obj) {
		try {
			this.connect.createStatement().executeUpdate("UPDATE JEE_Infraction SET infractionComment = '"
					+ obj.getComment() + "' WHERE idInfraction = '" + obj.findId() + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int findId(Infraction obj) {
		int id = 0;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT idInfraction FROM JEE_Infraction WHERE idTicket = '" + obj.getTicket().findId()
									+ "' AND idInfractiontType = '" + obj.getInfractionType().findId() + "'");
			if (result.first()) {
				id = result.getInt(1);
			}
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public Infraction find(String str1, String str2) {
		return null;
	}

	@Override
	public Infraction find(int i) {
		Infraction infraction = null;
		Ticket ticket = new Ticket();
		InfractionType type = new InfractionType();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT infractionComment, idTicket, idInfractiontType FROM JEE_Infraction WHERE idInfraction = "
									+ i);
			if (result.first()) {
				ticket = ticket.find(result.getInt("idTicket"));
				type = type.find(result.getInt("idInfractiontType"));
				infraction = new Infraction(result.getString("infractionComment"), ticket, type);
			}
			return infraction;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Infraction> findAll() {
		ArrayList<Infraction> lst_infractions = new ArrayList<>();
		Ticket ticket = new Ticket();
		InfractionType type = new InfractionType();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT infractionComment, idTicket, idInfractiontType FROM JEE_Infraction ORDER BY idInfraction");
			while (result.next()) {
				ticket = ticket.find(result.getInt("idTicket"));
				type = type.find(result.getInt("idInfractiontType"));
				Infraction infraction = new Infraction(result.getString("infractionComment"), ticket, type);
				lst_infractions.add(infraction);
			}
			result.close();
			return lst_infractions;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Infraction> findAll(int i) {
		ArrayList<Infraction> lst_infractions = new ArrayList<>();
		Ticket ticket = new Ticket();
		ticket = ticket.find(i);
		InfractionType type = new InfractionType();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT infractionComment, idTicket, idInfractiontType FROM JEE_Infraction WHERE idTicket = "
									+ i + " ORDER BY idInfraction");
			while (result.next()) {
				type = type.find(result.getInt("idInfractiontType"));
				Infraction infraction = new Infraction(result.getString("infractionComment"), ticket, type);
				lst_infractions.add(infraction);
			}
			return lst_infractions;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
