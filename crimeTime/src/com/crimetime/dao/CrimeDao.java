package com.crimetime.dao;

import java.util.List;

import com.crimetime.exception.CrimeException;
import com.crimetime.model.Crime;
import com.crimetime.model.Criminal;
import com.crimetime.model.InvestigationDetails;

public interface CrimeDao {
	
	//add a new crime
	public int addNewCrime(Crime crime) throws CrimeException;
	
	//update crime
	public String updateCrimeStatus(int crimeID,String Status) throws CrimeException;
	
	//link crime and criminal
	public int linkCriminalWithCrime(InvestigationDetails id) throws CrimeException; 
	
	//display crime based on filter
	
	public Crime displayCrimeDetailsWithCrimeID(int crimeID) throws CrimeException;
	public List<Crime> displayAllCrime() throws CrimeException;
	
	
	public List<Criminal> criminalsLinkedWithCrime(int crimeID);
	
	public String getCrimeStatus(int crimeID);
	
	public String[] generateReport() throws CrimeException;
	
}
