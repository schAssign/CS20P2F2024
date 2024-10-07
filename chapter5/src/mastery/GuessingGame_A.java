/* 

Program: GuessingGame_A.java              Date: October 7th 2024

Purpose: Modify the GuessingGame application as follows: A) Modify the algorithm to allow for as many guesses as needed.

Author: Stefan S
School: CHHS
Course: CS20

*/

package mastery;

import java.lang.Math; import java.util.Scanner;

public class GuessingGame_A {

	public static void main(String[] args) {
		
		//declaring variables, assigning values
		int minValue = 1;
		int maxValue = 20;
		int randomNum = (int)((maxValue - minValue + 1) * Math.random() + minValue);
		int userGuess;
		
		// preparing for user input
		Scanner userInput = new Scanner(System.in);
				
		while(true) // keeps looping until the user inputs the correct number
		{
			while (true) { // try/except to handle errors.
				try {
					System.out.print("Enter a number between " + minValue + " and " + maxValue + ": ");
					userGuess = userInput.nextInt();
					break;
				}
				catch (Exception InputMismatchException) { // if the inputted value is not an integer
					System.out.println("InputMismatchException: Please try again with a valid integer.");
					System.exit(0);
				}
				}
			
			if (userGuess == randomNum) 
			{
				break;
			}
			else // keep trying if they guess wrong
			{
				System.out.println("Try again!");
			}
			
		}
				
		System.out.println("You won!");

		// close Scanner
		userInput.close();

	}

}

/* Screen Dump

Test Case 1:
	Enter a number between 1 and 20: 1
	Try again!
	Enter a number between 1 and 20: 2
	Try again!
	Enter a number between 1 and 20: 3
	Try again!
	Enter a number between 1 and 20: 4
	Try again!
	Enter a number between 1 and 20: 5
	Try again!
	Enter a number between 1 and 20: 6
	Try again!
	Enter a number between 1 and 20: 7
	Try again!
	Enter a number between 1 and 20: 8
	Try again!
	Enter a number between 1 and 20: 9
	Try again!
	Enter a number between 1 and 20: 10
	Try again!
	Enter a number between 1 and 20: 11
	Try again!
	Enter a number between 1 and 20: 12
	Try again!
	Enter a number between 1 and 20: 13
	Try again!
	Enter a number between 1 and 20: 14
	Try again!
	Enter a number between 1 and 20: 15
	Try again!
	Enter a number between 1 and 20: 16
	Try again!
	Enter a number between 1 and 20: 17
	You won!
	
Test Case 2:
	Enter a number between 1 and 20: 1
	Try again!
	Enter a number between 1 and 20: 2
	Try again!
	Enter a number between 1 and 20: test
	InputMismatchException: Please try again with a valid integer.


*/
