package me.didi.coinApi.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {

	public static String username;
	public static String password;
	public static String port;
	public static String database;
	public static String host;
	public static Connection con;

	public static boolean isConnected() {
		return con != null;
	}

	public static void connect() {
		if (!isConnected()) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username,
						password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void disconnect() {
		if (isConnected()) {
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	/**return the value*/
	public static String getValue(String where) {
		String returnValue = "";
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM coins WHERE UUID = '" + where + "'");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				returnValue = rs.getString("COINS");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return returnValue;
	}

	public static void setValue(String value, String whereValue) {
		try {
			con.createStatement()
					.executeUpdate("UPDATE coins SET COINS ='" + value + "' WHERE UUID = '" + whereValue + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
