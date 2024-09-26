package skillbuilders;

import java.util.Scanner; import java.lang.Math;

public class RandomNum {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Please input minimum and maximum values to generate a random number: ");
		
		int minValue = userInput.nextInt();
		int maxValue = userInput.nextInt();

		
		System.out.println("Random Value: " + (maxValue - minValue + 1) * Math.random() + minValue);

	}

}
