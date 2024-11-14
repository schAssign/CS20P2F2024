package skillbuilders;

import java.util.Scanner;

public class StudentRoster {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		String[] studentList; // declaration zone
		int numberOfStudents;
		
		System.out.print("How many students in this class? ");
		numberOfStudents = userInput.nextInt();
		
		studentList = new String[numberOfStudents]; // allocate space
		
		for (int i = 0; i < studentList.length; ++i) {
			System.out.print("Name of student " + (i + 1) + ": ");
			studentList[i] = userInput.next();
		}		
		
		System.out.println("\nStudent roster: \n"
				+ "---------------");
		
		for(int i = 0; i < studentList.length; ++i) {
			System.out.println(studentList[i]);
		}
		
	}

}
