/* 

Program: Project.java              Date: September 19th 2024

Purpose: Create a Project application to help analyze the time taken for a Java project. The application should prompt you for the time spent designing, coding, debugging, and testing, and then displays a table showing you the percentage of time taken for each part.

Author: Stefan S
School: CHHS
Course: Computer Science 20S

*/

package mastery;

import java.text.DecimalFormat; import java.util.LinkedHashMap; import java.util.Scanner; // a LinkedHashMap is a HashMap with the insertion order preserved. A HashMap is a type of Dictionary.

public class Project {

	public static void main(String[] args) {
		
		// Declare and assign variables. We use a dictionary here, in order to avoid repetition later on in the program.
		LinkedHashMap<String, Double> timeSpent = new LinkedHashMap<String, Double>();
		timeSpent.put("designing", (double)1);
		timeSpent.put("coding", (double)1);
		timeSpent.put("debugging", (double)1);
		timeSpent.put("testing", (double)1);
		
		// Preparing for user input
		Scanner userInput = new Scanner(System.in);
		
		// Gathering user input for each thing time was spent on
		for (String i : timeSpent.keySet()) {
			
			// try-catch loop to deal with users who input characters rather than doubles
			while(true) {
				try {
					System.out.print("How much time did you spend " + i + "? "); timeSpent.put(i, (double) userInput.nextDouble());
					break;
				}
				catch(Exception InputMismatchException) { // when the user input is not a valid double
					System.out.println("InputMismatchException: Please try again with a valid decimal number.");
					System.exit(0); // exit the program when an exception is thrown because it's the easiest thing to do.
				}
			}
		}
		
		System.out.println(""); // blank space for readability
		
		// Getting the sum of values.
		double sumOfTimeSpent = timeSpent.values().stream().mapToDouble(Double::doubleValue).sum(); // I'm going to be honest; I don't entirely know what this does. But it returns the sum of our dictionary, and that's what we need.
		
		// Preparing to format our final values
		DecimalFormat roundNumber = new DecimalFormat("0");
		
		// in this For loop, the I variable is equal to the key of the hashMap (i.e. "designing", "coding", etc). We loop through every key in the Dictionary. We then get their respective value and print it all together in one big concatenated line.
		for (String i : timeSpent.keySet()) { 
			System.out.println("Share of time spent " + i + ": " + roundNumber.format( ( timeSpent.get(i) / sumOfTimeSpent ) * 100 ) + "%");
		}
		
	}

}

/* Screen Dump

Test Case 1:

	How much time did you spend designing? 15
	How much time did you spend coding? 25
	How much time did you spend debugging? 35
	How much time did you spend testing? 45

	Share of time spent designing: 12%
	Share of time spent coding: 21%
	Share of time spent debugging: 29%
	Share of time spent testing: 38%

Test Case 2:

	How much time did you spend designing? 1.5
	How much time did you spend coding? 2.5
	How much time did you spend debugging? 3.5
	How much time did you spend testing? 4.5

	Share of time spent designing: 12%
	Share of time spent coding: 21%
	Share of time spent debugging: 29%
	Share of time spent testing: 38%

Test Case 3: // this is the desired result. The user knows what they're doing when they put "0" into all of the inputs. I only care that it doesn't throw a runtime error.

	How much time did you spend designing? 0
	How much time did you spend coding? 0
	How much time did you spend debugging? 0
	How much time did you spend testing? 0

	Share of time spent designing: NaN%
	Share of time spent coding: NaN%
	Share of time spent debugging: NaN%
	Share of time spent testing: NaN%
	
Test Case 4:

	How much time did you spend designing? 1232
	How much time did you spend coding? 534
	How much time did you spend debugging? string or character
	InputMismatchException: Please try again with a valid decimal number.

*/
