package model;

public class Query3 implements Query{
	
	public final static String[] COLUMN_NAMES =
				{"household",
				"monthly_income",
				"count"};
	
	private int houshold;
	private double monthly_income;
	private int count;
	
	public Query3(int houshold, double monthly_income, int count) {
		super();
		this.houshold = houshold;
		this.monthly_income = monthly_income;
		this.count = count;
	}
	public int getHoushold() {
		return houshold;
	}
	public void setHoushold(int houshold) {
		this.houshold = houshold;
	}	
	public double getMonthly_income() {
		return monthly_income;
	}
	public void setMonthly_income(int monthly_income) {
		this.monthly_income = monthly_income;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public Object[] getRow() {
		// TODO Auto-generated method stub
		return new Object[]{houshold, monthly_income, count};
	}
	
	
}
