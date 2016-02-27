package model;

public class QueryReturnable {
	private String[] columnNames;
	private Object[][] queryResultList;
	
	public QueryReturnable(String[] columnNames, Object[][] queryResultList) {
		this.columnNames = columnNames;
		this.queryResultList = queryResultList;
	}
	public String[] getColumnNames() {
		return columnNames;
	}
	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}
	public Object[][] getQueryResultList() {
		return queryResultList;
	}
	public void setQueryResultList(Object[][] queryResultList) {
		this.queryResultList = queryResultList;
	}
	
}
