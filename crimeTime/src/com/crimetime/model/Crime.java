package com.crimetime.model;

import java.sql.Date;

public class Crime {
		
		private int crime_id;
		private String crime_date;
		private String short_desc;
		private String detailed_desc;
		private String area_of_crime;
		private String policestation_code;
		private String victim_name;
		private int v_age;
		private String v_gender;
		private String v_mobileNumber;
		private String v_address;
		
		
		
		public String getVictim_name() {
			return victim_name;
		}
		public void setVictim_name(String victim_name) {
			this.victim_name = victim_name;
		}
		public int getV_age() {
			return v_age;
		}
		public void setV_age(int v_age) {
			this.v_age = v_age;
		}
		public String getV_gender() {
			return v_gender;
		}
		public void setV_gender(String v_gender) {
			this.v_gender = v_gender;
		}
		public String getV_mobileNumber() {
			return v_mobileNumber;
		}
		public void setV_mobileNumber(String v_mobileNumber) {
			this.v_mobileNumber = v_mobileNumber;
		}
		public String getV_address() {
			return v_address;
		}
		public void setV_address(String v_address) {
			this.v_address = v_address;
		}


		
		
		
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
		
		
		
		
		public Crime() {
			//empty constructor
		}
		public Crime(int crime_id, String s_date, String short_desc, String detailed_desc, String area_of_crime,
				String policestation_code, String victim_name, int v_age, String v_gender, String v_mobileNumber,
				String v_address) {
			super();
			this.crime_id = crime_id;
			this.crime_date = s_date;
			this.short_desc = short_desc;
			this.detailed_desc = detailed_desc;
			this.area_of_crime = area_of_crime;
			this.policestation_code = policestation_code;
			this.victim_name = victim_name;
			this.v_age = v_age;
			this.v_gender = v_gender;
			this.v_mobileNumber = v_mobileNumber;
			this.v_address = v_address;
		}
		
		
		@Override
		public String toString() {
			return "Crime [crime_id=" + crime_id + ", crime_date=" + crime_date + ", short_desc=" + short_desc
					+ ", detailed_desc=" + detailed_desc + ", area_of_crime=" + area_of_crime + ", policestation_code="
					+ policestation_code + ", victim_name=" + victim_name + ", v_age=" + v_age + ", v_gender=" + v_gender
					+ ", v_mobileNumber=" + v_mobileNumber + ", v_address=" + v_address + "]";
		}
		
}
