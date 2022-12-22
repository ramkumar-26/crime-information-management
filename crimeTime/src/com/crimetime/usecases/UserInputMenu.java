package com.crimetime.usecases;

public class UserInputMenu {
	public  void displayMainMenu() {
		System.out.println("========================================");
		System.out.println("|	          CrimeTime		           |");
		System.out.println("========================================");
		System.out.println("|  1.Police Inspector Login            |");
		System.out.println("|  2.New Inspector? Register!          |");
		System.out.println("|  3.Exit                              |");
		System.out.println("========================================");
	}
	
	public void displayMenuAfterLogin() {
		System.out.println("========================================");
		System.out.println("| 1. Register a New Crime              |");
		System.out.println("| 2. Register a new Criminal           |");
		System.out.println("| 3. Display All Crime                 |");
		System.out.println("| 4. Display All Criminal              |");
		System.out.println("| 5. Link  Criminal with  Crime        |");
		System.out.println("| 6. Update a Crime Status             |");
		System.out.println("| 7. Search Crime With Crime ID        |");
		System.out.println("| 8. Seacrh Criminal with Criminal ID  |");
		System.out.println("| 9. Generate Report                   |");
		System.out.println("|10. Logout                            |");
		System.out.println("========================================");
	}
	
	
}
