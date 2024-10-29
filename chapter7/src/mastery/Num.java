package mastery;

public class Num { // just methods for this object
	
	
	
	/**
	 * Constructor.
	 * pre: none
	 * post: a Num object is created.
	 */
	public Num() {
		
	}

	
	
	/**
	 * Returns the requested digit of the passed value.
	 * pre: none
	 * post: an integer is returned, equal to the value of the digit in the chosen place.
	 */
	private int calculateDigit(int numToCheck, int toWhichDigit) { // i hate to use so many variables (waste of memory) but this needs to be at least somewhat readable. sorry!
		
		String stringToCheck = Integer.toString(numToCheck); // convert the passed int to string, 
		
		String stringToReturn = stringToCheck.substring(stringToCheck.length() - toWhichDigit, stringToCheck.length() - toWhichDigit + 1); //gets the part of the string, starting from the left side and moving backwards ( String.length - ___ ), specified by toWhichDigit.
		
		/* REMINDER TO SELF:
		 * HANDLE THE outOfBoundsCheckFromToIndex ERROR WHICH IS CAUSED WHEN YOU TRY TO GET AN OUT OF BOUNDS DIGIT. IDEALLY, IN THIS CASE, RETURN 0.
		 */
		
		return Integer.valueOf(stringToReturn); // return the calculated string as an integer.
	}
	
	
	
	/**
	 * Runs the private calculateDigit method. 
	 * @param numToCheck
	 * @param toWhichDigit
	 * @return Single digit
	 */
	public int getDigit(int numToCheck, int toWhichDigit) { // toWhichDigit as part of getDigit() is recalculated to make it readable to calculateDigit()
		
		int toWhichDigitCalculator = (Integer.toString(toWhichDigit)).length(); // a nice quirk of the way we write numbers, is that 1 has one digit in it, 10 has two digits in it, 100 has three digits in it, and so on. This corresponds quite well to how many digits you have to move in order to find a specific digit in it's respective place (the 100's digit is 3 digits over from the left, for example.)
		// in essence; the statement above converts the length of an integer to the amount of digits contained within the integer.
		
		return calculateDigit(numToCheck, toWhichDigitCalculator);
	}
	
	
	
	
	
	
	

}
