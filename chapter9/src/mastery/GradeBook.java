package mastery;

import java.util.Scanner;

public class GradeBook {
	private static final String fileName = "gradebook.csv";
	
	
	
	/**
	 * Constructor. Creates a new GradeBook object 
	 */
	public GradeBook() {}
	
	
	
	/**
	 * Creates a Scanner to be used by other functions.
	 * @return Scanner
	 */
	private Scanner newScanner() 
	{	Scanner scanner;
	
		try 
		{
			scanner = new Scanner(GradeBook.class.getResourceAsStream(fileName));  // checks for a file matching fileName, in the same directory as GradeBook.java
			scanner.useDelimiter(","); // make sure that the comma seperated values are actually comma separated.
			return scanner;
		} 
		catch(Exception NullPointerException) // if file can't be found
		{
			System.out.println("No file with name " + fileName + " found! Please create " + fileName + " in the same directory as the Gradebook class.");
			System.exit(0);
			return(new Scanner(System.in)); // this is just a token gesture. Eclipse dictates that I must return Scanner, even if the statement directly before ENDS THE PROGRAM
		}
		
	}
	
	
	
	/**
	 * Gets the amount of rows contained within the CSV file.
	 * @return Amount of rows
	 */
	private int amountOfRows()
	{	int amountOfRows = 0
	;	Scanner determineAmountOfRows = newScanner();
	
	while(determineAmountOfRows.hasNextLine()) // For each line of the CSV file
	{
		amountOfRows +=1; // assume one student per line in the file.
		determineAmountOfRows.nextLine();
	}
	
	return amountOfRows;
	
	}
	
	
	
	/**
	 * Prints the gradebook to the console, barely formatted. It's effectively like opening up a text editor to look at the CSV file.
	 */
	public void displayGradeBook() 
	{
		Scanner newScanner = newScanner();
		while(newScanner.hasNextLine()) {
			System.out.println(newScanner.nextLine());
		}
		
		newScanner.close();
	}
	
	
	
	/**
	 * Gets a list of every student in the CSV file. Assumes that there is one student per line, and that students are in the first column. Returns an Array containing each student.
	 * @return List of students
	 */
	public String[] getStudents()
	{	String[] listOfStudents
	;	Scanner addStudentToArray = newScanner();
	
		listOfStudents = new String[amountOfRows()]; // assume one student per column of the file.
		
		for (int i = 0; i < listOfStudents.length; ++i) 
		{
			listOfStudents[i] = addStudentToArray.next(); // assuming that the student's name comes first in each row.
			addStudentToArray.nextLine(); // assuming that there is one student per column.
		}
		
		return listOfStudents;		
		
	}
	
	
	
	/**
	 * Neatly formats and returns the information of 1 student, located at the given index. Information is neatly formatted.
	 * @param index
	 * @return
	 */
	public String getStudent(int index) 
	{	Scanner studentInformationFinder = newScanner();
	
	if (index >= amountOfRows()) {
		return("NoSuchElementException prevented. Selected student could not be found.");
	}
		
		for (int i = 0; i < index; ++i)  // go past all of the lines below the student's row number
		{
			studentInformationFinder.nextLine();
		}
		
		return( ("Student: " + studentInformationFinder.nextLine().replaceFirst(",","\nGrades: ").replace(',', '|')       ) ); // return the student located within the indicated row number
		
	}
	
}
