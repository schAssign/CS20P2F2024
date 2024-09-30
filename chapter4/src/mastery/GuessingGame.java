/* 

Program: GuessingGame.java              Date: September 30, 2024

Purpose: a) Create the GuessingGame application. b) Write down how the application was tested and any debugging techniques used.

Author: Stefan S
School: CHHS
Course: CS20

*/

package mastery;

import java.lang.Math; import java.util.Scanner;

public class GuessingGame {

	public static void main(String[] args) {
		
		//declaring variables, assigning values
		int minValue = 1;
		int maxValue = 20;
		int randomNum = (int)((maxValue - minValue + 1) * Math.random() + minValue);
		int userGuess;
		
		// preparing for user input
		Scanner userInput = new Scanner(System.in);

		//user input
		System.out.print("Enter a number between " + minValue + " and " + maxValue + ": ");
		
		while (true) {
			
			try {
				userGuess = userInput.nextInt();
				break;
			}
			
			catch (Exception InputMismatchException) {
				System.out.println("InputMismatchException: Please try again with a valid integer.");
				System.exit(0);
			}
			
		}
		
		// print the inputted values. compare.
		System.out.println("User's guess: " + userGuess);
		System.out.println("Computer's number: " + randomNum);
		
		if (userGuess == randomNum) {
			System.out.println("You won!");
		} else {
			System.out.println("Better luck next time.");
		}
		
		// close Scanner
		userInput.close();
		
	}

}

/* Screen Dump

Test Case 1:

	Enter a number between 1 and 20: 13
	User's guess: 13
	Computer's number: 2
	Better luck next time.
	
Test Case 2:

	Enter a number between 1 and 20: test
	InputMismatchException: Please try again with a valid integer.
	
Test Case 3:

	Enter a number between 1 and 20: 11
	User's guess: 11
	Computer's number: 11
	You Won!

*/
