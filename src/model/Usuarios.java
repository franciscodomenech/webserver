package model;

public class Usuarios {
	
	public static Usuario login(String u,String p) {
		if(u!=null && u.equals("a"))
			return new Usuario(0, 1);
		else
			return null;
	}
	
}
