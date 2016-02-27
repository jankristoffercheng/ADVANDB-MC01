package model;

public class Query2 implements Query{
	
	public final static String[] COLUMN_NAMES = 
			{"occup",
			"numOccup"};
	
	private String occup;
	private int numOccup;
	
	public Query2(String occup, int numOccup) {
		super();
		this.occup = occup;
		this.numOccup = numOccup;
	}
	public String getOccup() {
		return occup;
	}
	public void setOccup(String occup) {
		this.occup = occup;
	}
	public int getNumOccup() {
		return numOccup;
	}
	public void setNumOccup(int numOccup) {
		this.numOccup = numOccup;
	}
	@Override
	public Object[] getRow() {
		// TODO Auto-generated method stub
		return new Object[]{occup, numOccup};
	}
}
