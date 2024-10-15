package skillbuilders;

import java.util.Scanner;

public class TimeConverter {

	
	
	public static void hoursToMinutes() 
	{
		double hours, minutes; // these are doubles, partially so that we're doing real division (as opposed to integer division) and partially so that the user can input decimals
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Please input a time, in hours: ");
		hours = userInput.nextDouble();
		userInput.close();
		
		minutes = hours * 60;
		System.out.printf("%g Hours, in minutes, is %g. %n", hours, minutes);
		
		
	}
	
	
	
	public static void daysToHours() 
	{
		double days, hours;
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Please input a time, in days: ");
		days = userInput.nextDouble();
		userInput.close();
		
		hours = days * 24;
		System.out.printf("%g Days, in hours, is %g. %n", days, hours);
		
		
	}

	
	
	public static void minutesToHours() 
	{
		double hours, minutes;
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Please input a time, in minutes: ");
		minutes = userInput.nextDouble();
		userInput.close();
		
		hours = minutes / 60;
		System.out.printf("%g Minutes, in hours, is %g. %n", minutes, hours);
		
		
	}
	
	
	
	public static void hoursToDays() 
	{
		double hours, days;
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Please input a time, in hours: ");
		hours = userInput.nextDouble();
		userInput.close();
		
		days = hours / 24;
		System.out.printf("%g Hours, in days, is %g. %n", hours, days);
	}
	
	
	
	public static void main(String[] args) 
	{		
		Scanner userInput = new Scanner (System.in);
		
		System.out.printf("Select a conversion: %n 1 = Hours to Minutes %n 2 = Days to Hours %n 3 = Minutes to Hours %n 4 = Hours to Days %n");
		int userChoice = userInput.nextInt();
		
		switch (userChoice) {
		case 1: hoursToMinutes(); break;
		case 2: daysToHours(); break;
		case 3: minutesToHours(); break;
		case 4: hoursToDays(); break;
			
		}
		

	}
}
