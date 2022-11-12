package com.crimetime.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.crimetime.exception.CrimeException;
import com.crimetime.model.Crime;
import com.crimetime.model.InvestigationDetails;
import com.crimetime.utility.DBUtil;

public class crimeDaoImpl implements crimeDao {

	@Override
	public int addNewCrime(Crime crime) throws CrimeException {
		// TODO Auto-generated method stub
		int res = 0;
		
		try(Connection conn =  DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into crime_records values (?,?,?,?,?,?,?,?,?,?,?)");
			
			ps.setInt(1, crime.getCrime_id());
			//ps.setString(2, crime.getCrime_date());
			ps.setDate(2, java.sql.Date.valueOf(crime.getCrime_date()) );
			ps.setString(3, crime.getShort_desc());
			ps.setString(4, crime.getDetailed_desc());
			ps.setString(5, crime.getArea_of_crime());
			ps.setString(6, crime.getPolicestation_code());
			ps.setString(7, crime.getVictim_name());
			ps.setString(8, crime.getV_address());
			ps.setInt(9, crime.getV_age());
			ps.setString(10, crime.getV_gender());
			ps.setString(11, crime.getV_mobileNumber());
			
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Crime Added with Crime ID "+crime.getCrime_id());
				
			}else {
				throw new CrimeException("Error Adding Crime!");
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		
		}
		
		return res;
	}

	@Override
	public String updateCrimeStatus(int crimeID,String status) {
		// TODO Auto-generated method stub
		String res = null ;
		

		try(Connection conn =  DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("update investigation_records set status = ? where crime_id = ?");
			
			ps.setString(1, status);
			ps.setInt(2, crimeID);
			
		}catch(SQLException e) {
			
		}
		
		return res;
	}

	@Override
	public InvestigationDetails displayCrimeDetailsWithCrimeID(int crimeID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvestigationDetails displayAllCrimeDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvestigationDetails displayPoliceStationWiseCrime(String policeStationID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvestigationDetails displayAreaWiseCrime(String location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Crime displaySolvedCrime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Crime displayUnsolvedCrime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int linkCriminalWithCrime(InvestigationDetails id) throws CrimeException {
		// TODO Auto-generated method stub
		int res = 0;

		try(Connection conn =  DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into investigation_details values (?,?,?,?,?)");
			ps.setInt(1, id.getInvestigation_id());
			ps.setInt(2, id.getCrime_id());
			ps.setInt(3, id.getCriminal_id());
			ps.setString(4, id.getInvestigation_status());
			ps.setInt(5, id.getInvestigation_office_id());
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Criminal "+id.getCrime_id()+" Linked with crime "+id.getCrime_id());
			}else {
				throw new CrimeException("Error Linking crime with criminal");
			}
			
		}catch(SQLException e) {	
			e.printStackTrace();
		}
		
		
		return res;
	}

}
