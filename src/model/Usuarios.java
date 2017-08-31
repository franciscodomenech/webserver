package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.BindValue;
import utils.DataBase;

public class Usuarios {
	
	public static Usuario login(String u,String p) {
		Usuario user = null;
		ArrayList<BindValue> bind = new ArrayList<BindValue>();
		bind.add(new BindValue(DataBase.STRING,u));
		bind.add(new BindValue(DataBase.STRING,p));
		try {
			ResultSet result = new DataBase().get("select id,tipo from users where user=? and pass=? limit 1",bind);
			if(result!=null && result.next()) {
				user = new Usuario(result.getInt(0),result.getInt(1));
			}
		} catch (SQLException e) {
		}
		return user;
	}
	
}
