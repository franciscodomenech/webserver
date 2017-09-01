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
		
		//A�adimos las opciones del Menu
		//Si el usuario es Admin, agregamos la opci�n "Clientes"
		if(tipo_usuario==Usuario.ADMIN) {
			menu.add(new ItemMenu(ItemMenu.CLIENTES,"Clientes"));
		}
		
		menu.add(new ItemMenu(ItemMenu.ARTICULOS,"Art�culos"));
		menu.add(new ItemMenu(ItemMenu.LOGOUT,"Cerrar sesi�n"));
		
		return menu;
	}
}
