package com.crimetime.dao;

import com.crimetime.exception.CriminalException;
import com.crimetime.model.Criminal;

public interface criminalDao {
	
	//add a new criminal
	public int addNewCriminal(Criminal c) throws CriminalException; 
	
	
	
}
