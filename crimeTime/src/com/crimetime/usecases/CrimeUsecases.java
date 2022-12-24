package com.crimetime.usecases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import com.crimetime.dao.CrimeDao;
import com.crimetime.dao.CrimeDaoImpl;
import com.crimetime.exception.CrimeException;
import com.crimetime.exception.PoliceException;
import com.crimetime.model.Crime;
import com.crimetime.model.Criminal;
import com.crimetime.model.InvestigationDetails;


public class CrimeUsecases {
	PoliceUserUsecases police_object = new PoliceUserUsecases(); 
	UserInputMenu menu_options = new UserInputMenu();
	UserInput input = new UserInput();
	
	public void addNewCrime() throws IOException, PoliceException {	
		
		Scanner sc = new Scanner(System.in);
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.println("==========================");
		System.out.println("|  CRIME REGISTRATION!!  |");
		System.out.println("==========================");
		System.out.println("Enter Crime ID: ");
		int crime_id = sc.nextInt();
		System.out.println("Enter Crime Date(YYYY-MM-DD) :");
		String s_date = sc.next();
		
		System.out.println("Enter Short Description:");
		String s_desc = br.readLine();
		
		
		System.out.println("Enter Detailed Description: ");
		String d_desc = br.readLine();
		
		
		System.out.println("Enter Area of Crime:");
		String areaOfCrime = br.readLine();
		
		
		System.out.println("Enter Police Station:");
		String ps = br.readLine();
		
		
		System.out.println("Enter Victim Name:");
		String v_name = br.readLine();
		
		System.out.println("Enter Victim Age:");
		int v_age = sc.nextInt();
		
		
		System.out.println("Enter Victim Gender:");
		String v_gender = sc.next();
		
		
		System.out.println("Enter Victim Mobile Number:");
		String phone_no = br.readLine();
		
		System.out.println("Enter Victim Address:");
		String v_address = br.readLine();
		
		Crime crime = new Crime(crime_id, s_date, s_desc, d_desc, areaOfCrime, ps, v_name, v_age, v_gender, phone_no, v_address);
		
		CrimeDao new_crime = new CrimeDaoImpl();
		try {
			new_crime.addNewCrime(crime);
			
			//display back the menu
			menu_options.displayMenuAfterLogin();
			input.inputAfterLogin();
		}catch(CrimeException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
	}

	public void updateCrimeStatus() throws PoliceException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Crime ID:");
		int crime_id = sc.nextInt();
		System.out.println("Enter Crime Status to be changed(Solved or Unsolved):");
		String status = sc.next();
	
	
		CrimeDao dao = new CrimeDaoImpl();
		try {
			System.out.println(dao.updateCrimeStatus(crime_id, status));
		}catch(CrimeException e) {
			System.out.println(e.getMessage());
		}
		input.backToMainMenuOrLogout();  
	
	}
	
	public void linkCriminalWithCrime() throws PoliceException, IOException {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter Investigation ID:");
		int in_id = sc.nextInt();
		System.out.println("Enter Crime ID:");
		int crime_id = sc.nextInt();
		System.out.println("Enter Criminal ID to be linked with Crime "+crime_id+":");
		int criminal_id=sc.nextInt();
		System.out.println("Investigation Officer ID:");
		int officer_id = sc.nextInt();
		
		
		InvestigationDetails id = new InvestigationDetails(in_id, crime_id, criminal_id, "Unsolved", officer_id);
		
		CrimeDao dao = new CrimeDaoImpl();
		try {
			dao.linkCriminalWithCrime(id);
		} catch (CrimeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		input.backToMainMenuOrLogout(); 
		
	}
	
	public void displayAllCrime() throws PoliceException, IOException {
		
		CrimeDao dao = new CrimeDaoImpl();
		try {
			List<Crime> list = dao.displayAllCrime();
	
			if(list.size()!=0) {
				System.out.println("CRIME RECORDS!!!");
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
				for(int i=0;i<list.size();i++) {
					  Crime c =  list.get(i);

					  System.out.println("Crime [crime_id=" + c.getCrime_id() + ", crime_date=" + c.getCrime_date() + ", short_desc=" + c.getShort_desc()
					+  ", area_of_crime=" + c.getArea_of_crime() + ", policestation_code="
					+ c.getPolicestation_code() + ", victim_name=" + c.getVictim_name() +", v_mobileNumber=" + c.getV_mobileNumber()+ "]");

				  }
				System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");

			}
			input.backToMainMenuOrLogout();
			
		}catch(CrimeException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void searchCrimeDetailsWithCrimeID() throws PoliceException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Crime ID:");
		int crimeId = sc.nextInt();
		CrimeDao dao = new CrimeDaoImpl();
		
		try {
			Crime c = dao.displayCrimeDetailsWithCrimeID(crimeId);
			List<Criminal> criminal_list = dao.criminalsLinkedWithCrime(crimeId);
			String status = dao.getCrimeStatus(crimeId);
			
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
			
			input.backToMainMenuOrLogout();
			
		} catch (CrimeException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
	}
	
	public void GenerateReport() throws PoliceException, IOException {
		
		CrimeDao dao = new CrimeDaoImpl();
		try {
			String[] arr = dao.generateReport();
			System.out.println("=================Report=============");
			System.out.println("Total Number of Crime    :"+arr[0]);
			System.out.println("Crime in Current Month   :"+arr[1]);
			System.out.println("Unsolved Crime           :"+arr[2]);
			System.out.println("Solved Crime             :"+arr[3]);
			
		}catch(CrimeException e) {
			System.out.println(e.getMessage());
		}
		input.backToMainMenuOrLogout();
		
	}
	
	
	
	
}
