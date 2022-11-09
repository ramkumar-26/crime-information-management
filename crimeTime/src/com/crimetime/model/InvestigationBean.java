package com.crimetime.model;

public class InvestigationBean {
	
	private int investigation_id;
	private int crime_id;
	private int criminal_id;
	private String investigation_status;
	private int investigation_office_id;
	public int getInvestigation_id() {
		return investigation_id;
	}
	public void setInvestigation_id(int investigation_id) {
		this.investigation_id = investigation_id;
	}
	public int getCrime_id() {
		return crime_id;
	}
	public void setCrime_id(int crime_id) {
		this.crime_id = crime_id;
	}
	public int getCriminal_id() {
		return criminal_id;
	}
	public void setCriminal_id(int criminal_id) {
		this.criminal_id = criminal_id;
	}
	public String getInvestigation_status() {
		return investigation_status;
	}
	public void setInvestigation_status(String investigation_status) {
		this.investigation_status = investigation_status;
	}
	public int getInvestigation_office_id() {
		return investigation_office_id;
	}
	public void setInvestigation_office_id(int investigation_office_id) {
		this.investigation_office_id = investigation_office_id;
	}
	public InvestigationBean(int investigation_id, int crime_id, int criminal_id, String investigation_status,
			int investigation_office_id) {
		super();
		this.investigation_id = investigation_id;
		this.crime_id = crime_id;
		this.criminal_id = criminal_id;
		this.investigation_status = investigation_status;
		this.investigation_office_id = investigation_office_id;
	}
	@Override
	public String toString() {
		return "InvestigationBean [investigation_id=" + investigation_id + ", crime_id=" + crime_id + ", criminal_id="
				+ criminal_id + ", investigation_status=" + investigation_status + ", investigation_office_id="
				+ investigation_office_id + "]";
	}
	
	
	public InvestigationBean() {
		//empty
	}
}
