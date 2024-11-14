/* 

Program: LunchOrder.java, Food.java              Date: November 5th 2024

Purpose: Create a LunchOrder application that prompts the user for the number of hamburgers, salads, french fries, and sodas and then displays the total for the order. The lunchorder application should include a food object with a constructor that accept  the price, fat , carbs, and fiber for an item. Food methods should returh the price of an item and return the fat, carbohydrates, and fiber. Use the chart below for food prices and nutrition information:

Author: Stefan S
School: CHHS
Course: CS20

*/

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

/* Screen Dump

Test case:

	The hamburger costs 1.85$, and has 9.0 g of fat, 33.0 g of carbohydrates, 1.0 g of fibres.
	Enter number of Hamburgers: 1
	
	The salad costs 2.00$, and has 1.0 g of fat, 11.0 g of carbohydrates, 5.0 g of fibres.
	Enter number of Salads: 2
	
	The french fries costs 1.30$, and has 11.0 g of fat, 36.0 g of carbohydrates, 4.0 g of fibres.
	Enter number of Fries: 3
	
	The soda costs 0.95$, and has 0.0 g of fat, 38.0 g of carbohydrates, 0.0 g of fibres.
	Enter number of Sodas: 4
	
	Your order comes to 13.55$

*/

