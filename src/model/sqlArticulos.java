package model;

import java.util.ArrayList;

import utils.BindValue;
import utils.DataBase;
import utils.RowResultSql;
import utils.RowsResultSql;

public class sqlArticulos {
	public static ArrayList getArticulos(String u, int tipo) {
		ArrayList<Articulo> listado = new ArrayList<Articulo>();
		ArrayList<BindValue> bind = new ArrayList<BindValue>();
		Articulo art = null;
		RowsResultSql result;
		
		if(tipo==Usuario.ADMIN) {
			result = new DataBase().get("SELECT articulos.ref, articulos.nombre, categorias.nombre, articulos.precio FROM articulos, categorias WHERE categorias.id=articulos.tipo",bind);
		}else {
			bind.add(new BindValue(DataBase.STRING,u));
			result = new DataBase().get("SELECT articulos.ref, articulos.nombre, categorias.nombre, articulos.precio FROM users, articulos, preferencias, categorias WHERE users.user=? AND users.id=preferencias.idUsu AND preferencias.idCat=categorias.id AND categorias.id=articulos.tipo;",bind);
		}
		
		if(result!=null) {
			ArrayList<RowResultSql> rows = result.getRows();
			
			for(int i=0; i<rows.size(); i++) {
				RowResultSql row = rows.get(i);
				
				try {
					art = new Articulo(row.getString(0),row.getString(1),row.getString(2),row.getFloat(3));
					listado.add(art);
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
		
		nombres.add("Ref");
		nombres.add("Nombre");
		nombres.add("Categoria");
		nombres.add("Precio");
			
		return nombres;
	}
}
