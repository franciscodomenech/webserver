package utils;

import java.util.ArrayList;
import java.util.List;

import model.RowTable;

public abstract class Table implements ITable {

	public static final String USUARIO = "users";
	public static final String CLIENTES = "clientes";
	public static final String PREFERENCIAS = "preferencias";
	public static final String CATEGORIAS = "categorias";
	public static final String ARTICULOS = "articulos";
	
	protected FieldDB[] _fields;
	
	protected FieldDB _fieldid;
	
	public Table() {
		_fieldid = getIdField();
		_fields = getFields();
	}
	
	@Override
	public String[] getColumns() {
		String[] columns = new String[_fields.length];
		for(int i=0;i<_fields.length;i++) {
			FieldDB ifield = _fields[i];
			if(ifield.isVisible())
				columns[i] = ifield.get_title();
		}
		return columns;
	}
	
	protected String getFieldSql() {
		String sql = "SELECT "+_fieldid.getTable()+"."+_fieldid.get_field();
		for(int i=0;i<_fields.length;i++) {
			FieldDB field = _fields[i];
			sql+=","+field.getTable()+"."+field.get_field();
		}
		return sql;
	}
	
	protected RowTable[] convert(RowsResultSql rs) {
		List<RowResultSql> rows = rs.getRows();
		RowTable[] result = new RowTable[rows.size()];
		for(int i=0;i<rows.size();i++) {
			String[] columns = rows.get(i).getCols();
			RowTable row = new RowTable(Integer.parseInt(columns[0]));
			for(int j=1;j<columns.length;j++) {
				row.addcol(columns[j]);
			}
			result[i] = row;
		}
		return result;
	}

}
