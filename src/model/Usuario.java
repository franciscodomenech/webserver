package model;

import java.util.ArrayList;

public class Usuario implements ITabla{
	
	public static final int ADMIN = 0;
	public static final int CLIENTE = 1;
	
	private int _tipo;
	private int _id;
	private String _userName;
	
	public Usuario(int _id,int _tipo, String _user) {
		super();
		this._tipo = _tipo;
		this._id = _id;
		this._userName = _user;
	}
	public int get_tipo() {
		return _tipo;
	}
	public void set_tipo(int _tipo) {
		this._tipo = _tipo;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	
	@Override
	public ArrayList<String> getCampos() {
		ArrayList<String> fila = new ArrayList<String>();
		
		fila.add(Integer.toString(_id));
		fila.add(Integer.toString(_tipo));
		
		return fila;
	}
}
