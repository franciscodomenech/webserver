package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	public static final int ADMIN = 0;
	public static final int CLIENTE = 1;

	private int _id;
	private String _nom;
	private String _ape;
	private String _mail;
	private int _tipo;
	String _pass;

	public Usuario(int _id, int _tipo) {
		super();
		this._tipo = _tipo;
		this._id = _id;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_nom() {
		return _nom;
	}

	public void set_nom(String _nom) {
		this._nom = _nom;
	}

	public String get_ape() {
		return _ape;
	}

	public void set_ape(String _ape) {
		this._ape = _ape;
	}

	public String get_mail() {
		return _mail;
	}

	public void set_mail(String _mail) {
		this._mail = _mail;
	}

	public int get_tipo() {
		return _tipo;
	}

	public void set_tipo(int _tipo) {
		this._tipo = _tipo;
	}

	@Override
	public String toString() {
		return "Usuario [_id=" + _id + ", _nom=" + _nom + ", _ape=" + _ape + ", _mail=" + _mail + ", _tipo=" + _tipo
				+ ", _pass=" + _pass + "]";
	}

	public List<String> convertString(){
		List<String> usuario=new ArrayList();
		usuario.add(String.valueOf(_id));
		usuario.add(String.valueOf(_nom));
		usuario.add(String.valueOf(_ape));
		usuario.add(String.valueOf(_mail));
		usuario.add(String.valueOf(_tipo));
		usuario.add(String.valueOf(_pass));
		return usuario;
	}
}
