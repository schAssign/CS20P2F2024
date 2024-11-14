package skillbuilders;

public class Reverse {

	public static void main(String[] args) { // this program is dumb, you could just write a for loop that runs 10 times and use `i--` to decrement a countdown, but also I see why it's valuable to do the lesson anyways
		
		final int arrayMaxIndex = 10;
		
		int[] countdown = new int[arrayMaxIndex + 1];
		
		System.out.println("COUNTDOWN: ");
		
		for (int i = countdown.length - 1; i > 0; i-- ) 
		{
			countdown[i] = i;
			System.out.println(countdown[i]);
		}
		
		System.out.println("!!!");
		
		
		
		

	}

}
