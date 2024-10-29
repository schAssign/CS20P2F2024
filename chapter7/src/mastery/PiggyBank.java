package mastery;

public class PiggyBank {
	private int pennyCount;
	private int nickelCount;
	private int dimeCount;
	private int quarterCount;
	
	
	
	/**
	 * Constructor.
	 * pre: none
	 * post: PiggyBank object is created with zero coins.
	 */
	public PiggyBank() {
		pennyCount = 0;
		nickelCount = 0;
		dimeCount = 0;
		quarterCount = 0;
	}
	
	
	
	/** 
	 * Constructor.
	 * pre: none
	 * post: PiggyBank object is created with pre-set coins.
	 * @param pennies @param nickels @param dimes @param quarters
	 */
	public PiggyBank(int pennies, int nickels, int dimes, int quarters) {
		pennyCount = pennies;
		nickelCount = nickels;
		dimeCount = dimes;
		quarterCount = quarters;
	}
	
	
	
	/**
	 * Gathers the total value of the coins stored within the piggybank.
	 * pre: none
	 * @return post: Value of coins (as an Integer, in cents)
	 */
	public int showTotalAccurateValue() { // this method comes as a result of my hatred for using floating point numbers to store currency.
		int centValue = (pennyCount + (nickelCount * 5) + (dimeCount * 10) + (quarterCount * 25));
		return centValue;
	}
	
	
	
	/**
	 * Gathers the total value of coins stored within the piggybank.
	 * pre: none
	 * @return post: Value of coins (as a Double, in dollars)
	 */
	public double showTotalDollarValue() {
		double dollarValue = ((double)(pennyCount + (nickelCount * 5) + (dimeCount * 10) + (quarterCount * 25)) / 100);
		return dollarValue;
	}
	
	
	
	/**
	 * Shows all coins stored within the piggybank.
	 * pre: none
	 * @return post: A string is returned using specific language to count each individual type of coin in the PiggyBank.
	 */
	public String showCoins() { // the complexity in this method comes from using the singular form of each currency when only one is in the piggybank
		
		String pennyWord;
		String nickelWord;
		String dimeWord;
		String quarterWord;
		
		switch (pennyCount) {
		case 1: pennyWord = "penny"; break; // if there's one penny, use the singular form. else use the plural form. I use a switch case here because it's easier to read than an if else statement.
		default: pennyWord = "pennies"; break; }
		
		switch (nickelCount) {
		case 1: nickelWord = "nickel"; break;
		default: nickelWord = "nickels"; break; }
		
		switch (dimeCount) {
		case 1: dimeWord = "dime"; break;
		default: dimeWord = "dimes"; break; }
		
		switch (quarterCount) {
		case 1: quarterWord = "quarter"; break;
		default: quarterWord = "quarters"; break; }
		
		// in the string below, "%d" is replaced with an integer and "%s" is replaced by a string. This is done in order of appearance.
		String totalCoins = String.format("%d %s, %d %s, %d %s, %d %s", pennyCount, pennyWord, nickelCount, nickelWord, dimeCount, dimeWord, quarterCount, quarterWord);
		return totalCoins;
	}
	
	
	
	/**
	 * Adds a penny to the piggybank.
	 * pre: none
	 * post: A penny, worth one cent, is added to the PiggyBank.
	 */
	public void addPenny() {
		pennyCount += 1;
	}
	
	/**
	 * Adds a nickel to the piggybank.
	 * pre: none
	 * post: A nickel, worth five cents, is added to the PiggyBank.
	 */
	public void addNickel() {
		nickelCount += 1;
	}
	
	/**
	 * Adds a dime to the piggybank.
	 * pre: none
	 * post: A dime, worth ten cents, is added to the PiggyBank.
	 */
	public void addDime() {
		dimeCount += 1;
	}
	
	/**
	 * Adds a quarter to the piggybank.
	 * pre: none
	 * post: A quarter, worth 25 cents, is added to the PiggyBank.
	 */
	public void addQuarter() {
		quarterCount += 1;
	}
	
	
	
	/**
	 * Returns a string describing the piggybank object
	 * pre:none
	 * post: returns the defining characteristics (coins & value) of the PiggyBank object.
	 */
	public String toString() {
		return("The piggybank has " + showCoins() + ", and is worth " + showTotalAccurateValue() + " cents.");
	}

	
	
	/**
	 * Determines if the object is equal to another piggybank object
	 * pre: input is a piggybank object
	 * @return post: boolean value, which tells you whether the objects are equal
	 */
	public boolean equals(Object p) {
		PiggyBank testBank = (PiggyBank)p;
		
		if (testBank.pennyCount == pennyCount && testBank.nickelCount == nickelCount && testBank.dimeCount == dimeCount && testBank.quarterCount == quarterCount) {
			return true;
		} else {
			return false; }
	}
	
	public void emptyBank() {
		pennyCount = 0;
		nickelCount = 0;
		dimeCount = 0;
		quarterCount = 0;
	}
	
}
