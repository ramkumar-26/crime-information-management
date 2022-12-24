package com.crimetime.dao;

import java.util.List;

import com.crimetime.exception.CrimeException;
import com.crimetime.exception.CriminalException;
import com.crimetime.model.Crime;
import com.crimetime.model.Criminal;

public interface CriminalDao {
	
	//add a new criminal
	public int addNewCriminal(Criminal c) throws CriminalException; 
	
	public List<Criminal> displayAllCriminal() throws CriminalException;
	
	public List<Crime> crimesLinkedWithCriminal(int criminalID);

	public Criminal displayCriminalDetailsWithCriminalID(int criminalID) throws CriminalException;
	
	
	
}
