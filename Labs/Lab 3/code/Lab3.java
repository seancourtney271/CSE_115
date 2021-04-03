package code;

import java.util.ArrayList;

public class Lab3 {
	
	/* 75 COMPETENCY POINTS
	 * Question 1: Define this method so it returns those strings from the ArrayList<String> named list
	 * that contain the String named s.  There are (at least) two ways to do this:
	 * 
	 * 1) use the contains(String) -> boolean method
	 * 
	 * 	  Ex. "Bookkeeper".contains("keep") returns true
	 * 	  Ex. "Bookkeeper".contains("jdgfgj") returns false
	 * 
	 * 2) use the indexOf(String) -> int method
	 * 
	 *    Ex. "Bookkeeper".indexOf("keep") returns 4
	 *    Ex. "Bookkeeper".indexOf("jdgfgj") returns -1
	 *    
	 * Example 1: If list is ["Leela", "Fry", "Zoidberg", "Bender"] and s is "er"
	 * then the answer is ["Zoidberg", "Bender"].
	 * 
	 * Example 2: If list is ["Leela", "Fry", "Zoidberg", "Bender"] and s is "e"
	 * then the answer is ["Leela", "Zoidberg", "Bender"].
	 * 
	 * Example 3: If list is ["Leela", "Fry", "Zoidberg", "Bender"] and s is "xyz"
	 * then the answer is [].
	 * 
	 */
	public ArrayList<String> question1(ArrayList<String> list, String s) {
		ArrayList<String> answer = new ArrayList<String>();
		int compare = 0;
		for (int i = 0; i <= list.size() - 1; i++){
			compare = list.get(i).indexOf(s);
			if (compare > 0){
				answer.add(list.get(i));
		}
		}
		return answer;  // edit this method to return the correct value in answer
	}

	/* 75 COMPETENCY POINTS
	 * Question 2: 
	 * 
	 * Compute the sum of the lengths of the Strings at every other index,
	 * starting at index start.
	 * If there are no Strings at odd indices (i.e. if the size of
	 * the list is zero or one), return -1.
	 * 
	 * Example 1: If list is ["Leela", "Fry", "Zoidberg", "Bender"] and start is 1
	 * then the answer is 9, because "Fry" is at index 1 and has length 3,
	 * while "Bender" is at index 3 and has length 6.
	 * 
	 * Example 2: If list is ["Leela", "", "Zoidberg"] and start is 1
	 * then the answer is 0, because "" is at index 1 and has length 0.
	 * 
	 * Example 3: If list is ["Leela", "", "Zoidberg"] and start is 2
	 * then the answer is 8, because "Zoidberg" is at index 2 and has length 8.
	 * 
	 * Example 4: If list is ["Leela"] and start is 2
	 * then the answer is -1, because there are no Strings at or after index 2.
	 * 
	 */
	public int question2(ArrayList<String> list, int start) {
		int r = 0;
		for (int i = start; i < list.size(); i = i + 2){
			String s = (list.get(i));
			r += s.length();
		}
		if (r == 0){
			r = -1;
		}
		return r;  // edit this method to return the correct value
	}
	
	/* 2 PROFICIENCY POINT
	 * Question 3: 
	 * 
	 * If the list has a String that contains the String s, then return
	 * the highest index of such a String.
	 * If the list does not have such a String, return -1. 
	 * 
	 * Example 1: If list is ["Leela", "Fry", "Zoidberg", "Bender"] and s is "er"
	 * then the answer is 3.
	 * 
	 * Example 2: If list is ["Leela", "Fry", "Zoidberg", "Bender"] and s is "y"
	 * then the answer is 1.
	 * 
	 * Example 3: If list is ["Leela", "Fry", "Zoidberg", "Bender"] and s is "xyz"
	 * then the answer is -1.
	 */	
	public int question3(ArrayList<String> list, String s) {
		int r = 0;
		int sas = 0;
		for (int i = 0; i < list.size();i++){
			r = (list.get(i).indexOf(s));
			if(sas < r){
			sas = r;
			}
		}
		if(sas == 0){
			sas = -1;
		}
		return sas;  // edit this method to return the correct value
	}
}

