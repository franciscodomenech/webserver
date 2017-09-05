package model;

import utils.DataBase;
import utils.FieldDB;
import utils.Table;

public class Clientes extends Table {

	@Override
	public FieldDB[] getFields() {
		FieldDB[] l = {
			new FieldDB(Table.CLIENTES,"nombre","Nombre",true),
			new FieldDB(Table.CLIENTES,"apellidos","Apellidos",true),
			new FieldDB(Table.CLIENTES,"direccion","Dirección",true)};	
		return l;
	}

	@Override
	public FieldDB getIdField() {
		return new FieldDB(Table.CLIENTES,"id","id",false);
	}
	
	public RowTable[] list() {
		return convert(new DataBase().get(getFieldSql()+" from "+Table.CLIENTES, null));
	}

}
