/* 

Program: PrimeNumber.java              Date: October 16th, 2024

Purpose: Modify the PrimeNumenr application created in Chapter 5 Exercise 1 to include a method names IsPrime(). The IsPrime() method should require one parameter and return a Boolean value.

Author: Stefan S
School: CHHS
Course: CS20

*/
package mastery;

import java.util.Scanner;

public class PrimeNumber {
	
	public static boolean isPrime(int checkedNumber) 
	{
		// "i" in this loop goes from 2 to one below the number inputted by the user. If the remainder of dividing the user inputted number by i is equal to 0, the number is NOT prime.
		for (int i = 2; i < checkedNumber; i++) 
		{
			if (checkedNumber % i == 0)
			{
				return false;
				
			}
			
		}
		return true;
	}

	public static void main(String[] args) {
			
			// declare variables and assign values
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
		
			System.out.print(numberToCheck + " is a prime number: " + isPrime(numberToCheck));

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
