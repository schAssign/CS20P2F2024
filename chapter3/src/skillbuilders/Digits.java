package skillbuilders;

import java.util.Scanner;

public class Digits {

	public static void main(String[] args) 
	{
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Please input a 2 digit integer: ");
		int twoDigitNumber = userInput.nextInt();
		
		userInput.close();
		
		int onesDigit = twoDigitNumber % 10;
		System.out.println("Ones: " + onesDigit);
		
		// To get the digit in the tens place: We first take our number. We then subtract it by the remainder of dividing itself by 10. Then we divide the whole result by 10.
		int tensDigit = (twoDigitNumber - (twoDigitNumber % 10) ) / 10; 
		System.out.println("Tens: " + tensDigit);

	}

}
