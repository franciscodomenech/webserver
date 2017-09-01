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
			//System.out.println(ItemMenu.CLIENTES);
			menu.add(new ItemMenu(ItemMenu.ARTICULOS,"ARTICULOS"));
			//System.out.println(ItemMenu.ARTICULOS);
			menu.add(new ItemMenu(ItemMenu.LOGOUT,"LOGOUT"));
			//System.out.println(ItemMenu.LOGOUT);
			
		}else {
			
			menu.add(new ItemMenu(ItemMenu.ARTICULOS,"ARTICULOS"));
			menu.add(new ItemMenu(ItemMenu.LOGOUT,"LOGOUT"));
			
		}
		
		return menu;
		
		
	}

}
