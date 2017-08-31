package utils;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DataBase {
	private final static String URL = "jdbc:mysql://localhost:3306/portal";
	private final static String USER = "root";
	private final static String PASS = "test1234";
	
	private static Connection conn;
	
	public static Connection getConnector() {
		if(conn==null) {
			try {
				conn = (Connection) DriverManager.getConnection(URL, USER, PASS);
			} catch (SQLException e) {
			    throw new IllegalStateException("Cannot connect the database!", e);
			}
		}
		return conn;
	}
	
	public static ResultSet get(String query) throws SQLException {
		Statement stmt = (Statement) conn.createStatement();
		ResultSet result = stmt.executeQuery(query);
		stmt.close();
		return result;
	}
	
	public static void update(String query) throws SQLException {
		Statement stmt = (Statement) conn.createStatement();
		stmt.execute(query);
		stmt.close();
	}
	
	public static void close() throws SQLException {
		if(conn!=null) {
			conn.close();
			conn = null;
		}
	}
	
}
