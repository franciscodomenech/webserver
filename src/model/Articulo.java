package model;

import java.util.ArrayList;

public class Articulo implements ITabla {
	private String ref, nombre, categoria;
	private float precio;
	
	public Articulo(String ref, String nombre, String categoria, float precio) {
		super();
		this.ref = ref;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
	}
	
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public ArrayList<String> getCampos() {
		ArrayList<String> fila = new ArrayList<String>();
		
		
		fila.add(this.ref);
		fila.add(this.nombre);
		fila.add(this.categoria);
		fila.add(Float.toString(this.precio));
		
		return fila;
	}
}
