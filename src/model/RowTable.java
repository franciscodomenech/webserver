package model;

import java.util.ArrayList;
import java.util.List;

public class RowTable {
	private int _id;
	private ArrayList<String> _cols;
	public RowTable(int _id) {
		super();
		this._id = _id;
		this._cols = new ArrayList<String>();
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public List<String> get_cols() {
		return _cols;
	}
	
	public void addcol(String col) {
		_cols.add(col);
	}
	
}
