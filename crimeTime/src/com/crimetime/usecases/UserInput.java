package com.crimetime.usecases;

import java.io.IOException;
import java.util.Scanner;

import com.crimetime.exception.PoliceException;

public class UserInput {
	UserInputMenu menu_options = new UserInputMenu();
	CrimeUsecases crime = new CrimeUsecases();
	CriminalUsecases criminal = new CriminalUsecases();
	
	public   void homePageInput() throws PoliceException, IOException {
		UserInputMenu menu_options = new UserInputMenu();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any Option:");
		int input = sc.nextInt();
		
		switch(input) {
		case 1:
			PoliceUserUsecases new_login = new PoliceUserUsecases();
			new_login.policeLogin();
			break;
		case 2: 
			PoliceUserUsecases new_data = new PoliceUserUsecases();
			new_data.registerNewPoliceUser();
			break;
		case 3: 
			System.out.println("Thank You! (Exited)");
			sc.close();
			return;
		default:
			System.out.println("Wrong Input");
			menu_options.displayMainMenu();
			homePageInput();
			break;
		}
		sc.close();
	}
	
	public  void inputAfterLogin() throws IOException, PoliceException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Any Options:");
		int input = sc.nextInt();
		
		switch (input) {
		case 1:
			crime.addNewCrime();
			break;
		case 2:
			criminal.addNewCriminal();
			break;
		case 3: 
			crime.displayAllCrime();
			break;
		case 4:
			criminal.displayAllCriminal();
			break;
		case 5:
			crime.linkCriminalWithCrime();
			break;
		case 6:
			
			break;
		case 7:
			crime.searchCrimeDetailsWithCrimeID();
			break;
		case 8:
			
			criminal.searchCriminalWithCriminalID();
		    break;
		case 9:
		    crime.GenerateReport();
			break;
		case 10:
			System.out.println("Logged Out");
			menu_options.displayMainMenu();
			homePageInput();
			break;
		default:
			System.err.println("Wrong Input");
			inputAfterLogin();
		}
		sc.close();
	}
	
	
	//option to logout or previous  menu
		public void backToMainMenuOrLogout() throws PoliceException, IOException {
			Scanner sc = new Scanner(System.in);
			System.out.println("--------------------------------");
			System.out.println("|Press 1 to back to main menu! |");
			System.out.println("|Press 2 to logout!            |");
			System.out.println("--------------------------------");
			int input = sc.nextInt();
			
			if(input==1) {
				System.out.println();
			    menu_options.displayMenuAfterLogin();
			    inputAfterLogin();
			}else if(input==2) {
				System.out.println("Logged Out!");
				System.out.println();
				menu_options.displayMainMenu();
				homePageInput();
			}else {
				System.err.println("Wrong Input! Choose Again.");
				backToMainMenuOrLogout();
				
			}
			sc.close();
		}
	
	
}
