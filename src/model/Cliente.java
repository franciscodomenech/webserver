package model;

public class Cliente extends Usuario {

	private int[] _prefs;
	
	public Cliente(int _id, int _tipo) {
		super(_id, _tipo);
		loadPreferences();
	}
	
	private void loadPreferences() {
		RowTable[] prefs = new Preferencias().list(_id);
		_prefs = new int[prefs.length];
		for(int i=0;i<prefs.length;i++)
			_prefs[i] = Integer.parseInt(prefs[i].get_cols().get(0));
	}
	
	public int[] getPrefs() {
		return _prefs;
	}

}
