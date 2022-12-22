package com.crimetime.usecases;

import java.io.IOException;
import java.util.Scanner;

import com.crimetime.exception.PoliceException;
import com.crimetime.model.Police;

public class MainApp {
	CrimeUsecases crime = new CrimeUsecases();
	
	public static void main(String[] args) throws PoliceException, IOException {
		
		
		System.out.println("Welcome To CrimeTime!"); 
		System.out.println("One place to manage all the Crimes and Criminals!!");
		UserInputMenu menu_options = new UserInputMenu();
		
		menu_options.displayMainMenu();
		homePageInput();
		
	}
		
	
	public static  void homePageInput() throws PoliceException, IOException {
		UserInputMenu menu_options = new UserInputMenu();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any Option:");
		int input = sc.nextInt();
		
		switch(input) {
		case 1:
			PoliceFunctions new_login = new PoliceFunctions();
			new_login.policeLogin();
			break;
		case 2: 
			PoliceFunctions new_data = new PoliceFunctions();
			new_data.registerNewPoliceUser();
			break;
		case 3: 
			System.out.println("Thank You! (Exited)");
			return;
		default:
			System.out.println("Wrong Input");
			menu_options.displayMainMenu();
			homePageInput();
			break;
		}
	}
	
	public void inputAfterLogin() throws IOException, PoliceException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Any Options:");
		int input = sc.nextInt();
		
		switch (input) {
		case 1:
			crime.addNewCrime();
			break;
		case 2:
			
			break;
		case 3: 
			crime.displayAllCrime();
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		case 6:
			
			break;
		case 7:
			crime.displayCrimeDetailsWithCrimeID();
			break;
		case 8:
			SearchFuntions s2 = new SearchFuntions();
			s2.CriminalWithCriminalID();
		    break;
		case 9:
		    crime.GenerateReport();
			break;
		case 10:
			UserInputMenu menu_options = new UserInputMenu();
			System.out.println("Logged Out");
			menu_options.displayMainMenu();
			homePageInput();
			break;
		default:
			System.out.println("Wrong Input");
			inputAfterLogin();
		}
		sc.close();
	}
	
	
}
