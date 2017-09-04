package model;

import java.util.ArrayList;
import java.util.List;

import utils.RowResultSql;

public abstract class Table implements ITable {

	protected List<String> getRowList(RowResultSql row){
		ArrayList<String> rowTableClientes= new ArrayList<String>();
		try {
										
			for (int i=0; i<row.getNcols(); i++) {
				rowTableClientes.add(row.getString(i));
			}
			
		} catch (Exception e) {
			
		}
		return rowTableClientes;
	}

}
