package com.crimetime.model;

public class Criminal {
	private int criminal_id;
	private String criminal_name;
	private int age;
	private String gender;
	private String markInFace;
	private String FirstArrestPlace;
	
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMarkInFace() {
		return markInFace;
	}
	public void setMarkInFace(String markInFace) {
		this.markInFace = markInFace;
	}
	public String getFirstArrestPlace() {
		return FirstArrestPlace;
	}
	public void setFirstArrestPlace(String firstArrestPlace) {
		FirstArrestPlace = firstArrestPlace;
	}
	
	@Override
	public String toString() {
		return "CriminalBean [criminal_id=" + criminal_id + ", criminal_name=" + criminal_name + ", age=" + age
				+ ", gender=" + gender + ", markInFace=" + markInFace + ", FirstArrestPlace=" + FirstArrestPlace + "]";
	}
	
	public Criminal(int criminal_id, String criminal_name, int age, String gender, String markInFace,
			String firstArrestPlace) {
		super();
		this.criminal_id = criminal_id;
		this.criminal_name = criminal_name;
		this.age = age;
		this.gender = gender;
		this.markInFace = markInFace;
		FirstArrestPlace = firstArrestPlace;
	}
	
	
	
}
