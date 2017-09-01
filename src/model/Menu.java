package model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	
	public static List<ItemMenu> get(int tuser){
		ArrayList<ItemMenu> menu = new ArrayList<ItemMenu>();
		if(tuser==Usuario.ADMIN)
			menu.add(new ItemMenu(ItemMenu.CLIENTES,"CLIENTES"));
		menu.add(new ItemMenu(ItemMenu.ARTICULOS,"ARTICULOS"));
		menu.add(new ItemMenu(ItemMenu.LOGOUT,"LOGOUT"));
		return menu;
	}
	
}
