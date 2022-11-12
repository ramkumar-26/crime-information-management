package com.crimetime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.crimetime.exception.CriminalException;
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
}
