package model;

import java.util.ArrayList;

public interface ITable {
	public ArrayList<Cliente> get();
	public ArrayList<String> getColumnsHeaders();
	public Table filter();
	public Table orderBy(int numColumn);

}
