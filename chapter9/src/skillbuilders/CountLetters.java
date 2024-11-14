package skillbuilders;

import java.util.Scanner; import java.util.regex.Pattern;

public class CountLetters {

	public static void main(String[] args) {
		
		final int LOW = 'A';	//smallest possible value
		final int MAX = 'Z';	//highest possible value
		int[] letterCounts = new int[MAX - LOW + 1];
		Scanner input = new Scanner(System.in);
		String word;
		char[] wordLetters;
		int offset;	//array index
		
		/* prompt user for a word */
		System.out.print("Enter a word: ");
		word = input.nextLine();
		
		/* convert the word to char array and count letter occurrences */
		word = word.toUpperCase();
		word = word.trim();	//remove whitespaces
		
		wordLetters = word.toCharArray();
		for (int letter = 0; letter < wordLetters.length; letter++) {
			offset = wordLetters[letter] - LOW;
			letterCounts[offset] += 1;
		}
		
		/* show letter occurrences */
		for (int i = LOW; i <= MAX; i++) {
			System.out.println((char)i + ": " + letterCounts[i - LOW]);
		}

	}

}
