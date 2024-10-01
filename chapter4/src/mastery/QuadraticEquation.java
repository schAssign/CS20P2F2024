/* 

Program: QuadraticEquation.java              Date: September 30 2024

Purpose: Create a QuadraticEquation application that gives the solution to any quadratic equation. The application should prompt the user for values a, b, and c, and then display the roots, if any.

Author: Stefan S
School: CHHS
Course: CS20

*/

package mastery;

import java.util.Scanner; import java.lang.Math;

public class QuadraticEquation {

	public static void main(String[] args) {
		
		//preparing for user input
		Scanner userInput = new Scanner(System.in);
		
		// declaration zone
		double quadratic_A;
		double quadratic_B;
		double quadratic_C;
		double rootPositive;
		double rootNegative;
		
		// user input
		
		while (true) { // try-except loop
			
			try {
				System.out.print("Enter value for a: ");
				quadratic_A = userInput.nextDouble();
				
				System.out.print("Enter value for b: ");
				quadratic_B = userInput.nextDouble();
				
				System.out.print("Enter value for c: ");
				quadratic_C = userInput.nextDouble();
				
				break;
			} 
			catch(Exception InputMismatchException) { // if any user-inputted value is not a double
				System.out.println("InputMismatchException: Please try again with a valid integer.");
				System.exit(0);
			}

		}
		
		// doing the quadratic equation with a plus, and a minus. Storing these seperately. We could also do the equations directly in the `println` if we were super concerned with memory usage.
		rootPositive = ( ( (quadratic_B * -1) + Math.sqrt( Math.pow(quadratic_B, 2)-(4 * quadratic_A * quadratic_C) ) ) / (2 * quadratic_A) );
		rootNegative = ( ( (quadratic_B * -1) - Math.sqrt( Math.pow(quadratic_B, 2)-(4 * quadratic_A * quadratic_C) ) ) / (2 * quadratic_A) );
		
		System.out.println("The roots are " + rootPositive + " and " + rootNegative);
		
	
		
	}

}

/* Screen Dump

Test Case 1:

	Enter value for a: 1
	Enter value for b: -3
	Enter value for c: -4
	The roots are 4.0 and -1.0
	
Test Case 2:

	Enter value for a: 1
	Enter value for b: text
	InputMismatchException: Please try again with a valid integer.

*/