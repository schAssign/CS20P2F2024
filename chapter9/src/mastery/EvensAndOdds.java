/* 

Program: EvensAndOdds.java              Date: November 18th 2024

Purpose: Create an EvensAndOdds application that generates 25 random integers between 0 and 99 and then displays all the evens on one line and all the odds on the next line.

Author: Stefan S
School: CHHS
Course: CS20

*/

package mastery;

import java.util.ArrayList; import java.lang.Math;

public class EvensAndOdds {

	/**
	 * Generates an array, with each index representing a number within the 2 passed values.
	 * @param min
	 * @param max
	 * @return array
	 */
	public static int[] numbers(int min, int max) 
	{		
		int[] returnedArray = new int[max - min + 1];	// generates an array with an index equal to the distance beetween min-max.
		
		for (int i = 0; i < returnedArray.length; ++i) 
			{ 
			returnedArray[i] = min + i;	// Fill the array with the numbers at, and between, the passed values.
			}
		
		return returnedArray;
	}
	
	/**
	 * Generates an array, with a set amount of random values between `min` and `max`
	 * @param min
	 * @param max
	 * @param numberOfValues
	 * @return array
	 */
	public static int[] numbers(int min, int max, int numberOfValues) 
	{		
		int[] returnedArray = new int[numberOfValues];	// generates an array with the user-specified number of values.
		
		for (int i = 0; i < returnedArray.length; ++i) 
			{ 
			returnedArray[i] = (int) ((max - min + 1) * Math.random() + min);	// Fill the array with random numbers within the user specified values, up to the desired length.
			}
		
		return returnedArray;
	}
	
	
	
	/**
	 * Returns the even numbers and odd numbers of the passed array, as a human readable String with line breaks.
	 * @param passedArray
	 * @return string
	 */
	public static String evensThenOdds(int[] passedArray)	
	{
		// Arraylists can have their length changed dynamically. We use them to store even and odd values as calculated.
		ArrayList<Integer> evenNumbers = new ArrayList<Integer>();
		ArrayList<Integer> oddNumbers = new ArrayList<Integer>();
		
		for (int i = 0; i < passedArray.length; ++i) {
			
			if (passedArray[i] % 2 == 0) 
			{
				evenNumbers.add(passedArray[i]);
			} 
			else 
			{
				oddNumbers.add(passedArray[i]);
			}
		
		}

		return("EVENS:\n" + evenNumbers + "\nODDS:\n" + oddNumbers);
			
	}
	
	
	/**
	 * main method.
	 */
	public static void main(String[] args) 
	{
		System.out.println(evensThenOdds(numbers(1, 99, 25)));
	}
}

/* Screen Dump

EVENS:
[78, 40, 50, 82, 78, 40, 56, 98, 52, 48, 32, 70, 76, 16, 80, 68, 26]
ODDS:
[53, 29, 43, 57, 81, 23, 83, 61]

*/
