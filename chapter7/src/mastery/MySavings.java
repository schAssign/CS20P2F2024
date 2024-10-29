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
