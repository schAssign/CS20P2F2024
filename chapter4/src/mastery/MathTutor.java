/* 

Program: MathTutor.java              Date: September 26th 2024

Purpose: Create a MathTutor application that displays math problems by randomly generating two numbers, 1 through 10 and an operator (*, +, -, /), and then prompts the user for an answer. The application should check the answer, display a message, and the correct answer, if necessary. 

Author: Stefan S
School: CHHS
Course: Computer Science 20

*/

package mastery;

import java.util.Scanner; import java.lang.Math;

public class MathTutor {

	public static void main(String[] args) {
		
		// declaring and assigning variables
		
		int minValue = 1;
		int maxValue = 10;
		
		int firstNumber = (int)((maxValue - minValue + 1) * Math.random() + minValue);
		int secondNumber = (int)((maxValue - minValue + 1) * Math.random() + minValue);
		
		int operator;
		int solution;
		int userAnswer;
		
		// deciding which operator to use as part of the equation, then doing the equation
		operator = (int)((4 - 1 + 1) * Math.random() + 1);
		
		switch(operator) {
			case 1: solution = firstNumber + secondNumber; //addition
			System.out.print("What is " + firstNumber + " + " + secondNumber + "? "); // I'm sure I could do something fancy using `printf()` to avoid putting the print statement within the switch case statement, but I don't have the time :(
			break;
			
			case 2: solution = firstNumber * secondNumber; //multiplication
			System.out.print("What is " + firstNumber + " * " + secondNumber + "? ");
			break;
			
			case 3: solution = firstNumber - secondNumber; //subtraction
			System.out.print("What is " + firstNumber + " - " + secondNumber + "? ");
			break;
			
			case 4: solution = firstNumber / secondNumber; //division
			System.out.print("What is the result of " + firstNumber + " / " + secondNumber + "? (Ignore the remainder.) ");
			break;
			
			default: 
			System.out.print("Assigned the `operator` variable a value outside of the allowed range!");
			throw new IllegalArgumentException();
		}
		
		// preparing for user input
		Scanner userInput = new Scanner(System.in);
		
		while (true) { // check the user's attempted answer against the solution
			try {
				userAnswer = userInput.nextInt();
				break;
				
			} catch(Exception InputMismatchException) {
				System.out.println("InputMismatchException: Please try again with a valid integer.");
				System.exit(0);
			}
		}
		
		if (userAnswer == solution) {
			System.out.println("Congrats! You found the solution.");
		} else {
			System.out.print("Good try. The answer is " + solution);
		}
		

	}

}

/* Screen Dump

Test Case 1:

	What is 3 * 9? 27
	Congrats! You found the solution.
	
Test Case 2: // confirming that we're doing integer division, rather than real division. this information is conveyed to the user.

	What is the result of 7 / 4? (Ignore the remainder.) 1
	Congrats! You found the solution.

Test case 3: // wrong data type test

	What is 8 + 2? 8.5
	InputMismatchException: Please try again with a valid integer.

Test case 4: // wrong answer test

	What is the result of 2 / 3? (Ignore the remainder.) 5
	Good try. The answer is 0

*/
