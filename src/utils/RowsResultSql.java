package utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;

public class RowsResultSql {
	private ArrayList<RowResultSql> _rows;
	private int _ncolumns;
	public RowsResultSql(ResultSet rs) throws SQLException {
		_rows = new ArrayList<RowResultSql>();
		ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
		_ncolumns = rsmd.getColumnCount();
		while(rs.next()) {
			RowResultSql row = new RowResultSql(_ncolumns);
			for(int i=0;i<_ncolumns;i++)
				row.addCol(i, rs.getString(i+1));
			_rows.add(row);
		}
		rs.close();
	}
	
	public ArrayList<RowResultSql> getRows(){
		return _rows;
	}
	
	public String[][] tomatrix(){
		String[][] matrix = new String[_rows.size()][_ncolumns];
		for(int i=0;i<_rows.size();i++) {
			matrix[i] = _rows.get(i).getCols();
		}
		return matrix;
	}
}
