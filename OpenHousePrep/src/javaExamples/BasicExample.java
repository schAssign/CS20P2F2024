package javaExamples;

import java.util.Scanner;

public class BasicExample {	// everything in java is a "class". 
							//each class has "methods" that let you do things to said class.

	
		
	public static void main(String[] args) { 	// this is our main "method". when this class is executed, the main method will automatically execute.
												// also, take note of the curly brackets. the "scope" of things in java is explicitly defined. Python uses indents instead.
		
		
		String usersInput;	// Java is "explicitly typed". This means that variables must contain a specific data type.
							// also, statements in java always end with a semicolon. In Python, a statement ends when the next line begins.
		
		
		Scanner ourScanner = new Scanner(System.in);	// EVERYTING in Java is a "Class". Here, we're creating a new variable, but we're giving it the "Scanner" class.
														// The Scanner class is used to input data. (System.in) means we're gathering data from the keyboard.
		
		
		usersInput = ourScanner.nextLine();	// we can use the nextLine() method, which belongs to the Scanner class, in order to get the user's input.
		
		
		System.out.println("You said: " + usersInput);	// System.out specifies that we're outputting to the terminal. println prints on a new line.
										// if we were to use print instead of println, we would print text onto the same line as the user's input.
		
		
		

	}

}
