package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.BindValue;
import utils.DataBase;
import utils.RowResultSql;
import utils.RowsResultSql;

public class Usuarios {
	
	public static Usuario login(String u,String p){
		
		Usuario user = null;
		ArrayList<BindValue> bind = new ArrayList<BindValue>();
		bind.add(new BindValue(DataBase.STRING,u));
		bind.add(new BindValue(DataBase.STRING,p));
		System.out.println(u);
		System.out.println(p);
		RowsResultSql result = new DataBase().get("select id,tipo from usuarios where mail=? and pass=? limit 1",bind);
		System.out.println(result.toString());
		if(result!=null) {
			ArrayList<RowResultSql> rows = result.getRows();
			if(rows.size()>0) {
				RowResultSql row = rows.get(0);
				try {
					user = new Usuario(row.getInt(0),row.getInt(1));
				} catch (Exception e) {
					e.getStackTrace();
				}
			}
				
		}
		return user;
	}
	
	public static ArrayList<Usuario> listUsuarios() {
		Usuario usuario=null;
		ArrayList<Usuario> usuarios = new ArrayList<>();
		ArrayList<BindValue> bind = new ArrayList<BindValue>();
		bind.add(new BindValue(DataBase.STRING, null));
		RowsResultSql result = new DataBase()
				.get("SELECT * FROM usuarios;", bind);
		if (result != null) {
			ArrayList<RowResultSql> rows = result.getRows();
			if (rows.size() > 0) {
				for (RowResultSql row : rows) {
					try {
						usuario = new Usuario(row.getInt(0),row.getInt(1));
						usuarios.add(usuario);
					} catch (Exception e) {
					}
				}
			}
		}
		return usuarios;
	}
	
	public static ArrayList<String> listColumnasFromUsuarios() {
		ArrayList<String> nomCols = new ArrayList<>();
		RowsResultSql result = new DataBase()
				.get("SHOW COLUMNS FROM usuarios;", null);
		if (result != null) {
			ArrayList<RowResultSql> rows = result.getRows();
			if (rows.size() > 0) {
				for (RowResultSql row : rows) {
					try {
						nomCols.add(row.getString(0));
					} catch (Exception e) {
					}
				}
			}
		}
		return nomCols;
	}
	
}
