package com.crimetime.dao;

import com.crimetime.model.Crime;
import com.crimetime.model.InvestigationDetails;

public interface crimeDao {
	
	//add a new crime
	public int addNewCrime(Crime crime);
	
	//update crime
	public String updateCrimeStatus(int crimeID);
	
	//display crime based on filter
	public InvestigationDetails displayCrimeDetailsWithCrimeID(int crimeID);
	public InvestigationDetails displayAllCrimeDetails();
	public InvestigationDetails displayPoliceStationWiseCrime(String policeStationID);
	public InvestigationDetails displayAreaWiseCrime(String location);
	public Crime displaySolvedCrime();
	public Crime displayUnsolvedCrime();
	
	
	
}
