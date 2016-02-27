package model;

public class Query5 implements Query{
	
	public final static String[] COLUMN_NAMES = 
				{"municipality",
				"household",
				"aquatype",
				"aquatype_o",
				"aquani_vol"};
	
	private int municipality;
	private int household;
	private int aquatype;
	private String aquatype_o;
	private int aquani_vol;
	
	public Query5(int municipality, int household, int aquatype, String aquatype_o, int aquani_vol) {
		super();
		this.municipality = municipality;
		this.household = household;
		this.aquatype = aquatype;
		this.aquatype_o = aquatype_o;
		this.aquani_vol = aquani_vol;
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

	public int getAquatype() {
		return aquatype;
	}

	public void setAquatype(int aquatype) {
		this.aquatype = aquatype;
	}

	public String getAquatype_o() {
		return aquatype_o;
	}

	public void setAquatype_o(String aquatype_o) {
		this.aquatype_o = aquatype_o;
	}

	public int getAquani_vol() {
		return aquani_vol;
	}

	public void setAquani_vol(int aquani_vol) {
		this.aquani_vol = aquani_vol;
	}

	@Override
	public Object[] getRow() {
		// TODO Auto-generated method stub
		return new Object[]{municipality, household, aquatype, aquatype_o, aquani_vol};
	}
}
