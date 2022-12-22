package com.crimetime.usecases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.crimetime.dao.crimeDao;
import com.crimetime.dao.crimeDaoImpl;
import com.crimetime.exception.CrimeException;
import com.crimetime.exception.PoliceException;
import com.crimetime.model.Crime;

public class CrimeUsecases {
	PoliceFunctions police_object = new PoliceFunctions(); 
	UserInputMenu menu_options = new UserInputMenu();
	
	public void AddNewCrime() throws IOException, PoliceException {	
		
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
		
		crimeDao new_crime = new crimeDaoImpl();
		try {
			new_crime.addNewCrime(crime);
			
			//display back the menu
			menu_options.DisplayPoliceMenu();
		    police_object.inputAfterLogin();
		}catch(CrimeException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
	}
}
