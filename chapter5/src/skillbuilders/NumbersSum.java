package skillbuilders;

import java.util.Scanner;

public class NumbersSum {

	public static void main(String[] args) 
	{
	Scanner userInput = new Scanner(System.in);
	
	int minValue = 1;
	System.out.print("Please enter an integer. ");
	int maxValue = userInput.nextInt();
	int sum = 0;
	
	for (int i = minValue; i < maxValue + 1; i++) 
	{
		sum += i;
		System.out.print(i + ", ");
	}
	
	System.out.print("\nSum of values: " + sum);
	
	userInput.close();
		
	}

}
