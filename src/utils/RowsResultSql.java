package utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;

public class RowsResultSql {
	private ArrayList<RowResultSql> _rows;
	public RowsResultSql(ResultSet rs) throws SQLException {
		_rows = new ArrayList<RowResultSql>();
		ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
		int cn = rsmd.getColumnCount();
		while(rs.next()) {
			RowResultSql row = new RowResultSql(cn);
			for(int i=0;i<cn;i++)
				row.addCol(i, rs.getString(i+1));
		}
		rs.close();
	}
	
	public ArrayList<RowResultSql> getRows(){
		return _rows;
	}
	
}
