package skillbuilders;

/**
 * Circle class.
 */
public class Circle {
	private static final double PI = 3.14;
	private double radius;
	
	
	/**
	 * constructor
	 * pre: none
	 * post: A Circle object created. Radius initialized to 1.
	 */
	public Circle() {
		radius = 1;		// default radius
	}
	
	/**
	 * constructor
	 * pre: none
	 * post: A circle object, created with a custom radius.
	 */
	public Circle(double newRadius) {
		radius = newRadius;
	}
	
	/**
	 * Changes the radius of the circle
	 * pre: none
	 * post: Radius has been changed.
	 */
	public void setRadius(double newRadius) { // "static" means that a method can be accessed without creating an object of the class. hence why static is not included here.
		radius = newRadius;
	}
	
	
	/**
	 * Calculates the area of the circle.
	 * pre: none
	 * post: The area of the circle has been returned.
	 */
	public double area() {
		double circleArea;
		
		circleArea = PI * radius * radius;
		return(circleArea);
	}
	
	
	/**
	 * Returns the radius of the circle
	 * pre: none
	 * post: The radius of the circle has been returned.
	 */
	public double getRadius() {
		return(radius);
	}
	
	
	/**
	 * Returns the circumference of the circle.
	 * pre: none
	 * post: The circumference of the circle has been returned.
	 */
	public double circumference() { // i didn't choose this name, the textbook did. getCircumference would probably work better.
		double circumference;
		
		circumference = (2 * PI * radius);
		return circumference;
		
	}
	
	/**
	 * Displays the formula for the area of a circle.
	 * pre: none
	 * post: Outputs the formula for the area of a circle on a new line.
	 */
	public static void displayAreaFormula() {
		System.out.println("The formula for the area of a circle is PI*radius^2");
	}
	
	/**
	 * Determines if the object is equal to another circle object
	 * pre: input is a circle object
	 * post: boolean value, which tells you whether the objects are equal
	 */
	public boolean equals(Object c) { // this specifically was a bit confusing to me. In essence: equals is a method which belongs to a Circle object. circle.equals() is the method, and the object we pass is used as an item to compare to.
		Circle testObj = (Circle)c; // the object that we pass isn't necessarily a circle, hence why we typecast the passed value to a circle.
		
		if (testObj.getRadius() == radius) { // testObj.getRadius is the radius of the passed object. radius is the radius of the parent object of the method.
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns a string describing the circle object
	 * pre:none
	 * post: outputs the defining characteristic (radius) of the circle object.
	 */
	public String toString() {
		return ("The circle has a radius of " + radius);
	}
}


