package com.convert_Number_To_Romanji;

import java.util.Scanner;

public class Main {

	
	public static void main( String args[] )
	{
		

		System.out.println("Welcome to the romanji number converter.");
		System.out.println("Nihongo no bango henkan e yokoso!");
		
		
		boolean programDone = false;//initializes boolean operator to keep the program running as long as the user wants to use it.

		/*
		 * The following loop is used to check the input from the user.
		 * If the user enters an integer the program will convert the number to Romanji.
		 * If the user enters "quit" the program will exit. 
		 * If the input is neither a number (integer) nor quit, the program will prompt the user to enter their input again.
		 */	

		while(!programDone){
			
			try { // Try/Catch used to ensure the input is an integer
			
				System.out.println("Please enter a number between 1 and 9999. Enter 'Q' or 'q' to exit the program. -> ");
				System.out.print("Number to Convert: ");
				Scanner in = new Scanner(System.in);//Creates variable in to accept input from the user
				String input = in.nextLine(); // Parses input from the user and casts it to a string
						
						
				//checks to see if the input was 'Q' or 'q'. If that is true the program exits.
				if ((input.equals('Q')) || (input.equals("q"))){
					
					System.out.println("Thank you for using the romanji number converter.");
					programDone = true;// sets the programDone while loop variable to true. ends the while loop.
					System.exit(0);/* exits the program Note: This is redundant and can be moved. 
						        * Possible to use break to break the loop instead and system.exit after the while loop. 
						        * Or just use the programDone variable and system.exit after the loop.
							*/ 
				} else { 						
				
					/* 
					 * Tries to convert the string input to an integer
					 * If the input converts, the romanji converter method is executed
					 * If there is an exception it is caught below and the user is prompted to enter a valid input.
					 */
					int inputNumber = Integer.parseInt(input);// converts the string input (input) to an integer (inputNumber)
					
					// Checks to see if the number is less than or equal to zero.
					if(inputNumber < 0 ) { 
							
						System.out.println("The number is less than zero! Suuchi ga zero yori chiisai, desu yo!");
							
					} else if (inputNumber == 0){
							
						System.out.println("The Romanji version of your number is: zero or rei.");
							
					} else {
								
						romanjiConverter rConvert = new romanjiConverter();// Constructs romanjiConverter Class
						rConvert.numberConvert(inputNumber); // Calls romanjiBuilder to convert the inputNumber to a romanjiNumber
							
					}
						
				} 
					
			} catch(NumberFormatException nfe){// If the input is not an integer the following Error message is displayed.
					
					//Display Error message
					System.out.println("Error: Poka-Yoke Detected!!! Sorry, but this was not a valid input.");
					
			} // end of Catch
			
		}//End of While loop
		
	}// End of Main-Method
	
}// end of Main-Class
	
	
