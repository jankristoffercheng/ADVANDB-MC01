package model;

public class Query4 implements Query{
	
	public static final String[] COLUMN_NAMES =
				{"mun",
				"count",
				"total_mem",
				"rate"};
	
	private int mun;
	private int count;
	private int total_mem;
	private double rate;
	
	public Query4(int mun, int count, int total_mem, double rate) {
		super();
		this.mun = mun;
		this.count = count;
		this.total_mem = total_mem;
		this.rate = rate;
	}
	public int getMun() {
		return mun;
	}
	public void setMun(int mun) {
		this.mun = mun;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal_mem() {
		return total_mem;
	}
	public void setTotal_mem(int total_mem) {
		this.total_mem = total_mem;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	@Override
	public Object[] getRow() {
		// TODO Auto-generated method stub
		return new Object[]{mun, count, total_mem, rate};
	}
}
