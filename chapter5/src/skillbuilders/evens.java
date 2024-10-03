package skillbuilders;

public class evens {

	public static void main(String[] args) 
	{
		int minValue = 1;
		int maxValue = 20;
		
		System.out.print("Even numbers: ");
		
		for (int i = minValue; i < maxValue + 1; i++) 
		{
			if (i % 2 == 0) 
			{
				System.out.print(i + ", ");
			}

		}

	}

}
