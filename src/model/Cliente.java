package model;

import java.util.ArrayList;

public class Cliente implements ITabla {
	private int id;
	private String nombre,apellidos;
 	private String email;
	
	public Cliente(int id, String nombre, String apellidos, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return this.id + ";" + this.nombre + ";" + this.apellidos + ";" + this.email ;
	}

	@Override
	public ArrayList<String> getCampos() {
		ArrayList<String> fila = new ArrayList<String>();
		
		fila.add(Integer.toString(this.id));
		fila.add(this.nombre);
		fila.add(this.apellidos);
		fila.add(this.email);
		
		return fila;
	}
}
