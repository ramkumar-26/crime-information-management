package com.crimetime.model;

public class Request {
	private int request_id;
	private int police_id;
	private String access_status;
	public Request(int request_id, int police_id, String access_status) {
		super();
		this.request_id = request_id;
		this.police_id = police_id;
		this.access_status = access_status;
	}
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	public int getPolice_id() {
		return police_id;
	}
	public void setPolice_id(int police_id) {
		this.police_id = police_id;
	}
	public String getAccess_status() {
		return access_status;
	}
	public void setAccess_status(String access_status) {
		this.access_status = access_status;
	}
	
	
	
}
