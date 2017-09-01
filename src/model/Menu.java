package model;

import java.util.ArrayList;

public class Menu {
	private int tipo_usuario;

	public Menu(int tipo_usuario) {
		super();
		this.tipo_usuario = tipo_usuario;
	}
	
	public ArrayList<ItemMenu> get_Menu(){
		ArrayList<ItemMenu> menu = new ArrayList<ItemMenu>();
		
		//Añadimos las opciones del Menu
		//Si el usuario es Admin, agregamos la opción "Clientes"
		if(tipo_usuario==Usuario.ADMIN) {
			menu.add(new ItemMenu(ItemMenu.CLIENTES,"Clientes"));
		}
		
		menu.add(new ItemMenu(ItemMenu.ARTICULOS,"Artículos"));
		menu.add(new ItemMenu(ItemMenu.LOGOUT,"Cerrar sesión"));
		
		return menu;
	}
}
