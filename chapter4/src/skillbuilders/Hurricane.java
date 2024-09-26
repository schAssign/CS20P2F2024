package skillbuilders;

import java.util.Scanner;

public class Hurricane {
	
	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Hurricane intensity: ");
		int hurricaneCategory = userInput.nextInt();
		
		switch (hurricaneCategory) 
		{
		case 0: System.out.println("No hurricane."); break;
		case 1: System.out.println("Category 1: 74-95 mph, 64-82kt, 119-153 km/hr"); break;
		case 2: System.out.println("Category 2: 96-110mph, 83-95kt, 154-177km/hr"); break;
		case 3: System.out.println("Category 3: 111-130mph, 96-113kt, 178-209km/hr"); break;
		case 4: System.out.println("Category 4: 131-155mph, 114-135kt, 210-249km/hr"); break;
		case 5: System.out.println("Category 5: >155mph, >135kt, >249km/hr"); break;
		default: System.out.println("Hurricane is not on the Saffir-Simpson Scale."); break;
		}
		

	}

}
