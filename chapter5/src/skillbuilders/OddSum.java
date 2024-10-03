package skillbuilders;

import java.util.Scanner;

public class OddSum {

	public static void main(String[] args) 
	{
		Scanner userInput = new Scanner(System.in);
		
		int minValue = 1;
		System.out.print("Please enter an integer. ");
		int maxValue = userInput.nextInt();
		int sum = 0;
		
		System.out.print("Odd numbers: ");
		
		for (int i = minValue; i < maxValue + 1; i++) 
		{
			if (i % 2 != 0) 
			{
				System.out.print(i + ", ");
				sum += i;
			}

		}
		System.out.println("\nSum of odd values: " + sum);
	}

}
