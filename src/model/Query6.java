package model;

public class Query6 implements Query{
	
	public final static String[] COLUMN_NAMES =
			{"municipality",
			"household",
			"croptype",
			"croptype_o",
			"crop_vol"};
	
	private int municipality;
	private int household;
	private int croptype;
	private String croptype_o;
	private int crop_vol;
	
	public Query6(int municipality, int household, int croptype, String croptype_o, int crop_vol) {
		super();
		this.municipality = municipality;
		this.household = household;
		this.croptype = croptype;
		this.croptype_o = croptype_o;
		this.crop_vol = crop_vol;
	}
	public int getMunicipality() {
		return municipality;
	}
	public void setMunicipality(int municipality) {
		this.municipality = municipality;
	}
	public int getHousehold() {
		return household;
	}
	public void setHousehold(int household) {
		this.household = household;
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
	@Override
	public Object[] getRow() {
		// TODO Auto-generated method stub
		return new Object[]{municipality, household, croptype, croptype_o, crop_vol};
	}
}
