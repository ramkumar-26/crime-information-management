package com.crimetime.usecases;


import java.io.IOException;
import java.util.Scanner;
import com.crimetime.dao.PoliceUserDao;
import com.crimetime.dao.PoliceUserDaoImpl;
import com.crimetime.exception.PoliceException;
import com.crimetime.model.Police;

public class PoliceFunctions {
	
	UserInputMenu menu_options = new UserInputMenu();
	CrimeUsecases crime = new CrimeUsecases();
	MainApp main = new MainApp();
	
	//police Login
	public void  policeLogin() throws PoliceException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter PoliceID:");
		int police_id = sc.nextInt();
		System.out.println("Enter Password:");
		String password = sc.next();
		
		PoliceUserDao dao = new PoliceUserDaoImpl();
		try {
		boolean res = dao.policeLogin(police_id, password);
		if(res) {
			System.out.println("Login Successful!");
			menu_options.displayMenuAfterLogin();
			MainApp.homePageInput();
			
		 }
		}catch(PoliceException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}
	
	//add police
	public  void registerNewPoliceUser() throws PoliceException, IOException {
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
		
		PoliceUserDao dao = new PoliceUserDaoImpl();
		try {
			int res = dao.addPolice(p);
			if(res==0) {
				sc.close();
				throw new PoliceException("Insertion Failed!");
			}else {
				System.out.println("Police Record Added!");
			}
		} catch (PoliceException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		MainApp.homePageInput();
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
		    main.inputAfterLogin();
		}else if(input==2) {
			System.out.println("Logged Out!");
			System.out.println();
			menu_options.displayMainMenu();
			MainApp.homePageInput();
		}else {
			System.out.println("Wrong Input! Choose Again.");
			backToMainMenuOrLogout();
			
		}
		sc.close();
	}
	
	
}
