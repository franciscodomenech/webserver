package model;

import java.util.Arrays;

import utils.DataBase;
import utils.FieldDB;
import utils.Table;

public class Articulos extends Table {

	@Override
	public FieldDB[] getFields() {
		FieldDB[] l = {
			new FieldDB(Table.CATEGORIAS,"nombre","Categoría",true),
			new FieldDB(Table.ARTICULOS,"nombre","nombre",true),
			new FieldDB(Table.ARTICULOS,"ref","Referencia",true),
			new FieldDB(Table.ARTICULOS,"precio","Precio",true)
		};
		return l;
	}

	@Override
	public FieldDB getIdField() {
		return new FieldDB(Table.ARTICULOS,"id","id",false);
	}
	
	public RowTable[] listAll() {
		return filterCats(null);
	}
	
	public RowTable[] filterCats(int[] cats) {
		FieldDB fieldcat = _fields[0];
		String where = "";
		String fieldcatstr = Table.ARTICULOS+".cat";
		if(cats!=null) {
			where = " WHERE "+fieldcatstr+" IN ("+Arrays.toString(cats).replaceAll("\\[|\\]|,|\\s", "")+")";
		}
		return convert(new DataBase().get(getFieldSql()+" from "+Table.ARTICULOS+" inner join "+Table.CATEGORIAS+" on "+Table.CATEGORIAS+".ic="+fieldcatstr+where, null));
	}
	

}
