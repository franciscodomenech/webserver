package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.BindValue;
import utils.DataBase;
import utils.RowResultSql;
import utils.RowsResultSql;

public class Usuarios {
	
	public static Usuario login(String u,String p) {
		Usuario user = null;
		ArrayList<BindValue> bind = new ArrayList<BindValue>();
		bind.add(new BindValue(DataBase.STRING,u));
		bind.add(new BindValue(DataBase.STRING,p));
		RowsResultSql result = new DataBase().get("select id,tipo from users where user=? and pass=? limit 1",bind);
		if(result!=null) {
			ArrayList<RowResultSql> rows = result.getRows();
			if(rows.size()>0) {
				RowResultSql row = rows.get(0);
				try {
					user = new Usuario(row.getInt(0),row.getInt(1));
				} catch (Exception e) {
				}
			}
				
		}
		return user;
	}
	
}
