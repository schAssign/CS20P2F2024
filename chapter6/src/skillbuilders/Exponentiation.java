package skillbuilders;

import java.lang.Math; import java.util.Scanner;

public class Exponentiation {
	
	public static double powerOf(int numberToRaise, int toThe) 
	{
		return Math.pow(numberToRaise, toThe);
	}

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("What number would you like to raise to a power? ");
		int userRaise = userInput.nextInt();
		System.out.print("What would you like the power to be? ");
		int userPower = userInput.nextInt();
		
		System.out.println(powerOf(userRaise, userPower));

	}

}
