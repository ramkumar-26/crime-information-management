package com.crimetime.dao;

import com.crimetime.model.Crime;
import com.crimetime.model.InvestigationDetails;

public class crimeDaoImpl implements crimeDao {

	@Override
	public int addNewCrime(Crime crime) {
		// TODO Auto-generated method stub
		return 0;
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
