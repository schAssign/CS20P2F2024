/* 

Program: MetricConversion.java              Date: October 15th 2024

Purpose: Create a MetricConversion application that displays a menu of conversion choices and then prompts the user to choose a conversion. Conversion choices should include [....] and vice versa. The application should include seperate methods for doing each of the conversions.

Author: Stefan S
School: CHHS
Course: CS20

*/


package mastery;

import java.util.Scanner;

public class MetricConversion {

	public static void inchesToCentimetres (double numberToConvert) 
	{
		System.out.println(numberToConvert + " inches equals " + (numberToConvert * 2.54) + " centimetres.");
	}
	
	public static void feetToCentimetres (double numberToConvert) 
	{
		System.out.println(numberToConvert + " feet equals " + (numberToConvert * 30) + " centimetres.");
	}
	
	public static void yardsToMetres (double numberToConvert) 
	{
		System.out.println(numberToConvert + " yards equals " + (numberToConvert * 0.91) + " metres.");
	}
	
	public static void milesToKilometres (double numberToConvert) 
	{
		System.out.println(numberToConvert + " miles equals " + (numberToConvert * 1.6) + " kilometres.");
	}
	
	public static void centimetresToInches (double numberToConvert) 
	{
		System.out.println(numberToConvert + " centimetres equals " + (numberToConvert / 2.54) + " inches.");
	}
	
	public static void centimetresToFeet (double numberToConvert) 
	{
		System.out.println(numberToConvert + " centimetres equals " + (numberToConvert / 30) + " feet.");
	}
	
	public static void metresToYards (double numberToConvert) 
	{
		System.out.println(numberToConvert + " metres equals " + (numberToConvert / 0.91) + " yards.");
	}
	
	public static void kilometresToMiles (double numberToConvert) 
	{
		System.out.println(numberToConvert + " kilometres equals " + (numberToConvert / 1.6) + " miles.");
	}
	
	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in); // preparing for user input
		
		System.out.print("Please input a number: "); // this will be the initial number which we convert to another unit
		double userNumber = userInput.nextDouble();
		
		System.out.println("\nConvert:\n" // the types of possible conversions. 
				+ "1. Inches to Centimetres\t5. Centimetres to Inches\n"
				+ "2. Feet to Centimetres\t\t6. Centimetres to Feet\n"
				+ "3. Yards to Metres\t\t7. Metres to Yards\n"
				+ "4. Miles to Kilometres\t\t8. Kilometres to Miles\n");
		
		System.out.print("Enter your choice: "); // the user determines which conversion they want. Their choice is handled by the switch statement below:
		int conversionMethod = userInput.nextInt();
		
		System.out.println(""); // blank line for formatting clarity.
		
		switch (conversionMethod) {
		case 1: inchesToCentimetres(userNumber); break;
		case 2: feetToCentimetres(userNumber); break;
		case 3: yardsToMetres(userNumber); break;
		case 4: milesToKilometres(userNumber); break;
		case 5: centimetresToInches(userNumber); break;
		case 6: centimetresToFeet(userNumber); break;
		case 7: metresToYards(userNumber); break;
		case 8: kilometresToMiles(userNumber); break;
		default: System.out.println("Couldn't determine which conversion to use!"); break;
		}

	}

}

/* Screen Dump

Test Case 1:

	Please input a number: 1
	
	Convert:
	1. Inches to Centimetres	5. Centimetres to Inches
	2. Feet to Centimetres		6. Centimetres to Feet
	3. Yards to Metres		7. Metres to Yards
	4. Miles to Kilometres		8. Kilometres to Miles

	Enter your choice: 4

	1.0 miles equals 1.6 kilometres.

Test Case 2:

	Please input a number: 1.6

	Convert:
	1. Inches to Centimetres	5. Centimetres to Inches
	2. Feet to Centimetres		6. Centimetres to Feet
	3. Yards to Metres		7. Metres to Yards
	4. Miles to Kilometres		8. Kilometres to Miles

	Enter your choice: 8

	1.6 kilometres equals 1.0 miles.


*/
