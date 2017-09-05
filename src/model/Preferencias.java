package model;

import utils.DataBase;
import utils.FieldDB;
import utils.Table;

public class Preferencias extends Table {

	@Override
	public FieldDB[] getFields() {
		FieldDB[] l = {new FieldDB(Table.PREFERENCIAS,"art","Categoría",true)};
		return l;
	}

	@Override
	public FieldDB getIdField() {
		return new FieldDB(Table.PREFERENCIAS,"user","Usuario",false);
	}
	
	public RowTable[] list(int user) {
		return convert(new DataBase().get(getFieldSql()+" from "+Table.PREFERENCIAS+" WHERE "+_fieldid.get_field()+"="+user, null));
	}

}
