package com.crimetime.model;

public class CrimeDetails {
	private int crime_id;
	private String crime_date;
	private String short_desc;
	private String detailed_desc;
	private String area_of_crime;
	private String policestation_code;
	private int victim_id;
	private int criminal_id;
	private String criminal_name;
	private int  criminal_age;
	private String criminal_gender;
	private String criminalmarkInFace;
	private String FirstArrestPlace;
	
	
	
	public int getCrime_id() {
		return crime_id;
	}
	public void setCrime_id(int crime_id) {
		this.crime_id = crime_id;
	}
	public String getCrime_date() {
		return crime_date;
	}
	public void setCrime_date(String crime_date) {
		this.crime_date = crime_date;
	}
	public String getShort_desc() {
		return short_desc;
	}
	public void setShort_desc(String short_desc) {
		this.short_desc = short_desc;
	}
	public String getDetailed_desc() {
		return detailed_desc;
	}
	public void setDetailed_desc(String detailed_desc) {
		this.detailed_desc = detailed_desc;
	}
	public String getArea_of_crime() {
		return area_of_crime;
	}
	public void setArea_of_crime(String area_of_crime) {
		this.area_of_crime = area_of_crime;
	}
	public String getPolicestation_code() {
		return policestation_code;
	}
	public void setPolicestation_code(String policestation_code) {
		this.policestation_code = policestation_code;
	}
	public int getVictim_id() {
		return victim_id;
	}
	public void setVictim_id(int victim_id) {
		this.victim_id = victim_id;
	}
	public int getCriminal_id() {
		return criminal_id;
	}
	public void setCriminal_id(int criminal_id) {
		this.criminal_id = criminal_id;
	}
	public String getCriminal_name() {
		return criminal_name;
	}
	public void setCriminal_name(String criminal_name) {
		this.criminal_name = criminal_name;
	}
	public int getCriminal_age() {
		return criminal_age;
	}
	public void setCriminal_age(int criminal_age) {
		this.criminal_age = criminal_age;
	}
	public String getCriminal_gender() {
		return criminal_gender;
	}
	public void setCriminal_gender(String criminal_gender) {
		this.criminal_gender = criminal_gender;
	}
	public String getCriminalmarkInFace() {
		return criminalmarkInFace;
	}
	public void setCriminalmarkInFace(String criminalmarkInFace) {
		this.criminalmarkInFace = criminalmarkInFace;
	}
	public String getFirstArrestPlace() {
		return FirstArrestPlace;
	}
	public void setFirstArrestPlace(String firstArrestPlace) {
		FirstArrestPlace = firstArrestPlace;
	}
	
	
	public CrimeDetails(int crime_id, String crime_date, String short_desc, String detailed_desc, String area_of_crime,
			String policestation_code, int victim_id, int criminal_id, String criminal_name, int criminal_age,
			String criminal_gender, String criminalmarkInFace, String firstArrestPlace) {
		super();
		this.crime_id = crime_id;
		this.crime_date = crime_date;
		this.short_desc = short_desc;
		this.detailed_desc = detailed_desc;
		this.area_of_crime = area_of_crime;
		this.policestation_code = policestation_code;
		this.victim_id = victim_id;
		this.criminal_id = criminal_id;
		this.criminal_name = criminal_name;
		this.criminal_age = criminal_age;
		this.criminal_gender = criminal_gender;
		this.criminalmarkInFace = criminalmarkInFace;
		FirstArrestPlace = firstArrestPlace;
	}
	@Override
	public String toString() {
		return "CrimeDetails [crime_id=" + crime_id + ", crime_date=" + crime_date + ", short_desc=" + short_desc
				+ ", detailed_desc=" + detailed_desc + ", area_of_crime=" + area_of_crime + ", policestation_code="
				+ policestation_code + ", victim_id=" + victim_id + ", criminal_id=" + criminal_id + ", criminal_name="
				+ criminal_name + ", criminal_age=" + criminal_age + ", criminal_gender=" + criminal_gender
				+ ", criminalmarkInFace=" + criminalmarkInFace + ", FirstArrestPlace=" + FirstArrestPlace + "]";
	}
	
	
	
	
	
}
