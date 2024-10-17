/* 

Program: AddCoins.java              Date:October 17th 2024

Purpose: Create an AddCoins application that prompts the user for the number of pennies, nickels, dimes, and quarters, and then displays their total dollar amount.

Author: Stefan S
School: CHHS
Course: CS20

*/

package mastery;

import java.lang.String; import java.text.NumberFormat; import java.util.Scanner;

public class AddCoins {

	public static String getDollarAmount(int quarters, int dimes, int nickels, int pennies) 
	{
		int centValue;
		double dollarValue;
		
		centValue = (quarters*25) + (dimes*10) + (nickels*5) + (pennies*1); // add up coins
		
		dollarValue = (double)centValue / 100; // convert to dollars
		
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(); // preparing to format string
		
		return(currencyFormatter.format(dollarValue)); // formatting our dollar value also converts it to a string, allowing us to return it without typecasting.
	}
	
	
	
	public static int integerInputHandler() 
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
	
	
	
	public static void main(String[] args) 
	{
		int userQuarters, userDimes, userNickels, userPennies;
		
		System.out.println("Enter your total coins: \n");
		
		System.out.print("Quarters: "); // the integerInputHandler method is self explanitory.
		userQuarters = integerInputHandler();
		
		System.out.print("Dimes: ");
		userDimes = integerInputHandler();
		
		System.out.print("Nickels: ");
		userNickels = integerInputHandler();
		
		System.out.print("Pennies: ");
		userPennies = integerInputHandler();
		
		System.out.println("\nTotal: " + getDollarAmount(userQuarters, userDimes, userNickels, userPennies));

	}

}

/* Screen Dump

Test Case 1:

	Enter your total coins: 

	Quarters: 20
	Dimes: 10
	Nickels: 20
	Pennies: 10

	Total: $7.10
	
Test Case 2:

	Enter your total coins: 

	Quarters: 20
	Dimes: test
	InputMismatchException! Try again...
	oof
	InputMismatchException! Try again...
	10
	Nickels: 20
	Pennies: 10

	Total: $7.10
	
Test Case 3:

	Enter your total coins: 

	Quarters: 20
	Dimes: 10
	Nickels: test
	InputMismatchException! Try again...
	test again
	InputMismatchException! Try again...
	test again
	InputMismatchException! Max number of tries reached, ignoring value...
	Pennies: 10

	Total: $6.10


*/
