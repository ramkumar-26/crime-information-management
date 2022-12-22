package com.crimetime.usecases;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.crimetime.dao.crimeDao;
import com.crimetime.dao.crimeDaoImpl;
import com.crimetime.dao.criminalDao;
import com.crimetime.dao.criminalDaoImpl;
import com.crimetime.exception.CrimeException;
import com.crimetime.exception.CriminalException;
import com.crimetime.exception.PoliceException;
import com.crimetime.model.Crime;
import com.crimetime.model.Criminal;

public class SearchFuntions {
	
	public void CriminalWithCriminalID() throws PoliceException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Criminal ID:");
		int input = sc.nextInt();
		criminalDao dao = new criminalDaoImpl();
		crimeDao dao2 = new crimeDaoImpl();
		try {
			Criminal c = dao.displayCriminalDetailsWithCriminalID(input);
			List<Crime> crime_list = dao.CrimesLinkedWithCriminal(input) ;
			
			
			
			if(c!=null) {
				System.out.println("====================================================");
				System.out.println(" Criminal Name      : "+c.getCriminal_name());
				System.out.println(" Criminal ID        : "+c.getCriminal_id());
				System.out.println(" Criminal Age       : "+c.getAge());
				System.out.println(" Gender             : "+c.getGender());
				System.out.println(" Mark in Face       : "+c.getMarkInFace());
				System.out.println(" First Arrest Place : "+c.getFirstArrestPlace());
				
				System.out.println("----------Crimes linked with this Criminal------------");
				if(crime_list.size()==0) {
					System.out.println("Crimes not Found!");
				}else {
					for(int i=0;i<crime_list.size();i++) {
						Crime cri = crime_list.get(i);
						String status = dao2.getCrimeStatus(cri.getCrime_id());
						System.out.println("====================================================");
						System.out.println(" Crime Id              : "+cri.getCrime_id());
						System.out.println(" Crime Date            : "+cri.getCrime_date());
						System.out.println(" Short Description     : "+cri.getShort_desc());
						System.out.println(" Detailed Description  : "+cri.getDetailed_desc());
						System.out.println(" Area Of Crime         : "+cri.getArea_of_crime());
						System.out.println(" Crime Status          : "+status);
						System.out.println(" Police Station        : "+cri.getPolicestation_code());
						System.out.println(" Victime Name          : "+cri.getVictim_name());
						System.out.println(" Victim Address        : "+cri.getV_address());
						System.out.println(" Victim Age            : "+cri.getV_age());
						System.out.println(" Victim Gender         : "+cri.getV_gender());
						System.out.println(" Victim Number         : "+cri.getV_mobileNumber());
					}
				}
				
				
			}else {
				System.out.println("Criminal Not Found!");
			}
			PoliceFunctions pf = new PoliceFunctions();
			
			pf.backToMainMenuOrLogout();
			
		}catch(CriminalException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
	public void CrimeWithCrimeID() throws PoliceException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Crime ID:");
		int input = sc.nextInt();
		crimeDao dao = new crimeDaoImpl();
		
		try {
			Crime c = dao.displayCrimeDetailsWithCrimeID(input);
			List<Criminal> criminal_list = dao.CriminalsLinkedWithCrime(input);
			String status = dao.getCrimeStatus(input);
			
			System.out.println("====================================================");
			System.out.println(" Crime Id              : "+c.getCrime_id());
			System.out.println(" Crime Date            : "+c.getCrime_date());
			System.out.println(" Short Description     : "+c.getShort_desc());
			System.out.println(" Detailed Description  : "+c.getDetailed_desc());
			System.out.println(" Area Of Crime         : "+c.getArea_of_crime());
			System.out.println(" Crime Status          : "+status);
			System.out.println(" Police Station        : "+c.getPolicestation_code());
			System.out.println(" Victime Name          : "+c.getVictim_name());
			System.out.println(" Victim Address        : "+c.getV_address());
			System.out.println(" Victim Age            : "+c.getV_age());
			System.out.println(" Victim Gender         : "+c.getV_gender());
			System.out.println(" Victim Number         : "+c.getV_mobileNumber());
			System.out.println("-----------Criminals Linked with this crime----------");
			if(criminal_list.size()==0) {
				System.out.println("No Criminal linked with this Crime!");
			}else {
				for(int i=0;i<criminal_list.size();i++) {
					System.out.println("Criminal "+(i+1));
					Criminal cri = criminal_list.get(i);
					System.out.println(" Criminal Name      : "+cri.getCriminal_name());
					System.out.println(" Criminal ID        : "+cri.getCriminal_id());
					System.out.println(" Criminal Age       : "+cri.getAge());
					System.out.println(" Gender             : "+cri.getGender());
					System.out.println(" Mark in Face       : "+cri.getMarkInFace());
					System.out.println(" First Arrest Place : "+cri.getFirstArrestPlace());
					
					System.out.println("----------------------------------------------------");
				}
				
			}
			
			PoliceFunctions pf = new PoliceFunctions();
			
			pf.backToMainMenuOrLogout();
			
		} catch (CrimeException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
}
