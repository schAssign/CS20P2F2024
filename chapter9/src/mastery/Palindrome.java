/* 

Program: Palindrome.java              Date: November 19th 2024

Purpose: Create a Palindrome application that prompts the user for a string and then displays a message indicating whether or not the string is a palindrome. A palindrome is a word or phrase that is spelled the same backwards and forwards. For example, "mom" is a palindrome, as well as "kayak" and "never odd or even"

Author: Stefan S
School: CHHS
Course: CS20

*/

package mastery;

import java.util.Scanner; import java.util.Arrays;

public class Palindrome {
	
	
	
	/**
	 * currently unused.
	 * @return empty string
	 */
	public static String getUserInputString()
	{
		Scanner userInput = new Scanner(System.in);
		String stringToReturn;
		
		try {
			stringToReturn = userInput.nextLine();
		} catch(Exception inputMismatchException) {
			System.out.print("Invalid data type inputted! Returning empty...");
			return"";
		}
		
		return stringToReturn;
	}
	
	
	
	/**
	 * Takes a String, and returns it in all lowercase with only characters `abcdefghijklmnopqrstuvwxyz`
	 * @param inputToFormat
	 * @return sanitized String
	 */
	public static String sanitizeInput(String inputToFormat) 
	{
		inputToFormat = inputToFormat.toLowerCase();	// convert all characters to lowercase, so that we can compare letters regardless of their original case.
		inputToFormat = inputToFormat.replaceAll("[^abcdefghijklmnopqrstuvwxyz]", "");	// regular expression to delete everything but the letters.
		return inputToFormat;
	}
	
	
	
	/**
	 * Returns whether a given string contains a palindrome or not. Case sensitive, please verify that your inputs are correct.
	 * @param stringToCheck
	 * @return
	 */
	public static boolean isPalindrome(String stringToCheck) 
	{
		char[] characterArray = stringToCheck.toCharArray(); // we will compare the character array with itself, reversed. If the two match, we know the given string is a palindrome.
		char[] reverseCharacterArray = new char[stringToCheck.length()];
		
		for (int i = 0; i < stringToCheck.length(); ++i) {
			
			// System.out.println("iteration " + i);
			// System.out.println("writing to index " + (reverseCharacterArray.length - 1 - i));
			// System.out.println("writing character " + stringToCheck.charAt(i));
			
			reverseCharacterArray[reverseCharacterArray.length - 1 - i] = stringToCheck.charAt(i); // iterate through the array backwards, iterate through the string forwards. this results in an "inverted" array.
		}
	
		// System.out.println(Arrays.toString(characterArray) + " " + Arrays.toString(reverseCharacterArray));
		
		return(Arrays.equals(reverseCharacterArray, characterArray)); // `return (characterArray.equals(reverseCharacterArray))` always returns false, which is weird.
		
	}
	
	
	
	/**
	 * main method.
	 */
	public static void main(String[] args) {
		
		System.out.println(isPalindrome(sanitizeInput("Never odd or even")));

	}

}

/* Screen Dump

(paste code output here)

*/