package model;

import java.util.ArrayList;
import java.util.List;

public interface ITable {
	public List<List<String>> get();
	public ArrayList<String> getColumnsHeaders();
//	public Table filter();
//	public Table orderBy(int numColumn);

}
