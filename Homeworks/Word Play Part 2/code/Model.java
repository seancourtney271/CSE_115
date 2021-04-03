package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Model {

	// Determines the maximum length of a word
	private static final int MAXIMUM_WORD_LENGTH = 7;

	// Determines the minimum length of a word
	private static final int MINIMUM_WORD_LENGTH = 3;

	// Holds all words from the dictionary file that have lengths between the max and min, inclusive
	private ArrayList<String> _words;
	
	// Holds all words from the dictionary file that have the max length
	private ArrayList<String> _seedWords;
	
	// Holds all words from _words that must be found by the player
	private HashMap<String,Boolean> _wordsToFind;

	
	/* QUESTION 1
	 * 
	 * The constructor
	 * 
	 * The job of the constructor is to assign sensible initial values to each instance variable.
	 * To _words it should assign the value returned by readDictionaryFromFile, with the filename passed in as argument
	 * To _seedWords it should assign the value returned by filterWordsForLength,  with _words and the maximum word length passed in as arguments
	 * To _wordsToFind it should assign the value null.
	 * 
	 * @param filename - the name of a file of words (a "dictionary file")
	 */
	public Model(String filename) {
		this._words = readDictionaryFromFile(filename);
		_seedWords = filterWordsForLength(_words,MAXIMUM_WORD_LENGTH );
		_wordsToFind = null;
}

	
	/* QUESTION 2
	 * 
	 * This method reads the words from the file specified by filename and returns
	 * an ArrayList<String> containing all the words from that file whose length is
	 * >= MINIMUM_WORD_LENGTH and <= MAXIMUM_WORD_LENGTH.
	 * 
	 * @param filename - the name of a file of words (a "dictionary file")
	 * @return an ArrayList<String> containing words
	 */
	public ArrayList<String> readDictionaryFromFile(String filename) {
		ArrayList<String> a = new ArrayList<String>();
		try {
    		for (String s: Files.readAllLines(Paths.get(filename))) {
    			if(s.length() <= MAXIMUM_WORD_LENGTH && s.length() >= MINIMUM_WORD_LENGTH) {
    				a.add(s);
    			}
    		}
	}
		catch (IOException e) {
    		e.printStackTrace();
    	}
		return a;
	}
	
	
	/* QUESTION 3
	 * 
	 * Generates the set of words that the player needs to find, based on the given seed.
	 * Creates a new HashMap<String,Boolean>, assigns it to _wordsToFind, and enters each such
	 * word into the map, paired with the boolean value false (since none of these words have
	 * yet to be found by the player).
	 * 
	 * HINT: Play the game:  https://www.mindgames.com/game/TextTwist+2
	 * 
	 * The words the player has to find are the words from the dictionary that are anagrams of
	 * the seed word (which is one the the maximum length words).  You wrote a method in part 1
	 * of HW2 which does most of this :-)
	 * 
	 * @param seed - the word whose letters make up the inventory of available letters in the game
	 */
	public void generateWordsToFind(String seed) {
		_wordsToFind = new HashMap<String,Boolean>();
		ArrayList<Character> c = string2charList(seed);
		for(String s: _words) {
			if(anagramOfLetterSubset(s,c)) {
				_wordsToFind.put(s, false);
			}
		}
	}
		
	/* QUESTION 4
	 * 
	 * Checks whether the guess is one of the words to be found.  If so, updates that word's entry
	 * in _wordsToFind so it is paired with true rather than false; the method also returns true in
	 * this case.  If not _wordsToFind is not updated and the method returns false.
	 * 
	 * @param guess - the String being checked to see whether it is one of the words to be found
	 * @return true if guess is a word to be found, false otherwise
	 */
	public boolean checkGuess(String guess) {
		boolean b = false;
		for (String s: _wordsToFind.keySet()) {
			if(guess.equals(s)) {
				b = true; 
				_wordsToFind.put(s, true);
			}
		}
		return b;
	}

	/**
	 * Accessor methods provided for testing purposes
	 * 
	 */
	
	public ArrayList<String> getWords() {
		return _words;
	}

	public ArrayList<String> getSeedWords() {
		return _seedWords;
	}

	public HashMap<String,Boolean> getWordsToFind() {
		return _wordsToFind;
	}

	/** PART 1 **/

	/*                                                                                                                                                                                                                                      
	 * The game will use a dictionary of words.                                                                                                                                                                                             
	 *                                                                                                                                                                                                                                      
	 * The 'starter words' are all supposed to be of a certain length.                                                                                                                                                                      
	 * In the TextTwist2 game the 'starter words' are all of length 7.                                                                                                                                                                      
	 *                                                                                                                                                                                                                                      
	 * Write a method that takes in an ArrayList<String> called list and                                                                                                                                                                    
	 * an int named length and returns a new ArrayList<String> containing                                                                                                                                                                   
	 * the members of list that contain exactly length characters.                                                                                                                                                                          
	 *                                                                                                                                                                                                                                      
	 * For example, is dictionary is an ArrayList<String>, then calling                                                                                                                                                                     
	 *                                                                                                                                                                                                                                      
	 *     filterWordsForLength(dictionary, 7)                                                                                                                                                                                              
	 *                                                                                                                                                                                                                                      
	 * will produce an ArrayList<String> of seven-letter words.                                                                                                                                                                             
	 *                                                                                                                                                                                                                                      
	 */
	public ArrayList<String> filterWordsForLength(ArrayList<String> words, int length) {
		ArrayList<String> answer = new ArrayList<String>();
		for(int i = 0; i < words.size(); i++) {
			if(words.get(i).length()==length) {
				answer.add(words.get(i));
			}
		}
		return answer;
	}

	/*                                                                                                                                                                                                                                      
	 * This method accepts a String as input and returns an ArrayList<Character> consisting of                                                                                                                                              
	 * the characters from the String word.                                                                                                                                                                                                 
	 *                                                                                                                                                                                                                                      
	 * N.B. Character is a new type for us.  A Character represents a single character from a String.                                                                                                                                       
	 *                                                                                                                                                                                                                                      
	 * Note that word.charAt(i) returns a value that can be directly added to an ArrayList<Character>                                                                                                                                       
	 * using the add method of the ArrayList<Character>.                                                                                                                                                                                    
	 *                                                                                                                                                                                                                                      
	 * For example, string2charList("Wilma") must yield the ArrayList<Character> that prints as [W, i, l, m, a]                                                                                                                             
	 *                                                                                                                                                                                                                                      
	 */
	public ArrayList<Character> string2charList(String word) {
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i = 0; i < word.length(); i++) {
			list.add(word.charAt(i));
		}
		return list;
	}

	/*                                                                                                                                                                                                                                      
	 * This method determines whether or not a given String is an anagram of some subset of the                                                                                                                                             
	 * letters in the ArrayList<Character>.                                                                                                                                                                                                 
	 *                                                                                                                                                                                                                                      
	 * See:                                                                                                                                                                                                                                 
	 *              http://www.dictionary.com/browse/anagram                                                                                                                                                                                
	 *                                                                                                                                                                                                                                      
	 * The basic idea here is that we'll loop through each character in word, and remove each word from                                                                                                                                     
	 * the ArrayList<Character>.  The remove method of the ArrayList removes ONE occurrence from the                                                                                                                                        
	 * list.                                                                                                                                                                                                                                
	 *                                                                                                                                                                                                                                      
	 * Example:  Suppose list is the ArrayList<String> that prints as [b, o, o, k, k, e, e, p, e, r]                                                                                                                                        
	 * then list.remove('e') changes list to [b, o, o, k, k, e, p, e, r].                                                                                                                                                                   
	 * Calling list.remove('e') again changes list to [b, o, o, k, k, p, e, r].                                                                                                                                                             
	 *                                                                                                                                                                                                                                      
	 * The remove method returns a boolean value.  If the call changes the contents of the ArrayList the                                                                                                                                    
	 * method returns true.  If calling the method does not change the ArrayList then the method                                                                                                                                            
	 * returns false.                                                                                                                                                                                                                       
	 *                                                                                                                                                                                                                                      
	 * HINT: because this method will remove characters from ArrayList<Character> it is working with,                                                                                                                                       
	 * it is important to make a copy of what's in reference before using it.  Write a loop that copies                                                                                                                                     
	 * the contents of reference to a new ArrayList<Character>.                                                                                                                                                                             
	 *                                                                                                                                                                                                                                      
	 */
	public boolean anagramOfLetterSubset(String word, ArrayList<Character> reference) {
		ArrayList<Character> initial = string2charList(word);
		ArrayList<Character>compare = new ArrayList<Character>();
		for (int i=0; i<reference.size(); i=i+1) {
			compare.add(reference.get(i));
		}
		for(int i = 0; i < initial.size(); i++) {
			if(!compare.remove(initial.get(i))) {
				return false;
			}
		}
		return true;  // change the value returned                                                                                                                                                                                      
	}

	/*                                                                                                                                                                                                                                      
	 * This method takes a word (a String) and a dictionary of words (an ArrayList<String>) and returns                                                                                                                                     
	 * a collection of words (a HashSet<String>) that are anagrams of some subset of the letters in word.                                                                                                                                   
	 *                                                                                                                                                                                                                                      
	 * Put another way, this method finds all the words or length at least 2 that can be played from the                                                                                                                                    
	 * letters in word.                                                                                                                                                                                                                     
	 *                                                                                                                                                                                                                                      
	 * HashSet is a collection that, for our purposes in this homework, behaves like an ArrayList with                                                                                                                                      
	 * the following exception:                                                                                                                                                                                                             
	 *              calling add(X) on a HashSet adds X only if X is not already in the collection                                                                                                                                           
	 * In other words, HashSet does not allow duplicate entries.  Because HashSet does not allow duplicates                                                                                                                                 
	 * we get unique words in the result.                                                                                                                                                                                                   
	 *                                                                                                                                                                                                                                      
	 * HINT: in defining this method you should find a natural use for both string2charList and also                                                                                                                                        
	 * anagramOfLetterSubset.                                                                                                                                                                                                               
	 */
	public HashSet<String> possibleWords(String word, ArrayList<String> dictionary) {
		HashSet<String> words = new HashSet<String>();
		for(int i = 0; i < dictionary.size();i++) {
			if(anagramOfLetterSubset(dictionary.get(i),string2charList(word))){
				/*if(words.remove(dictionary.get(i))) {                                                                                                                                                                         
                                            words.add(dictionary.get(i));                                                                                                                                                                   
                            }*/
				words.add(dictionary.get(i));
			}
		}
		return words;
	}

}
