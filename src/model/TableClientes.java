package model;

import java.util.ArrayList;
import java.util.Arrays;

import utils.BindValue;
import utils.DataBase;
import utils.RowResultSql;
import utils.RowsResultSql;

public class TableClientes extends Table{
	
	public ArrayList<Cliente> get() {
		ArrayList<Cliente> tablaClientes = new ArrayList<Cliente>();
		RowsResultSql result = new DataBase().get("select nombre, apellidos from cliente",null);
		if(result!=null) {
			ArrayList<RowResultSql> rows = result.getRows();
			if(rows.size()>0) {
				for (RowResultSql row: rows ) {
					try {
						tablaClientes.add(new Cliente(row.getString(0),row.getString(1)));
						
					} catch (Exception e) {
						
					}
				}
			}
				
		}
		return tablaClientes;
	}
	
	public ArrayList<String> getColumnsHeaders(){
		return new ArrayList<>(Arrays.asList("Nombre", "Apellidos"));
	}
	
	
	
	
	
}
