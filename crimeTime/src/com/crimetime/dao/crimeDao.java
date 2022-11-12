package com.crimetime.dao;

import com.crimetime.exception.CrimeException;
import com.crimetime.model.Crime;
import com.crimetime.model.InvestigationDetails;

public interface crimeDao {
	
	//add a new crime
	public int addNewCrime(Crime crime) throws CrimeException;
	
	//update crime
	public String updateCrimeStatus(int crimeID,String Status) throws CrimeException;
	
	//link crime and criminal
	public int linkCriminalWithCrime(InvestigationDetails id) throws CrimeException; 
	
	//display crime based on filter
	public InvestigationDetails displayCrimeDetailsWithCrimeID(int crimeID);
	public InvestigationDetails displayAllCrimeDetails();
	public InvestigationDetails displayPoliceStationWiseCrime(String policeStationID);
	public InvestigationDetails displayAreaWiseCrime(String location);
	public Crime displaySolvedCrime();
	public Crime displayUnsolvedCrime();
	
	
	
}
