package skillbuilders;

public class Squares {

	public static void main(String[] args) {
		
		final int arrayLengthToSet = 5; // change this to change the array length
		
		int[] squareNumbers = new int[arrayLengthToSet];
		
		for (int i = 0; i < squareNumbers.length; ++i) {
			squareNumbers[i] = (i*i);
			System.out.println(String.format("the square of %d is %d", i, squareNumbers[i]));
		}

		
	}

}
