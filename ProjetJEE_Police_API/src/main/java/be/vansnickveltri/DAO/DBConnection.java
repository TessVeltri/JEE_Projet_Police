package be.vansnickveltri.DAO;

import java.sql.*;

public class DBConnection {
	
	private static Connection conn = null;

	public static void setConnection(Connection conn) {
		DBConnection.conn = conn;
	}
	private String userName = "STUDENT03_20";
	private String password = "condorcet20";
	
	private String ip = "193.190.64.10";
	private String port = "1522";
	private String serviceName = "XEPDB1";
	private String chaineConnexion = "jdbc:oracle:thin:@//"+ip+":"+port+"/"+serviceName;
	
	private DBConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(chaineConnexion, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getInstance() {
		if (conn == null)
            new DBConnection();
		return conn;
	}
	
}
