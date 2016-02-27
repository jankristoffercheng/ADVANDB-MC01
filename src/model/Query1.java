package model;

public class Query1 implements Query{

	public static final String[] COLUMN_NAMES = 
			{"id",
			"memno",
			"age",
			"age_yr",
			"birth_date",
			"sex",
			"educind",
			"gradel",
			"ynotsch",
			"ynotsch_o",
			"reln",
			"jobind",
			"occup"};
	
	private int id;
	private int memno;
	private float age;
	private int age_yr;
	private String birth_date;
	private int sex;
	private int educind;
	private int gradel;
	private int ynotsch; 
	private String ynotsch_o; 
	private int reln; 
	private int jobind; 
	private String occup;
	
	public Query1(int id, int memno, float age, int age_yr, String birth_date, int sex, int educind, int gradel,
			int ynotsch, String ynotsch_o, int reln, int jobind, String occup) {
		super();

		this.id = id;
		this.memno = memno;
		this.age = age;
		this.age_yr = age_yr;
		this.birth_date = birth_date;
		this.sex = sex;
		this.educind = educind;
		this.gradel = gradel;
		this.ynotsch = ynotsch;
		this.ynotsch_o = ynotsch_o;
		this.reln = reln;
		this.jobind = jobind;
		this.occup = occup;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMemno() {
		return memno;
	}
	public void setMemno(int memno) {
		this.memno = memno;
	}
	public float getAge() {
		return age;
	}
	public void setAge(float age) {
		this.age = age;
	}
	public int getAge_yr() {
		return age_yr;
	}
	public void setAge_yr(int age_yr) {
		this.age_yr = age_yr;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getEducind() {
		return educind;
	}
	public void setEducind(int educind) {
		this.educind = educind;
	}
	public int getGradel() {
		return gradel;
	}
	public void setGradel(int gradel) {
		this.gradel = gradel;
	}
	public int getYnotsch() {
		return ynotsch;
	}
	public void setYnotsch(int ynotsch) {
		this.ynotsch = ynotsch;
	}
	public String getYnotsch_o() {
		return ynotsch_o;
	}
	public void setYnotsch_o(String ynotsch_o) {
		this.ynotsch_o = ynotsch_o;
	}
	public int getReln() {
		return reln;
	}
	public void setReln(int reln) {
		this.reln = reln;
	}
	public int getJobind() {
		return jobind;
	}
	public void setJobind(int jobind) {
		this.jobind = jobind;
	}
	public String getOccup() {
		return occup;
	}
	public void setOccup(String occup) {
		this.occup = occup;
	}
	@Override
	public Object[] getRow() {
		// TODO Auto-generated method stub			
		return new Object[] { id, memno, age, age_yr, birth_date, sex, educind, gradel, ynotsch, ynotsch_o, reln,
				jobind, occup };
	}
}
