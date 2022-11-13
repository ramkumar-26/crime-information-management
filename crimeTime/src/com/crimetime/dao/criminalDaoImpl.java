package com.crimetime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crimetime.exception.CrimeException;
import com.crimetime.exception.CriminalException;
import com.crimetime.model.Crime;
import com.crimetime.model.Criminal;
import com.crimetime.utility.DBUtil;

public class criminalDaoImpl implements criminalDao {
	

	@Override
	public int addNewCriminal(Criminal c) throws CriminalException {
		// TODO Auto-generated method stub
		int res = 0;
		try(Connection conn =  DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into criminal_records values (?,?,?,?,?,?)");
			ps.setInt(1, c.getCriminal_id());
			ps.setString(2, c.getCriminal_name());
			ps.setInt(3, c.getAge());
			ps.setString(4, c.getGender());
			ps.setString(5, c.getMarkInFace());
			ps.setString(6, c.getFirstArrestPlace());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Criinal "+c.getCriminal_id()+" Added to the Database! You can now link this criminal with a crime!");
			}else {
				throw new CriminalException("Error Adding Crime!");
			}	
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Internal Error!");
		}
	
		return res;
	}

	@Override
	public List<Criminal> displayAllCriminalDetails() throws CriminalException {
		List<Criminal> c = new ArrayList<>();
		
		try(Connection conn =  DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from criminal_records");
			ResultSet rs = ps.executeQuery();
			boolean flag = false; 
			while(rs.next()) {
				flag = true;
				c.add(new Criminal(rs.getInt("Criminal_ID"), rs.getString("Criminal_Name"), rs.getInt("Age"), rs.getString("Gender"), rs.getString("Mark_In_Face"), rs.getString("First_Arrest_Place")));
			}
			
			if(flag==false) {
				throw new CriminalException("Empty Records!");
			}
		}catch (SQLException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		return c;
	}

	@Override
	public Criminal displayCriminalDetailsWithCriminalID(int criminalID) throws CriminalException {
		// TODO Auto-generated method stub
		
		Criminal c = null;
		
		try(Connection conn =  DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from criminal_records where criminal_id = ?");
			ps.setInt(1, criminalID);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int criminal_id = rs.getInt("criminal_id");
				String Criminal_Name = rs.getString("Criminal_Name");
				int Age = rs.getInt("Age");
				String gender = rs.getString("Gender");
				String mark_in_face = rs.getString("Mark_In_Face");
				String arrestLocation = rs.getString("First_Arrest_Place");
				c = new Criminal(criminal_id, Criminal_Name, Age, gender, mark_in_face, arrestLocation);
				
			}else {
				throw new CrimeException("No Ciminal Found!");
			}
		}catch(Exception e) {	
			System.err.println(e.getMessage());
		}
		
		
		return c;
	}

	@Override
	public List<Crime> CrimesLinkedWithCriminal(int criminalID) {
		// TODO Auto-generated method stub
        List<Crime> c = new ArrayList<>();
		
		try(Connection conn =  DBUtil.provideConnection()){
			
			
			//getting criminal list
			PreparedStatement ps = conn.prepareStatement("select crime_id from investigation_details where criminal_id=?");
			ps.setInt(1, criminalID);
			
			ResultSet rs = ps.executeQuery();
			List<Integer> c_list = new ArrayList<>();
			boolean flag = false;
			while(rs.next()) {
				flag = true;
				c_list.add(rs.getInt("crime_id"));
			}
			
			if(flag==false) {
				throw new CriminalException("No Criminal Found!");
			}
			
			for(int i=0;i<c_list.size();i++) {
				
				PreparedStatement ps2 = conn.prepareStatement("select * from crime_records where crime_id=?");
				ps2.setInt(1, c_list.get(i));
				
				ResultSet rs2 = ps2.executeQuery();
				
				if(rs2.next()) {

					int crime_id=rs2.getInt("crime_id");
					String date = ""+ rs2.getDate("crimeDate");
					String shortDesc = rs2.getString("ShortDesc");
					String detailedDesc = rs2.getString("DetailedDesc");
					String AreaOfCrime = rs2.getString("AreaOfCrime");
					String police_station = rs2.getString("PoliceStation_Code");
					String Victim_Name = rs2.getString("Victim_Name");
					String Victim_Address = rs2.getString("Victim_Address");
					int Victim_Age = rs2.getInt("Victim_Age");
					String Victim_Gender = rs2.getString("Victim_Gender");
					String Victim_Mobilenumber = rs2.getString("Victim_Mobilenumber");
					
					c.add(new Crime(crime_id, date, shortDesc, detailedDesc, AreaOfCrime,police_station, Victim_Name, Victim_Age, Victim_Gender, Victim_Mobilenumber, Victim_Address));
				}
			}
		}catch(Exception e) {	
			System.out.println(e.getMessage());
		}
		
		return c;
	}
}