package code;

/**
 * For this last coding exercise of the semester you will define a class that reads in a file of text and computes character and word counts.
 * You must name your class "WordCount", and WordCount must implement the WC_Interface interface, defined in this file. 
 * 
 * The data files provided are public domain books in plain text (UTF-8) format from Project Gutenberg (https://www.gutenberg.org)
 * 
 * INSTRUCTIONS:
 * 
 *   1) Read the contents of a data file as you've done in earlier assignments, using readAllLines.
 * 
 *   2) Break each line into words using the split method of the String class:
 *          https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#split(java.lang.String)
 * 
 *      To ensure that you split lines the same way as the grading code, use the following String as the regular expression, or "regex".
 *      Notice that there are two kinds of dashes and a space in the String): "[ \t\n—-]"
 *      
 *      Using this regex means that the line will be split at a space (' '), a tab ('\t'), and newline ('\n'), an em-dash ('—'), or an n-dash ('-').
 *      
 *      You can read more about regular expressions in Java here, if you are so inclined:
 *          https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html#sum
 * 
 *   3) For each resulting word, convert all letters to lower case, using the toLowerCase method of the String class:
 *          https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#toLowerCase()
 * 
 *   4) After this remove all non-alphabetic characters from the word, using the replaceAll method of the String class:
 *          https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#replaceAll(java.lang.String,%20java.lang.String)
 * 
 *      using "[^a-z]" as the regex String and "" as the replacement String.  "a-z" denotes all lower case letters. "^a-z" means
 *      any character OTHER than the lower case letters.  "[^a-z]" means any one of the characters that is not a lower case letter.
 *      
 *      "" is the empty string.
 *      
 *      The replace all method will return a new String that is just like the String it is called on, except that any character that
 *      is not a lower case letter will be replaced by "" (i.e. it will be removed).
 *      
 *      For example, "Hi!  How are you?".replaceAll("[^a-z]","") returns the String "iowareyou".  Notice how the upper case letters
 *      do not appear in the result.  "Hi!  How are you?".toLowerCase().replaceAll("[^a-z]","") produces "hihowareyou".
 * 
 * You may use whatever data structure you deem appropriate to store the character counts and the word counts.  There is no one right answer, 
 * but some choices may be easier to work with than others.  As long as the charCount and wordCount methods return the correct value for 
 * all arguments, the internal implementation is up to you.
 * 
 * Altogether the WordCount implementation is worth 250 competency points and 2 proficiency points.
 * 
 */

public interface WC_Interface {
	
	/*
	 * Reads the contents of the given text file.
	 * 
	 * IMPORTANT: Be sure that the data structures that hold the character and word counts
	 * are cleared (made empty) prior to each new file being processed.
	 */
	public void readFile(String filename);
	
	
	/*
	 * Returns the number of times the character ch occurs in all the words in the last read file.
	 * If the letter did not occur, or if ch is not a lower-case alphabetic character, the method 
	 * must return -1.
	 * 
	 * For example, given the following input file:
	 * 
	 *     The medical gentleman walked away to dinner; and the nurse, having once
	 *     more applied herself to the green bottle, sat down on a low chair 
	 *     before the fire, and proceeded to dress the infant.
	 * 
	 * The count for character 'a' is 13
	 * The count for character 'b' is 2
	 * The count for character 'c' is 4
	 * The count for character 'z' is -1
	 * The count for character '?' is -1
	 * 
	 */
	public int charCount(char ch);

	/*
	 * Returns the number of times the word w occurs in the last read file.
	 * If the String w did not occur the method must return -1.
	 * 
	 * For example, given the following input file:
	 * 
	 *     The medical gentleman walked away to dinner; and the nurse, having once
	 *     more applied herself to the green bottle, sat down on a low chair 
	 *     before the fire, and proceeded to dress the infant.
	 * 
	 * The count for word "a" is 1
	 * The count for word "and" is 2
	 * The count for word "the" is 5
	 * The count for word "dinner" is 1
	 * The count for word "bottle" is 1
	 * The count for word "lethargic" is -1
	 * 
	 */
	public int wordCount(String w);

}
