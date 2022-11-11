package com.crimetime.dao;

import java.sql.Connection;
import java.sql.Date;
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
			PreparedStatement ps = conn.prepareStatement("insert into crime values (?,?,?,?,?,?,?,?,?,?,?)");
			
			ps.setInt(1, crime.getCrime_id());
			ps.setDate(2, (Date) crime.getCrime_date());
			ps.setString(3, crime.getShort_desc());
			ps.setString(4, crime.getDetailed_desc());
			ps.setString(5, crime.getArea_of_crime());
			ps.setString(6, crime.getPolicestation_code());
			ps.setString(7, crime.getVictim_name());
			ps.setString(8, crime.getV_address());
			ps.setInt(9, crime.getV_age());
			ps.setString(10, crime.getV_gender());
			ps.setInt(11, crime.getV_mobileNumber());
			
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Crime Added with Crime ID "+crime.getCrime_id());
				
			}else {
				throw new CrimeException("Error Adding Crime!");
			}
			
			
		}catch(SQLException e) {
			
		}
		
		return res;
	}

	@Override
	public String updateCrimeStatus(int crimeID) {
		// TODO Auto-generated method stub
		return null;
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

}
