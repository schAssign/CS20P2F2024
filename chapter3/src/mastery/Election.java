/* 

Program: Election.java              Date: September 25th, 2024

Purpose: Write a program that prompts the user for election results, and displays an output similar to: <output>

Author: Stefan S
School: CHHS
Course: Computer Science 20

*/

package mastery;

import java.util.Scanner; import java.text.DecimalFormat;

public class Election {

	public static void main(String[] args) {
		
		// declaration zone
		int votesForAwbrey = 0;
		int votesForMartinez = 0;
		double totalVotes;
		
		// preparing for user input
		Scanner userInput = new Scanner(System.in);
		
		// open up a for loop. "I" is equal to the amount of states in which people voted.
		for (int i = 0; i < 3; i++) {
			
			// use a switch case statement to name the states where people voted minus 1
			switch(i) {
				case 0: System.out.println("Election Results for New York: ");
						break;
				case 1: System.out.println("Election Results for New Jersey: ");
						break;
				case 2: System.out.println("Election results for Connecticut: ");
						break;
				default: break;
				
			}
			
			// user's input for the results of the candidate in a given state
			System.out.print("Awbrey: \t");
			votesForAwbrey += userInput.nextInt();
			
			System.out.print("Martinez: \t");
			votesForMartinez += userInput.nextInt();
			
			System.out.println(" "); // blank line for clarity
			
		}
		
		// we need the total votes to calculate percentages later. I'm going to calculate the percentages within the print lines to avoid using unnecessary variables. It's not like we'll have to refrence the percentage later.
		totalVotes = (double)votesForAwbrey + (double)votesForMartinez;
		
		// Preparing to format our final percentages (we do it the same here as in project.java)
		DecimalFormat roundNumber = new DecimalFormat("0.00");
		
		System.out.println("Candidate\tVotes\tPercentage");
		System.out.println("Awbrey\t\t" + votesForAwbrey + "\t" + roundNumber.format( (votesForAwbrey / totalVotes) * 100 ) + "%"); // double tab here to match the top line. The word "candidate" is too long and takes up 2 tab spaces.
		System.out.println("Martinez\t" + votesForMartinez + "\t" + roundNumber.format( (votesForMartinez / totalVotes) * 100 ) + "%");
		System.out.println("TOTAL VOTES: \t" + (int)totalVotes);
		
		// what i've found, in terms of formatting the output, is that no option is perfect. Using a bunch of \t new tabs, if any bit of text becomes too long then It'll mess up the formatting. If I used printf(), then it only formats correctly when the user is using a monospace font (which i cannot guarantee.)
		
	}

}

/* Screen Dump

Test Case 1:

	Election Results for New York: 
	Awbrey: 	314159
	Martinez: 	271860
 
	Election Results for New Jersey: 
	Awbrey: 	89008
	Martinez: 	121032
 
	Election results for Connecticut: 
	Awbrey: 	213451
	Martinez: 	231034
 
	Candidate	Votes	Percentage
	Awbrey		616618	49.71%
	Martinez	623926	50.29%
	TOTAL VOTES: 	1240544

*/
