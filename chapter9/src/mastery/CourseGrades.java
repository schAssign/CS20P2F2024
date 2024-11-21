/* 

Program: CourseGrades.java              Date: November 20th, 2024

Purpose: Create a CourseGrades application that simulates a grade book for a class with 12 students that each have 5 test scores. The CourseGrades application should use a GradeBook class that has member variables `grades`, which is a two dimensional array or integers, and methods getGrades() for prompting the user for the test grades for each student, showGrades() that displays the grades for the class, studentAvg() that has a student number parameter and then returns the average grade for that student, and testAvg() that has a test number parameter and then returns the average grade for that test.

Author: Stefan S
School: CHHS
Course: CS20

*/

package mastery;

import java.util.Scanner;

public class CourseGrades {
	
	public static void main(String[] args)
	{	// declaration zone
	;	boolean keepLooping = true
	;	GradeBook gradeBook = new GradeBook()
	;	Scanner userInput = new Scanner(System.in)
	;	int userChoice
	;	String[] studentsList;
	
		
		while(keepLooping = true) 
		{
			System.out.println("1. View full gradebook\n"
					+ "2. View student information by student index\n"
					+ "3. View student information by name");
			
			System.out.print("What would you like to do? ");
			userChoice = userInput.nextInt();
			
			switch(userChoice) 
			{
			case 1: studentsList = gradeBook.getStudents(); for(int i = 0; i < studentsList.length; ++i) {System.out.println(studentsList[i]);} // update the list of students (in case any changes has been made) and print that to the console with a for loop.
			}
			
			
		}
		
	}
	
}
