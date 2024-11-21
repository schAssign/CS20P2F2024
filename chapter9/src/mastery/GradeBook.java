package mastery;

import java.util.Scanner; import java.io.FileWriter;
import java.io.IOException; import java.io.File;
import java.util.Arrays; import java.util.ArrayList;

public class GradeBook {
	private static final String fileName = "gradebook.csv";
	private static final String delimiter = ","; // i'd make this a char but Scanner.useDelimiter("") calls for a String
	
	
	
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
			scanner.useDelimiter(delimiter); // make sure that the comma seperated values are actually comma separated.
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
	 * This is equivalent to showGrades(), as recommended by the textbook.
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
	 * @param Student index
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
	
	
	
	
	/**
	 * In a new line of the CSV file, add a student to the first column and their individual grades in the next column.
	 * @param String name
	 * @param int[] grades
	 * @throws IOException
	 */
	public void addStudent(String name, int[] grades) throws IOException {
		try {
			File fileToWrite = new File("src/mastery/" + fileName);
			System.out.println("New student written to " + fileToWrite.getAbsolutePath());
			System.out.println("If you're running this program in Eclipse, files may not refresh automatically! Go to your Project Explorer, press CTRL+A, and then press F5 to refresh files!");
			FileWriter fileWriter = new FileWriter(fileToWrite, true); // "true" sets the filewriter to append mode.  "false" WILL OVERWRITE!
			fileWriter.write("\n" + name + "," + Arrays.toString(grades).replaceAll("[\\]\\[ ]", "" + ",")); // create a new line. write the name, add a comma. Then display the grades Array in it's default format (which already has commas). we simply remove the whitespace and square brackets.
			
			fileWriter.close(); }
		
		catch(Exception FileNotFoundException) {
			System.out.println("File not found!");}
	}
	
	
	
	/**
	 * Returns an integer, containing the value of a given student's grade average. Finds student by their index.
	 * @param Student index
	 * @return Grade average
	 */
	public int studentGradeAverage(int index) 
	{	Scanner studentInformationFinder = newScanner()
	;	int gradeAggregator = 0
	;	int numberOfColumns = 0 // we increment this every time an integer is found in the row; LEAVE IT AT 0!
	;	String lineToParse
	;	Scanner lineParser;
		
		if (index >= amountOfRows()) {
			System.out.println("NoSuchElementException prevented. Selected student could not be found.");
			return(0);
		}
			
		for (int i = 0; i < index; ++i)  // go past all of the lines below the student's row number
		{
			studentInformationFinder.nextLine();
		}
		
		lineToParse = studentInformationFinder.nextLine(); // store the line with the student's information to a variable
		lineParser = new Scanner(lineToParse); // declare a new Scanner to parse the line
		lineParser.useDelimiter(delimiter); // seperate by commas
		
		while(lineParser.hasNext()) // go through all columns in the row. collect and add the data. if data isn't an integer, ignore the data, ignore the exception, and keep going.
		{	String informationFound = lineParser.next();

			try { Integer.parseInt(informationFound); 
				//System.out.println(informationFound);
			
				numberOfColumns +=1;
				gradeAggregator += Integer.parseInt(informationFound);
			} catch (Exception FinalNumberFormatException) {
				
			}
		}
		
		lineParser.close();
		studentInformationFinder.close();
		return(gradeAggregator/numberOfColumns); // get the average of all grades found, and return it
		
	}
	
	
	public int testGradeAverage(int index) 
	{	Scanner lineSelector = newScanner()
	;	String lineToParse
	;	Scanner lineParser
	;	String informationFound = "0";
	;	ArrayList<Integer> testScoresList = new ArrayList<Integer>()
	;	boolean skipStudent = true;
	;	int testAverage = 0;
	
	
		while (lineSelector.hasNextLine()) 
		{
			System.out.println("While loop started");
			
			lineToParse = lineSelector.nextLine();
			lineParser = new Scanner(lineToParse); // we go t
			lineParser.useDelimiter(delimiter);
			
			for (int i = 0; i < index; ++i) // for each "index" value the user inputs, move to the next row.
			{
				
			if (lineParser.hasNext()) // move the line parser to the next column. If it doesn't have another column to move to, we know that this student doesn't have data for the given test and we skip them.
			{
				informationFound = lineParser.next();
				skipStudent = false;
				System.out.println("Moved line parser to next column. Value stored: " + informationFound );
			} else {
				skipStudent = true; break;
			}
			}
			
			System.out.println(Integer.parseInt(informationFound));
			
			System.out.println("Skip student? " + skipStudent);
			
			if (skipStudent = false) //something about this loop causes it to be skipped every time. please fix!
			{	
			try // store the found value. add it to the list.
			{	System.out.println("Adding " + Integer.parseInt(informationFound));
				testScoresList.add(Integer.parseInt(informationFound));
				
			} 
			catch (Exception FinalNumberFormatException) // if the value we're trying to read is not an integer, something has gone catastrophically wrong.
			{
				System.out.println("Attempted to read a value which is not an integer! Results may not be accurate! Please check your CSV file...");
			} 
			}	
			

		}
		
		for (int i = 0; i < testScoresList.size(); ++i) 
		{			
			testAverage += testScoresList.get(i);
			
			System.out.println("accumulated test score: " + testAverage);
		}
		
		return(testAverage / testScoresList.size());
		
		
		
	}
	
	
} 
