package mastery;

public class Food {
	private String foodType;
	private int price; // price is in cents.
	private double fat;
	private double carbs;
	private double fibre;

	
	
	/**
	 * Constructor
	 * pre: none
	 * post: a Food object is created with values corresponding to the type of food chosen.
	 * @param selectedFood
	 */
	public Food(String selectedFood) {
		
		foodType = selectedFood.toLowerCase();
		
		switch(selectedFood.toLowerCase()) 
		{ // depending on the food chosen, set the properties of the object. In practice, each object will serve as a new type of food in the program.
		case "hamburger": 
			price = 185;
			fat = 9.0;
			carbs = 33.0;
			fibre = 1.0;
			break;
			
		case "salad": 
			price = 200;
			fat = 1.0;
			carbs = 11.0;
			fibre = 5.0;
			break;
		
		case "french fries": 
			price = 130;
			fat = 11.0;
			carbs = 36.0;
			fibre = 4.0;
			break;
			
		case "soda": 
			price = 95;
			fat = 0.0;
			carbs = 38.0;
			fibre = 0.0;
			break;
			
		default:
			System.out.println("Selected food is not a valid food type! Setting values to 0...");
			price = 0;
			fat = 0.0;
			carbs = 0.0;
			fibre = 0.0;
			break;
		}
	}
	
	
	
	/**
	 * Returns the properties of the food object, as a string.
	 * pre: none
	 * post: the properties of the food object have been returned.
	 */
	public String toString() {
		return(String.format("The %s costs %.2f$, and has %.1f g of fat, %.1f g of carbohydrates, %.1f g of fibres.", foodType, (double)price/100, fat, carbs, fibre ));
	}
	
	
	/**
	 * Returns the type of food of the object.
	 * pre: none
	 * post: type of food has been returned.
	 * @return foodType
	 */
	public String getFoodType() {
		return foodType;
	}
}
