/* 

Program: Digits2.java              Date: September 17th, 2024

Purpose: Modify the Digits application created in a review earlier in this chapter to show the hudreds-place digit of a three digit number. 

Author: Stefan S
School: CHHS
Course: Computer Science 20

*/

package mastery;

import java.util.Scanner;

public class Digits2 {

	public static void main(String[] args) {
		
		// Declaration area
		int threeDigitNumber;
		int onesDigit, tensDigit, hundredsDigit;
		
		// preparing for user input
		Scanner userInput = new Scanner(System.in);
		
		// getting user input
		System.out.print("Please input a 3 digit integer: ");
		threeDigitNumber = userInput.nextInt();
		
		// we don't need any user input beyond this
		userInput.close();
		
		// we calculate from the highest digit to the lowest digit. We can use the previous digit calculated to help with the next one.
		
		// This equation would be the basis of finding any digit greater than 1. If you want to find the thousands place, for example, you'd replace both "100"s here with "1000"
		hundredsDigit = (threeDigitNumber - (threeDigitNumber % 100) ) / 100;
		System.out.println("Hundreds: " + hundredsDigit);
		
		// to get the tens digit from a 2 digit number, we first take our number. We then subtract it by the remainder of dividing itself by 10. Then we divide the whole result by 10.
		// In order to get the tens digit from a *three* digit number, we have to then use that result and subtract the digit in the hundreds place.
		// I'm sure that there's an elegant way to procedurally generate equations to get each digit of whatever number you want, but that would take me a week (which I don't have). So for now, this program is limited to 3 digits.
		tensDigit = ((threeDigitNumber - (threeDigitNumber % 10) ) / 10) - (hundredsDigit * 10); 
		System.out.println("Tens: " + tensDigit);
		
		// The ones digit is the same regardless of the size of the number. You take the remainder of dividing it by 10.
		onesDigit = threeDigitNumber % 10;
		System.out.println("Ones: " + onesDigit);
		

	}

}

/* Screen Dump

Please input a 3 digit integer: 123
Hundreds: 1
Tens: 2
Ones: 3

*/
