package skillbuilders;

import java.util.Scanner;

public class RectanglePerimeter {

	public static void main(String[] args) 
	{
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Please enter a length value: ");
		int length = userInput.nextInt();
		
		System.out.print("Please enter a width value: ");
		int width = userInput.nextInt();
		
		userInput.close();
		
		int perimeter = (2*length) + (2*width);
		System.out.println("The rectangle has a perimeter of " + perimeter + " units");

	}

}
