package model;

import java.util.ArrayList;

import utils.BindValue;
import utils.DataBase;
import utils.RowResultSql;
import utils.RowsResultSql;

public class sqlClientes {
	public static ArrayList getClientes() {
		ArrayList<BindValue> bind = new ArrayList<BindValue>();
		ArrayList<Cliente> listado = new ArrayList<Cliente>();
		Cliente cli = null;

		RowsResultSql result = new DataBase().get("SELECT * FROM clientes",bind);
		if(result!=null) {
			ArrayList<RowResultSql> rows = result.getRows();
			
			for(int i=0; i<rows.size(); i++) {
				RowResultSql row = rows.get(i);
				
				try {
					cli = new Cliente(row.getInt(0), row.getString(1), row.getString(2), row.getString(3));
					listado.add(cli);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return listado;
	}
	
	
	public static ArrayList<String> getNomCols() {
			ArrayList<String> nombres = new ArrayList<String>();
			nombres.add("Id");
			nombres.add("Nombre");
			nombres.add("Apellidos");
			nombres.add("Email");
			return nombres;
	}
}
