package mastery;

public class MySavings {

	public static void main(String[] args) {
		
		PiggyBank myBank = new PiggyBank();
		
		System.out.println(myBank.showCoins());
		
		myBank.addDime();
		myBank.addNickel();
		myBank.addQuarter();
		myBank.addPenny();
		
		System.out.println(myBank.toString());

	}

}
