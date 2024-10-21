package skillbuilders;

/**
 * Rectangle class.
 */
public class Rectangle {
	private double length;
	private double width;
	
	/**
	 * Constructor.
	 * pre: none
	 * post: Creates a rectangle object with a length and width of 1, 1.
	 */
	public Rectangle() {
		length = 1;
		width = 1;
		
	}
	
	/**
	 * Constructor.
	 * pre: none
	 * post: Creates a square, with identical width and height set to the passed value.
	 */
	public Rectangle(double squareSize) {
		length = squareSize;
		width = squareSize;
	}
	
	/**
	 * Constructor.
	 * pre: none
	 * post: Creates a rectangle with a user set length and width, respectively.
	 */
	public Rectangle(double newLength, double newWidth) {
		length = newLength;
		width = newWidth;
	}
	
	
	/**
	 * Sets a new length for the rectangle object.
	 * pre: none
	 * post: Rectangle object has a new length.
	 */
	public void setLength(double newLength) {
		length = newLength;
	}
	
	
	/**
	 * Sets a new width for the rectangle object.
	 * pre: none
	 * post: Rectangle object has a new width.
	 */
	public void setWidth(double newWidth) {
		width = newWidth;
	}
	
	
	/**
	 * Retrives the width of the rectangle object.
	 * pre: none
	 * post: Returns the width of the rectangle object as a double.
	 * @return width
	 */
	public double getWidth() {
		return(width);
	}
	
	
	/**
	 * Retrieves the length of the rectangle object
	 * pre: none
	 * post: Returns the width of the rectangle object as a double.
	 * @return length
	 */
	public double getLength() {
		return(length);
	}
	
	
	/**
	 * Retrieves the area of the rectangle object.
	 * pre: none
	 * post: Returns the area of the rectangle object as a double.
	 * @return area
	 */
	public double getArea() {
		double area = width * length;
		return(area);
	}
	
	
	/**
	 * Retrieves the perimeter of the rectangle object.
	 * pre: none
	 * post: Returns the perimeter of the rectangle object as a double.
	 * @return perimeter
	 */
	
	public double getPerimeter() {
		double perimeter = width + length;
		return(perimeter);
	}
	
	
	/**
	 * Displays the formula for the area of a rectangle.
	 * pre: none
	 * post: Uses a new line to display the rectangle area formula.
	 */
	public static void displayAreaFormula() {
		System.out.println("The formula for the area of a rectangle is width*length.");
	}
	
	/**
	 * Checks if one rectangle object is equal to another.
	 * pre: passed object must be a rectangle
	 * post: a boolean value stating whether two rectangles are equal.
	 */
	public boolean equals(Object r) {
		Rectangle testObject = (Rectangle)r;
		
		if (testObject.getWidth() == width && testObject.getLength() == length) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return ("The rectangle has a width of " + width + " and a length of " + length);
	}
}
