package com.crimetime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.crimetime.exception.PoliceException;
import com.crimetime.model.Police;
import com.crimetime.utility.DBUtil;


public class PoliceDaoImpl implements PoliceDao {

	@Override
	public int addPolice(Police police) throws PoliceException {
		// TODO Auto-generated method stub
		int res = 0;
		try(Connection conn =  DBUtil.provideConnection()){
			PreparedStatement ps = 
					conn.prepareStatement(
							"insert into police_records values(?,?,?,?,?)"
					);
			ps.setInt(1, police.getPolice_id());
			ps.setString(2, police.getName());
			ps.setString(3, police.getAssigned_policestation());
			ps.setString(4, police.getPassword());
			ps.setString(5, null);
			
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				res = 1;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new PoliceException("Error inserting data");
		}
		return res;
	}

}
