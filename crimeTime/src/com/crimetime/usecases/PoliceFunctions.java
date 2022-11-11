package com.crimetime.usecases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.crimetime.dao.PoliceDao;
import com.crimetime.dao.PoliceDaoImpl;
import com.crimetime.dao.crimeDao;
import com.crimetime.dao.crimeDaoImpl;
import com.crimetime.exception.CrimeException;
import com.crimetime.exception.PoliceException;
import com.crimetime.model.Crime;
import com.crimetime.model.Police;

public class PoliceFunctions {
	public  void AddPolice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("POLICE REGISTRATION");
		System.out.println("Enter Police ID:");
		int police_id = sc.nextInt();
		System.out.println("Enter Name:");
		String police_name = sc.next();
		System.out.println("Enter Reporting PoliceStation:\n");
		String reporting_ps = sc.next();
		System.out.println("Enter Password:\n");
		String password = sc.next();
		
		Police p = new Police();
		p.setPolice_id(police_id);
		p.setName(police_name);
		p.setAssigned_policestation(reporting_ps);
		p.setPassword(password);
		p.setAccess_status(null);
		
		PoliceDao dao = new PoliceDaoImpl();
		try {
			int res = dao.addPolice(p);
			if(res==0) {
				throw new PoliceException("Insertion Failed!");
			}else {
				System.out.println("Police Record Added!");
			}
		} catch (PoliceException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public void  policeLogin() throws PoliceException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter PoliceID:");
		int police_id = sc.nextInt();
		System.out.println("Enter Password:");
		String password = sc.next();
		
		PoliceDao dao = new PoliceDaoImpl();
		boolean res = dao.policeLogin(police_id, password);
		if(res) {
			System.out.println("Login Successful!");
			
			DisplayPoliceMenu();
			
			PoliceMainInput();
			
			
			
		}else {
			throw new PoliceException("Login Failed!");
		}
		
	}
	
	//police menu
	public void DisplayPoliceMenu() {
		System.out.println("=====================================");
		System.out.println("| 1. Register a New Crime           |");
		System.out.println("| 2. Update a Crime Status          |");
		System.out.println("| 3. Register a new Criminal        |");
		System.out.println("| 4. Link  Criminal with  Crime     |");
		System.out.println("| 5. Search Crime or Criminal       |");
		System.out.println("| 6. Generate Report                |");
		System.out.println("| 7. Logout                         |");
		System.out.println("=====================================");
	}
	
	public void PoliceMainInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Any Options:");
		int input = sc.nextInt();
		switch (input) {
		case 1:
			AddNewCrime();
			break;
		case 2:
			break;
		case 3: 
			break;
		case 4:
			break;
		case 5:
			break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: "+ input);
		}
	}
	
	public void AddNewCrime() {	
		
		Scanner sc = new Scanner(System.in);
		System.out.println("==========================");
		System.out.println("|  CRIME REGISTRATION!!  |");
		System.out.println("==========================");
		System.out.println("Enter Crime ID: ");
		int crime_id = sc.nextInt();
		System.out.println("Enter Crime Date(DD-MM-YYYY) :");
		String s_date = sc.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date=null;
		try {
			date = dateFormat.parse(s_date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Enter Short Description:");
		String s_desc = sc.next();
		System.out.println("Enter Detailed Description: ");
		String d_desc = sc.next();
		System.out.println("Enter Area of Crime:");
		String areaOfCrime = sc.next();
		System.out.println("Enter Police Station:");
		String ps = sc.next();
		System.out.println("Enter Victim Name:");
		String v_name = sc.next();
		System.out.println("Enter Victim Age:");
		int v_age = sc.nextInt();
		System.out.println("Enter Victim Gender:");
		String v_gender = sc.next();
		System.out.println("Enter Victim Mobile Number:");
		int phone_no = sc.nextInt();
		System.out.println("Enter Victim Address:");
		String v_address = sc.next();
		
		
		Crime crime = new Crime(crime_id, date, s_desc, d_desc, areaOfCrime, ps, v_name, v_age, v_gender, phone_no, v_address);
		
		crimeDao new_crime = new crimeDaoImpl();
		try {
			new_crime.addNewCrime(crime);
		}catch(CrimeException e){
			
			
		}
		
		
		
	}
}
