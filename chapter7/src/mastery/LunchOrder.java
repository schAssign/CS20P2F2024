package mastery;

import java.util.Scanner;

public class LunchOrder {

	public static void main(String[] args) { // this client code solution is horrendously inefficient, but I can't seem to think of anything better. oops!
		
		Scanner userInput = new Scanner(System.in);
		
		Food hamburger = new Food("hamburger");
		Food salad = new Food("salad");
		Food fries = new Food("french fries");
		Food soda = new Food("soda");
		
		int amountOfBurgers;
		int amountOfSalads;
		int amountOfFries;
		int amountOfSodas;
		double totalCost;
		
		System.out.println(hamburger.toString());
		System.out.print("Enter number of Hamburgers: ");
		amountOfBurgers = userInput.nextInt();
		System.out.println(); // blank space for readability.
		
		System.out.println(salad.toString());
		System.out.print("Enter number of Salads: ");
		amountOfSalads = userInput.nextInt();
		System.out.println();
		
		System.out.println(fries.toString());
		System.out.print("Enter number of Fries: ");
		amountOfFries = userInput.nextInt();
		System.out.println();
		
		System.out.println(soda.toString());
		System.out.print("Enter number of Sodas: ");
		amountOfSodas = userInput.nextInt();
		System.out.println();
		
		totalCost = ( (double)( (hamburger.getFoodPrice() * amountOfBurgers)  + (salad.getFoodPrice() * amountOfSalads) + (fries.getFoodPrice() * amountOfFries) + (soda.getFoodPrice() * amountOfSodas) ) / 100);
		
		System.out.println("Your order comes to " + totalCost + "$");
		
	}

}
