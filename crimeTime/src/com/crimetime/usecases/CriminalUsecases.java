  package com.crimetime.usecases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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


public class CriminalUsecases {
	UserInput input = new UserInput();
	UserInputMenu menu_options = new UserInputMenu();
	MainApp main = new MainApp();
	PoliceUserUsecases police_objects = new PoliceUserUsecases();
	
	//Add a new Criminal
		public void addNewCriminal() throws IOException, PoliceException {
			Scanner sc = new Scanner(System.in);
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			System.out.println("=============================");
			System.out.println("|  CRIMINAL REGISTRATION!!  |");
			System.out.println("=============================");
			System.out.println("Enter Criminal ID: ");
			int criminal_id = sc.nextInt();
			
			
			System.out.println("Enter Criminal Name:");
			String s_name = br.readLine();
			
			
			System.out.println("Enter Criminal Age: ");
			int c_age = sc.nextInt();
			
			
			System.out.println("Enter Criminal Gender:");
			String gender = br.readLine();
			
			
			System.out.println("Enter marks in criminal face:");
			String fm = br.readLine();
			
			
			System.out.println("Enter First Arrest Place:");
			String arrestLocation = sc.next();
			
			Criminal criminal = new Criminal(criminal_id, s_name, c_age, gender, fm, arrestLocation);
			criminalDao dao = new criminalDaoImpl();
			try {
				
				dao.addNewCriminal(criminal);
				
				//display back the menu
				menu_options.displayMenuAfterLogin();
				input.inputAfterLogin();
				
			}catch(CriminalException e){
				System.out.println(e.getMessage());
				
			}
		}
		
		
		public void displayAllCriminal() throws PoliceException, IOException {
			
			criminalDao dao = new criminalDaoImpl();
			try {
				List<Criminal> list = dao.displayAllCriminal();
		
				if(list.size()!=0) {
					System.out.println("CRIMINAL RECORDS!!!");
					System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------");
					for(int i=0;i<list.size();i++) {
						  Criminal c =  list.get(i);

						 System.out.println("Criminal [criminal_id=" + c.getCriminal_id() + ", criminal_name=" + c.getCriminal_name() + ", age=" + c.getAge()
									+ ", gender=" + c.getGender() + ", markInFace=" + c.getMarkInFace() + ", FirstArrestPlace=" + c.getFirstArrestPlace() + "]");
					
					  }
					System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");

				}
				input.backToMainMenuOrLogout();
				
			}catch(CriminalException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		
		public void searchCriminalWithCriminalID() throws PoliceException, IOException {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Criminal ID:");
			int criminalId = sc.nextInt();
			criminalDao dao = new criminalDaoImpl();
			crimeDao dao2 = new crimeDaoImpl();
			try {
				Criminal c = dao.displayCriminalDetailsWithCriminalID(criminalId);
				List<Crime> crime_list = dao.crimesLinkedWithCriminal(criminalId) ;
				
				
				
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
				
				
				
				input.backToMainMenuOrLogout();
				sc.close();
			}catch(CriminalException e) {
				System.out.println(e.getMessage());
			}
			sc.close();
		}
		
		
		
}
