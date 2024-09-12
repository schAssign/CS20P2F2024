package skillbuilders;

import java.util.Scanner; import java.util.ArrayList; import java.text.NumberFormat;

public class GradeAvg_V1 {

	public static void main(String[] args) 
	{
		Scanner userInput = new Scanner(System.in);
		NumberFormat percentage = NumberFormat.getPercentInstance();
		
		ArrayList<Integer> gradeList = new ArrayList<Integer>();
		double gradeAverage = 0;
			
		for (int i = 0; i < 5; i++) { // prompt the user to input 5 grades. change the amount to input by changing the "i < #;"
			System.out.print("Please input your next grade: ");
			gradeList.add(userInput.nextInt());
			gradeAverage += gradeList.get(i); // we use the gradeAverage variable to store the sum of grades for now.
		} // (not a necessary note, but I just saw that part 2 in the textbook says to use the += operator to add the grades. I'm now realizing that I probably didn't have to use a list for this. I guess you could say that if I ever expand on the program it'll be more useful because you still have access to the raw grades.
		
		// we divide the sum of grades by the amount of grades to get the average. We know we're doing real division, because the grade average is a double.
		gradeAverage = gradeAverage / gradeList.size();
		
		System.out.print("Average Grade: " + percentage.format(gradeAverage / 100)); // divide by 100 because the percentage format assumes the number is a decimal < 1
	}

}
