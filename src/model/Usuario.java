package model;

public class Usuario {
	public static final int ADMIN = 0;
	public static final int CLIENTE = 1;
	
	private int _tipo;
	private int _id;
	
	public Usuario(int _id,int _tipo) {
		super();
		this._tipo = _tipo;
		this._id = _id;
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
	
}
