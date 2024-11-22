package mastery;

import java.util.Scanner; import java.io.FileWriter;
import java.io.IOException; import java.io.File;
import java.util.Arrays; import java.util.ArrayList;

public class GradeBook {
	private static final String fileName = "gradebook.csv";
	private static final String delimiter = ","; // i'd make this a char but Scanner.useDelimiter("") calls for a String
	private static File fileToWrite = new File("src/mastery/" + fileName);
	
	
	
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
			//File fileToWrite = new File("src/mastery/" + fileName); // moved to the constructor.
			System.out.println("New student written to " + fileToWrite.getAbsolutePath());
			System.out.println("If you're running this program in Eclipse, files may not refresh automatically! Go to your Project Explorer, press CTRL+A, and then press F5 to refresh files!");
			FileWriter fileWriter = new FileWriter(fileToWrite, true); // "true" sets the filewriter to append mode.  "false" WILL OVERWRITE!
			fileWriter.write("\n" + name + Arrays.toString(grades).replaceAll("[\\]\\[]", ",").replaceAll(" ", "")); // create a new line. write the name, add a comma. Then display the grades Array in it's default format (which already has commas). we simply remove the whitespace and replace the square brackets with commas..
			
			fileWriter.close(); }
		
		catch(Exception FileNotFoundException) {
			System.out.println("File not found!");}
	}
	
	
	
	/**
	 * Returns an integer, containing the value of a given student's grade average. Finds student by their index.
	 * @param Student index
	 * @return Grade average
	 */
	public int studentGradeAverage(int index) // integer division is used.
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
	
	
	
	/**
	 * Finds the average grade on a given test, given the test number. Returns as an integer (integer division is done). 
	 * @param index
	 * @return
	 */
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
			//System.out.println("While loop started");
			
			lineToParse = lineSelector.nextLine();
			lineParser = new Scanner(lineToParse); // we go t
			lineParser.useDelimiter(delimiter);
			
			for (int i = 0; i <= index; ++i) // for each "index" value the user inputs, move to the next row.
			{
				
			if (lineParser.hasNext()) // move the line parser to the next column. If it doesn't have another column to move to, we know that this student doesn't have data for the given test and we skip them.
			{
				informationFound = lineParser.next();
				skipStudent = false;
				//System.out.println("Moved line parser to next column. Value stored: " + informationFound );
			} else {
				skipStudent = true; break;
			}
			}
			
			//System.out.println((informationFound));
			
			//System.out.println("Skip student? " + skipStudent);
			
			if (skipStudent == false)
			{	
			try // store the found value. add it to the list.
			{	//System.out.println("Adding " + Integer.parseInt(informationFound));
				testScoresList.add(Integer.parseInt(informationFound));
				
			} 
			catch (Exception NumberFormatException) // if the value we're trying to read is not an integer, something has gone catastrophically wrong.
			{
				System.out.println("Attempted to read a value which is not an integer! Results may not be accurate! Please check your CSV file...");
			} 
			}	
			

		}
		
		for (int i = 0; i < testScoresList.size(); ++i) 
		{			
			testAverage += testScoresList.get(i);
			
			//System.out.println("accumulated test score: " + testAverage);
		}
		
		if (testScoresList.size() != 0) 
		{
			return(testAverage / testScoresList.size());
		}
		else
		{
			System.out.println("No test scores found for the given index!"); return 0;
		}
		
	}
	
	
	
	/**
	 * Returns the full CSV file as a string. To be used in conjuction with other methods in order to fully edit the CSV file.
	 * @return
	 */
	private String putCsvIntoMemory() 
	{	Scanner scanner = newScanner()
	;	String csvAsString = ""
	;
		while (scanner.hasNextLine()) 
		{
			csvAsString += (scanner.nextLine() + "\n");
		}
		
		return csvAsString;
		
	}
	
	
	/**
	 * Will delete a line from a String representing the CSV file AND ALL DUPLICATE LINES WHICH MATCH THE LINE! be CAREFUL!
	 */
	private String removeLineInCsv(int index) 
	{	String wholeFile = putCsvIntoMemory()
	;	Scanner findLineToRemove = new Scanner(wholeFile)
	;	String lineToRemove = ""
	;
	
	if (index >= amountOfRows()) {
		System.out.println("NoSuchElementException prevented. Selected row could not be found.");
		return "";
	}
	
	for (int i = 0; i < index; ++i)  // go past all of the lines below the student's row number
	{
		findLineToRemove.nextLine();
	}
	
	lineToRemove = findLineToRemove.nextLine();
	
	//System.out.println("Removing line \"" + lineToRemove + "\"");
	//System.out.println("File currently in memory: \n" + wholeFile.replace(lineToRemove, ""));
	
	return wholeFile.replace(lineToRemove, "");	
	}
	
	
	/**
	 * BE DANGEROUS WHEN WORKING ON YOUR DATABASE! YOU RISK DATA LOSS IF YOU PLAY AROUND WITH THIS!
	 * This method puts the CSV file into memory, deletes the specified line from it using string methods, and then replaces the CSV file with the edited version in memory.
	 * @throws IOException 
	 */
	public void replaceLineInCsv(int index) throws IOException 
	{	FileWriter fileWriter = new FileWriter(fileToWrite, false) // `false` SETS THE FILEWRITE TO OVERWRITE MODE! THIS WILL REPLACE YOUR FILES.
	;	String textToOverwriteWith = removeLineInCsv(index)
	;
		fileWriter.write(textToOverwriteWith.trim().replaceAll("\n+", "\n")); // overwrite the CSV, with no beginning/end spaces, and no blank lines.
		fileWriter.close();
	
		//System.out.println("Overwriting file with text:\n" + textToOverwriteWith);
		
	}
} 
