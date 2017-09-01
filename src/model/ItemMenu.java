package model;

public class ItemMenu {
	//Elementos del Menú
	public static final int CLIENTES=0;
	public static final int ARTICULOS=1;
	public static final int LOGOUT=2;
	
	
	//Propiedades de los elementos
	private int op;
	private String name;
	
	//Constructor
	public ItemMenu(int op, String name) {
		super();
		this.op = op;
		this.name = name;
	}
	
	//Getters & Setters
	public int getOp() {
		return op;
	}
	public void setOp(int op) {
		this.op = op;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
