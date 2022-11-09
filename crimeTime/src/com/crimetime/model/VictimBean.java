package com.crimetime.model;

public class VictimBean {
	private int victim_id;
	private String victim_name;
	private String address;
	private int contact_num;
	private String gender;
	private int age;
	public int getVictim_id() {
		return victim_id;
	}
	public void setVictim_id(int victim_id) {
		this.victim_id = victim_id;
	}
	public String getVictim_name() {
		return victim_name;
	}
	public void setVictim_name(String victim_name) {
		this.victim_name = victim_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getContact_num() {
		return contact_num;
	}
	public void setContact_num(int contact_num) {
		this.contact_num = contact_num;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public VictimBean(int victim_id, String victim_name, String address, int contact_num, String gender, int age) {
		super();
		this.victim_id = victim_id;
		this.victim_name = victim_name;
		this.address = address;
		this.contact_num = contact_num;
		this.gender = gender;
		this.age = age;
	}
	@Override
	public String toString() {
		return "VictimBean [victim_id=" + victim_id + ", victim_name=" + victim_name + ", address=" + address
				+ ", contact_num=" + contact_num + ", gender=" + gender + ", age=" + age + "]";
	}
	
	
	
	
}
