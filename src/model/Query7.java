package model;

public class Query7 implements Query{
	
	public final static String[] COLUMN_NAMES =
				{"mun",
				"household",
				"aquanitype",
				"aquanitype_o",
				"aquani_vol",
				"croptype",
				"croptype_o",
				"crop_vol",
				"monthly_income"};
	
	private int mun;
	private int household;
	private int aquanitype;
	private String aquanitype_o;
	private int aquani_vol;
	private int croptype;
	private String croptype_o;
	private int crop_vol;
	private double monthly_income;
	
	public Query7(int mun, int household, int aquanitype, String aquanitype_o, int aquani_vol, int croptype,
			String croptype_o, int crop_vol, double monthly_income) {
		super();
		this.mun = mun;
		this.household = household;
		this.aquanitype = aquanitype;
		this.aquanitype_o = aquanitype_o;
		this.aquani_vol = aquani_vol;
		this.croptype = croptype;
		this.croptype_o = croptype_o;
		this.crop_vol = crop_vol;
		this.monthly_income = monthly_income;
	}
	public int getMun() {
		return mun;
	}
	public void setMun(int mun) {
		this.mun = mun;
	}
	public int getHousehold() {
		return household;
	}
	public void setHousehold(int household) {
		this.household = household;
	}
	public int getAquanitype() {
		return aquanitype;
	}
	public void setAquanitype(int aquanitype) {
		this.aquanitype = aquanitype;
	}
	public String getAquanitype_o() {
		return aquanitype_o;
	}
	public void setAquanitype_o(String aquanitype_o) {
		this.aquanitype_o = aquanitype_o;
	}
	public int getAquani_vol() {
		return aquani_vol;
	}
	public void setAquani_vol(int aquani_vol) {
		this.aquani_vol = aquani_vol;
	}
	public int getCroptype() {
		return croptype;
	}
	public void setCroptype(int croptype) {
		this.croptype = croptype;
	}
	public String getCroptype_o() {
		return croptype_o;
	}
	public void setCroptype_o(String croptype_o) {
		this.croptype_o = croptype_o;
	}
	public int getCrop_vol() {
		return crop_vol;
	}
	public void setCrop_vol(int crop_vol) {
		this.crop_vol = crop_vol;
	}
	public double getMonthly_income() {
		return monthly_income;
	}
	public void setMonthly_income(double monthly_income) {
		this.monthly_income = monthly_income;
	}
	@Override
	public Object[] getRow() {
		// TODO Auto-generated method stub
		return new Object[]{mun, household, aquanitype, aquanitype_o, aquani_vol, croptype, croptype_o, crop_vol, monthly_income};
	}
}
