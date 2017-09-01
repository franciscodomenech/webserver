package model;

import java.util.ArrayList;

public class Menu {
	
	protected Usuario user=null;
	
	
	public Menu(Usuario user) {
		
		
		this.user=user;
		
	}
	
	public ArrayList<ItemMenu> createMenu() {
		
		int tipo =user.get_tipo();
		
		ArrayList<ItemMenu> menu = new ArrayList<ItemMenu>();
		
		if(tipo==Usuario.ADMIN) {
			menu.add(new ItemMenu(ItemMenu.CLIENTES,"CLIENTES"));
			menu.add(new ItemMenu(ItemMenu.ARTICULOS,"ARTICULOS"));
			menu.add(new ItemMenu(ItemMenu.LOGOUT,"LOGOUT"));
			
		}else {
			
			menu.add(new ItemMenu(ItemMenu.ARTICULOS,"ARTICULOS"));
			menu.add(new ItemMenu(ItemMenu.LOGOUT,"LOGOUT"));
			
		}
		
		return menu;
		
		
	}

}
