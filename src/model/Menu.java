package model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	
	public static List<ItemMenu> get(int tuser){
		ArrayList<ItemMenu> menu = new ArrayList<ItemMenu>();
		if(tuser==Usuario.ADMIN) {
			menu.add(new ItemMenu(ItemMenu.CLIENTES,"Clientes"));
		}
		menu.add(new ItemMenu(ItemMenu.ARTICULOS,"Art�culos"));
		menu.add(new ItemMenu(ItemMenu.LOGOUT,"Cerrar sesi�n"));
		return menu;
	}
	
}
