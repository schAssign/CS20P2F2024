/* 

Program: MySavings.java, PiggyBank.java              Date:November 5th 2024

Purpose: Create a MySavings application that displays a menu of choices for entering pennies, nickels, dimes, and quarters into a piggy bank and then prompts the user ot make a selection. The mysavings application should include a piggybank object that can add coins to the piggy bank, remove coins, and return the total amount in the bank.

Author: Stefan S
School: CHHS
Course: CS20

*/

package mastery;

import java.util.Scanner;

public class MySavings {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		PiggyBank myBank = new PiggyBank(); // initializing out object
		
		int userChoice = 10; // arbitrary value in order to start the while loop.
		
		while (userChoice != 0) {
			
			System.out.println("1. Show total in bank\n"
					+ "2. Add a penny.\n"
					+ "3. Add a nickel.\n"
					+ "4. Add a dime.\n"
					+ "5. Add a quarter.\n"
					+ "6. Take money out of the bank.\n"
					+ "Enter 0 to quit.");
			
			System.out.print("Your Choice: ");
			userChoice = userInput.nextInt();
			
			switch (userChoice) { // do things based on user input
			case 0: break;
			case 1: System.out.println(myBank.toString()); break;
			case 2: myBank.addPenny(); break;
			case 3: myBank.addNickel(); break;
			case 4: myBank.addDime(); break;
			case 5: myBank.addQuarter(); break;
			case 6: myBank.emptyBank(); break;
			default: System.out.println("Inputted value could not be mapped to an option!"); break;			
			}
			
			System.out.println(""); // blank line for readability

		}

	}
}

/* Screen Dump

Test case:

	1. Show total in bank
	2. Add a penny.
	3. Add a nickel.
	4. Add a dime.
	5. Add a quarter.
	6. Take money out of the bank.
	Enter 0 to quit.
	Your Choice: 2
	
	1. Show total in bank
	2. Add a penny.
	3. Add a nickel.
	4. Add a dime.
	5. Add a quarter.
	6. Take money out of the bank.
	Enter 0 to quit.
	Your Choice: 1
	The piggybank has 1 penny, 0 nickels, 0 dimes, 0 quarters, and is worth 1 cents.
	
	1. Show total in bank
	2. Add a penny.
	3. Add a nickel.
	4. Add a dime.
	5. Add a quarter.
	6. Take money out of the bank.
	Enter 0 to quit.
	Your Choice: 0
	
*/
