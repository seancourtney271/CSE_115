package code;

import java.util.ArrayList;
import java.util.HashSet;

public class Model {

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
		for (String s : words) {
			if (s.length() == length) {
				answer.add(s);
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
			char c = word.charAt(i);
			list.add(c);
		}
		return list;
	}
	
	/*
	 * This method determines whether or not a given String is an anagram of some subset of the 
	 * letters in the ArrayList<Character>.
	 * 
	 * See:
	 * 		http://www.dictionary.com/browse/anagram
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
		boolean finish = false;
		boolean check = false;
		for (int i = 0; i < word.length(); i++) {
		 check = reference.remove((Object)word.charAt(i));
		 if (check == true) {
			 finish = true;
		 }
		 else {
			 finish  = false;
			 break;
		 }
		}
		if(reference.size() < word.length()) {
		finish = false;
		}
		return finish;  // change the value returned
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
	 * 		calling add(X) on a HashSet adds X only if X is not already in the collection
	 * In other words, HashSet does not allow duplicate entries.  Because HashSet does not allow duplicates
	 * we get unique words in the result.
	 * 
	 * HINT: in defining this method you should find a natural use for both string2charList and also
	 * anagramOfLetterSubset.
	 */
	public HashSet<String> possibleWords(String word, ArrayList<String> dictionary) {
	HashSet<String> words = new HashSet<String>();
	ArrayList<Character> converttoChar = string2charList(word);
	for(String s: filterWordsForLength(dictionary, 1)) {
		dictionary.remove(s);
	}
	for (String ss: dictionary) {
		if(anagramOfLetterSubset(ss,converttoChar)) {
		words.add(ss);
		}
	}
	
	//ArrayList<Character> list = new ArrayList<Character>();
	
	//list = string2charList(word);
	//	for(int i = 0; i < dictionary.size(); i++) {
	//		String q = dictionary.get(i);
	//		if (anagramOfLetterSubset(q,list)) {
	//			words.add(q);
	//		}
	//		else {
				
	//		}
				
	//	}
			//for(String s : dictionary) {
			//boolean b = anagramOfLetterSubset(s,list);
			//if (b == true) {
			//	dictionary.remove(s);
			
		
	
		return words;
	}
	
}

