package utils;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DataBase {
	
	public final static int INTEGER = 0;
	public final static int STRING = 1;
	public final static int FLOAT = 2;
	
	private final static String URL = "jdbc:mysql://localhost:3306/portal";
	private final static String USER = "root";
	private final static String PASS = "test1234";
	
	private static Connection conn;
	
	private void init() {
		if(conn==null) {
			try {
				conn = (Connection) DriverManager.getConnection(URL, USER, PASS);
			} catch (SQLException e) {
			    throw new IllegalStateException("Cannot connect the database!", e);
			}
		}
	}
	
	private void close() throws SQLException {
		if(conn!=null) {
			conn.close();
			conn = null;
		}
	}
	
	public ResultSet get(String sql,List<BindValue> bind) throws SQLException {
		PreparedStatement prep = preparaquery(sql,bind);
		ResultSet result = prep.executeQuery();
		prep.close();
		close();
		return result;
	}
	
	public int update(String sql,List<BindValue> bind) throws SQLException {
		PreparedStatement prep = preparaquery(sql,bind);
		int result = prep.executeUpdate();
		prep.close();
		close();
		return result;
	}
	
	private PreparedStatement preparaquery(String sql,List<BindValue> bind) throws SQLException {
		init();
		PreparedStatement prep = (PreparedStatement) conn.prepareStatement(sql);
		for(int i=0;i<bind.size();i++) {
			BindValue val = bind.get(i);
			switch(val.getType()) {
				case INTEGER:
					prep.setInt(i,Integer.parseInt(val.getValue()));
					break;
				case STRING:
					prep.setString(i,val.getValue());
					break;
				case FLOAT:
					prep.setFloat(i,Float.parseFloat(val.getValue()));
					break;
			}
		}
		return prep;
	}
	
	
	public interface BindValue{
		public int getType();
		public String getValue();
	}
	
}
