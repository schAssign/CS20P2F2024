/* 

Program: PrimeNumber_A.java              Date: October 3rd, 2024

Purpose: Create a PrimeNumber application that prompts the user for a number and then displays a message indicating whether the number is prime or not.

Author: Stefan S
School: CHHS
Course: CS20

*/

package mastery;

import java.util.Scanner;

public class PrimeNumber_A {

	public static void main(String[] args) 
	{
		
		// declare variables and assign values
		boolean isPrimeNumber = true;
		int numberToCheck = 0;
		
		// preparing for user input
		Scanner userInput = new Scanner (System.in);
		
		System.out.print("Please input an integer: ");
		
		// try-except loop for the user's input
		while(true) 
		{
			try 
			{
				numberToCheck = userInput.nextInt();
				break;
			}
			catch(Exception InputMismatchException) 
			{
				System.out.println("InputMismatchException: Please try again with a valid Integer.");
				System.exit(0); // exit the program when an exception is thrown because it's the easiest thing to do.
			}
		}
		
		// "i" in this loop goes from 2 to one below the number inputted by the user. If the remainder of dividing the user inputted number by i is equal to 0, the number is NOT prime.
		for (int i = 2; i < numberToCheck; i++) 
		{
			if (numberToCheck % i == 0)
			{
				isPrimeNumber = false;
				break;
			}
			
		}
		
		System.out.print(numberToCheck + " is a prime number: " + isPrimeNumber);

		userInput.close();
		
	}

}

/* Screen Dump

Test Case 1:
	Please input an integer: 7
	7 is a prime number: true
	
Test Case 2:
	Please input an integer: 9
	9 is a prime number: false
	
Test Case 3:
	Please input an integer: test
	InputMismatchException: Please try again with a valid Integer

*/
