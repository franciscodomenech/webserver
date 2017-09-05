package utils;

public class FieldDB {
	private String _tabledb;
	private String _field;
	private String _title;
	private boolean _visible;
	public FieldDB(String tb,String _field, String _title,boolean visible) {
		super();
		_tabledb = tb;
		this._field = _field;
		this._title = _title;
		this._visible = visible;
	}
	
	public String get_field() {
		return _field;
	}
	public void set_field(String _field) {
		this._field = _field;
	}
	public String get_title() {
		return _title;
	}
	public void set_title(String _title) {
		this._title = _title;
	}
	
	public boolean isVisible() {
		return _visible;
	}
	
	public String getTable() {
		return _tabledb;
	}
	
}
