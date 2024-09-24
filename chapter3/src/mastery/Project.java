/* 

Program: Project.java              Date: September 19th 2024

Purpose: Create a Project application to help analyze the time taken for a Java project. The application should prompt you for the time spent designing, coding, debugging, and testing, and then displays a table showing you the percentage of time taken for each part.

Author: Stefan S
School: CHHS
Course: Computer Science 20S

*/

package mastery;

import java.text.DecimalFormat; import java.util.HashMap; import java.util.Scanner;

public class Project {

	public static void main(String[] args) {
		
		// Declare and assign variables. We use a dictionary here, in order to avoid repetition later on in the program.
		HashMap<String, Double> timeSpent = new HashMap<String, Double>();
		timeSpent.put("designing", (double)1);
		timeSpent.put("coding", (double)1);
		timeSpent.put("debugging", (double)1);
		timeSpent.put("testing", (double)1);
		
		// Preparing for user input
		Scanner userInput = new Scanner(System.in);
		
		for (String i : timeSpent.keySet()) {
			System.out.print("How much time did you spend " + i + "? "); timeSpent.put(i, (double) userInput.nextInt());
		}
		
		// Getting the sum of values.
		double sumOfTimeSpent = timeSpent.values().stream().mapToDouble(Double::doubleValue).sum(); // I'm going to be honest; I don't entirely know what this does. But it returns the sum of our dictionary, and that's what we need.
		
		// Preparing to format our final values
		DecimalFormat roundNumber = new DecimalFormat("0");
		
		for (String i : timeSpent.keySet()) { // in this For loop, the I variable is equal to the key of the hashMap (i.e. "designing", "coding", etc). We loop through every key in the Dictionary. We then get their respective value and print it all together in one big concatenated line.
			System.out.println("Share of time spent " + i + ": " + roundNumber.format( ( timeSpent.get(i) / sumOfTimeSpent ) * 100 ) + "%");
		}
		
		// designTime = designTime / sumOfTime;
		// codingTime = codingTime / sumOfTime;
		// debugTime = debugTime / sumOfTime;
		// testingTime = testingTime / sumOfTime;
		
		// System.out.println("Share of time spent designing: " + roundNumber.format(designTime*100) + "%");
		// System.out.println("Share of time spent coding: " + roundNumber.format(codingTime*100) + "%");
		// System.out.println("Share of time spent debugging: " +roundNumber.format(debugTime*100) + "%");
		// System.out.println("Share of time spent testing: " + roundNumber.format(testingTime*100) + "%");
	}

}

/* Screen Dump

(paste code output here)

*/
