package mastery;

import java.util.Scanner; 

public class DigitExtractor {
	
	/** 
	 * 	This method prompts the user to input an integer. The main feature of this method is it's error handling capabilities.
	 * 	pre: Scanner must be imported into the file.
	 * 	post: Returns an integer. 
	 *
	 * */ 
	public static int integerInputHandler() // this was copied from an old assignment. it makes things easier.
	{
		Scanner userInput = new Scanner(System.in);
		
		int returnedInteger;
		int maxAttempts = 3;
		int attemptNumber = 0;
		
		while(true) 
		{ // to catch the user, if they input a value which is not an integer
			
			try 
			{
				returnedInteger = userInput.nextInt();
				userInput.nextLine(); // nextLine(), in our case, clears the value stored in userInput. close() does not do this and causes our Scanner to break.
				return returnedInteger;
			}
			
			catch (Exception InputMismatchException)
			{
				attemptNumber++; // increment the amount of failed attempts on an exception
				
				if (attemptNumber == maxAttempts) 
				{
					System.out.println("InputMismatchException! Max number of tries reached, ignoring value...");
					return 0; // if the user keeps repeatedly inputting an incorrect value, give up.
				}
				
				else 
				{
					System.out.println("InputMismatchException! Try again...");
					userInput.nextLine(); // ask the user to try and input their value again
					continue;
				}
				
				
			}
		}
	}

	public static void main(String[] args) {
		Num numberChecker = new Num();
		Scanner userInput = new Scanner(System.in);
		
		int numberToCheck;
		char usersChoice;
		boolean keepLooping = true;
		
		System.out.print("Enter an integer: ");
		numberToCheck = integerInputHandler();
		
		while(keepLooping == true) {
			System.out.print("show (W)hole number.\n" // the menu text.
					+ "show (O)nes place number.\n"
					+ "show (T)ens place number.\n"
					+ "show (H)undreds place number.\n"
					+ "(Q)uit.\n");
			
			System.out.println("Enter your choice: ");
			usersChoice = userInput.next().charAt(0); // user inputs a string, we take the first character. 
			
			switch(Character.toLowerCase(usersChoice)) { // stop looping when (q) is inputted, else, do what the user requests.
			case 'w': System.out.println("The number is: " + numberToCheck); break;
			case 'o': System.out.println("The ones place digit is: " + numberChecker.getDigit(numberToCheck, "ones")); break;
			case 't': System.out.println("The tens place digit is: " + numberChecker.getDigit(numberToCheck, "tens")); break;
			case 'h': System.out.println("The hundreds place digit is: " + numberChecker.getDigit(numberToCheck, "hundreds")); break;
			case 'q': keepLooping = false; break;
			default: System.out.println("choice inputted is not valid! try again..."); break;
			}
			
			System.out.println(); // blank space for readability
			
		}

	}

}
