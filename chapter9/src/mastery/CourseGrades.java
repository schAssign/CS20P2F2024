/* 

Program: CourseGrades.java              Date: November 20th, 2024

Purpose: Create a CourseGrades application that simulates a grade book for a class with 12 students that each have 5 test scores. The CourseGrades application should use a GradeBook class that has member variables `grades`, which is a two dimensional array or integers, and methods getGrades() for prompting the user for the test grades for each student, showGrades() that displays the grades for the class, studentAvg() that has a student number parameter and then returns the average grade for that student, and testAvg() that has a test number parameter and then returns the average grade for that test.

Author: Stefan S
School: CHHS
Course: CS20

*/

package mastery;

import java.io.IOException;
import java.util.Scanner;

public class CourseGrades {
	
	public static void main(String[] args) throws IOException // "throws" has to be in here because of filewriter in CourseGrades
	{	// declaration zone
	;	GradeBook gradeBook = new GradeBook()
	;	Scanner userInput = new Scanner(System.in)
	;	int userChoice
	;	String[] studentsList
	;	String newStudentName
	;	int[] gradesToPass
	;
	
		
		while(true) 
		{
			System.out.println("1. View full gradebook\n"
					+ "2. Display list of students\n"
					+ "3. View student information by student index\n"
					+ "4. View student grade average by student index\n"
					+ "5. View student information by name (unimplemented)\n"
					+ "6. Add student to the gradebook\n"
					
					+ "0. End program.");
			
			System.out.print("What would you like to do? ");
			userChoice = userInput.nextInt();
			System.out.println(); // blank line for readability
			
			switch(userChoice) 
			{
			
			
			case 1: 
				gradeBook.displayGradeBook(); break;
			
				
				
			case 2: 
				studentsList = gradeBook.getStudents(); 
				for(int i = 0; i < studentsList.length; ++i) 
				{System.out.println(studentsList[i]);} break; // update the list of students (in case any changes has been made) and print that to the console with a for loop.
				
				
			case 3:
				System.out.print("Please enter student index: ");
				System.out.println(gradeBook.getStudent(userInput.nextInt()));
				break;
				
			case 4: 
				System.out.print(gradeBook.studentGradeAverage(1));
				break;
				
			case 6: 
				System.out.print("Student's name: ");
				newStudentName = userInput.next();
				userInput.nextLine(); // for some reason, without this, the previous statement will not wait for the user's input and instead return an empty string.
				
				System.out.print("How many grades does this student have? ");
				gradesToPass = new int[userInput.nextInt()];
				
				for(int i = 0; i < gradesToPass.length; ++i)
				{
					System.out.print("Grade #" + (i + 1) + ": ");
					gradesToPass[i] = userInput.nextInt();
				}
				
				gradeBook.addStudent(newStudentName, gradesToPass); break;
				
				
				
			case 0: System.exit(0);
			
			}
				
			
			System.out.println(); // blank line for readability
			
		}
		
	}
	
}
