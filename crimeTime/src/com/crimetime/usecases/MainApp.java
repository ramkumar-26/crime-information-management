package com.crimetime.usecases;

import java.io.IOException;
import java.util.Scanner;

import com.crimetime.exception.PoliceException;
import com.crimetime.model.Police;

public class MainApp {
	
	
	
	public static void main(String[] args) throws PoliceException, IOException {
		
		
		System.out.println("Welcome To CrimeTime!"); 
		System.out.println("One place to manage all the Crimes and Criminals!!");
		UserInputMenu menu_options = new UserInputMenu();
		
		menu_options.displayMainMenu();
		
		UserInput input = new UserInput();
		input.homePageInput();
		
	}
		
	
	
	
	
	
	
	
	
}
