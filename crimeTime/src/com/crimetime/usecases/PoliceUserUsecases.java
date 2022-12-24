package com.crimetime.usecases;


import java.io.IOException;
import java.util.Scanner;
import com.crimetime.dao.PoliceUserDao;
import com.crimetime.dao.PoliceUserDaoImpl;
import com.crimetime.exception.PoliceException;
import com.crimetime.model.Police;

public class PoliceUserUsecases {
	
	UserInput input = new UserInput();
	UserInputMenu menu_options = new UserInputMenu();
	CrimeUsecases crime = new CrimeUsecases();
	
	
	//police Login
	public void  policeUserLogin() throws PoliceException, IOException {
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
			input.homePageInput();
			
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
			int res = dao.registerNewPolice(p);
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
		
		
		input.homePageInput();
		sc.close();
	}
	
	
	
	
}
