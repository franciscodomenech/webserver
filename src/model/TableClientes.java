package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.BindValue;
import utils.DataBase;
import utils.RowResultSql;
import utils.RowsResultSql;

public class TableClientes extends Table{
	
	public List<List<String>> get() {
		ArrayList<List<String>> tablaClientes = new ArrayList<List<String>>();
		
		RowsResultSql result = new DataBase().get("select nombre, apellidos from cliente",null);
		if(result!=null) {
			ArrayList<RowResultSql> rows = result.getRows();
			if(rows.size()>0) {
				for (RowResultSql row: rows ) {
					tablaClientes.add(getRowList(row));
				}
			}
				
		}
		return tablaClientes;
	}
	
	
	
	public ArrayList<String> getColumnsHeaders(){
		return new ArrayList<>(Arrays.asList("Nombre", "Apellidos"));
	}

	
	
	
	
	
}
