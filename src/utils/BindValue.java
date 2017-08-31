package utils;

public class BindValue{
	private int _type;
	private String _val;
	public BindValue(int t,String v) {
		_type = t;
		_val = v;
	}
	public int getType(){
		return _type;
	}
	public String getValue() {
		return _val;
	}
}
