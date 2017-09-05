package utils;

public class RowResultSql {
	private String[] _cols;
	
	public RowResultSql(int nc) {
		_cols = new String[nc];
	}
	
	public void addCol(int p,String v) {
		if(p<_cols.length && p>-1)
			_cols[p] = v;
	}
	
	public String getString(int p) {
		String r = null;
		if(p<_cols.length && p>-1)
			r = _cols[p];
		return r;
	}
	
	public int getInt(int p) throws Exception {
		return Integer.parseInt(_cols[p]);
	}
	
	public float getFloat(int p) throws Exception {
		return Float.parseFloat(_cols[p]);
	}
	
	public String[] getCols() {
		return _cols;
	}
	
}
