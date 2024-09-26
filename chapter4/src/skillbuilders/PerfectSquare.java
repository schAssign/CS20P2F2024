package skillbuilders;

import java.util.Scanner; import java.lang.Math;

public class PerfectSquare {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Please input an integer: ");
		int numberToCheck = userInput.nextInt();
		
		if (numberToCheck == ( (int)Math.sqrt(numberToCheck) * (int)Math.sqrt(numberToCheck) ) ) {
			System.out.print("Number is a perfect square.");
		} else {
			System.out.print("Number is NOT a perfect square.");
		}

	}

}
