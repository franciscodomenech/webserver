package utils;

public interface ITable {
	public String[] getColumns();
	public FieldDB[] getFields();
	public FieldDB getIdField();
}
