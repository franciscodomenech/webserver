package model;

public class MenuItem {
	private String nombreItem;	
	private int opcion;

	public MenuItem(String nombreItem, int opcion) {
		this.setNombreItem(nombreItem);
		this.setOpcion(opcion);
	}
	

	
	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}

	public String getNombreItem() {
		return nombreItem;
	}

	public void setNombreItem(String nombreItem) {
		this.nombreItem = nombreItem;
	}
	
}
