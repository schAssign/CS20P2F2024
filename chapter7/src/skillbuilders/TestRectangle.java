package skillbuilders;

public class TestRectangle {

	public static void main(String[] args) {
		Rectangle square = new Rectangle(10, 10);
		
		System.out.println("Rectangle width: " + square.getWidth());
		System.out.println("Rectangle length: " + square.getLength());
		System.out.println("Rectangle area: " + square.getArea());
		System.out.println("Rectangle perimeter: " + square.getPerimeter());
		
		Rectangle.displayAreaFormula();
		
		Rectangle square2 = new Rectangle(10);
		
		System.out.println(square.equals(square2));
		
		System.out.println(square.toString());

	}

}
