package skillbuilders;

public class TestCircle {

	public static void main(String[] args) {
		Circle spot = new Circle(3);
		
		System.out.println("Circle radius: " + spot.getRadius());
		System.out.println("Circle Circumference: " + spot.circumference());
		
		spot.setRadius(20);
		System.out.println("New circle radius: " + spot.getRadius());
		
		
		Circle.displayAreaFormula();
		
		System.out.println(spot.toString());
		
		Circle spot2 = new Circle(20);
		
		System.out.println("Does spot equal spot2? " + spot.equals(spot2));

	}

}
