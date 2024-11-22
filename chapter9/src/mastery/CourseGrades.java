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
	;	int userInputtedIndex;
	;	String confirmationPrompt;
	
		
		while(true) 
		{
			System.out.println("1. View full gradebook\n"
					+ "2. Display list of students\n"
					+ "3. View student information by student index\n"
					+ "4. View student grade average by student index\n"
					+ "5. View class average for test\n"
					+ "6. Add student to the gradebook\n"
					+ "7. Delete student from gradebook by index\n"
					
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
				userInputtedIndex = userInput.nextInt();
				System.out.println(gradeBook.getStudent(userInputtedIndex));
				break;
				
			case 4: 
				System.out.print("Please enter student index: ");
				userInputtedIndex = userInput.nextInt();
				System.out.println(gradeBook.getStudent(userInputtedIndex) + "\nAverage: " + gradeBook.studentGradeAverage(userInputtedIndex));
				break;
				
			case 5:
				System.out.print("Please enter test number: ");
				userInputtedIndex = userInput.nextInt();
				System.out.println("Student average for test #" + userInputtedIndex + ": " + gradeBook.testGradeAverage(userInputtedIndex)); break;
				
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
				
			case 7:
				System.out.print("Please enter student index: ");
				userInputtedIndex = userInput.nextInt();
				System.out.println(gradeBook.getStudent(userInputtedIndex));
				System.out.println("Are you sure you want to delete this student? (y/N)\n");
				confirmationPrompt = userInput.next().toLowerCase();
				
				// System.out.println(confirmationPrompt);
				
				if (confirmationPrompt.equals("y")) {
					gradeBook.replaceLineInCsv(userInputtedIndex); break;
				} else {
					break;
				}

				
				
				
			case 0: System.exit(0);
			
			}
				
			
			System.out.println(); // blank line for readability
			
		}
		
	}
	
}

/* Screen Dump

(please see screendump.txt located within the Chapter 9 Mastery package; the screen dump is so large I don't think I could reasonably put it here!)

*/
