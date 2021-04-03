package code;

import java.util.HashMap;

public class Testing {

	public static void main(String[] args) {
		
        // Instantiate the Models class to access its methods
        Model m = new Model("dictionaries/small.txt");
        
        System.out.println("All words of proper length: " + m.getWords());
        System.out.println("   All words of max length: " + m.getSeedWords());
               
        String seed = "sputnik";
        m.generateWordsToFind(seed);
        HashMap<String,Boolean> wordsToFind = m.getWordsToFind();
        System.out.println("All words to find from 'sputnik' (before guesses): "+wordsToFind);

        System.out.println("checking guess 'puns' yields "+m.checkGuess("puns"));
        System.out.println("checking guess 'pun' yields "+m.checkGuess("pun"));
        System.out.println("checking guess 'spun' yields "+m.checkGuess("spun"));
        System.out.println("checking guess 'pins' yields "+m.checkGuess("pins"));
        System.out.println("checking guess 'pin' yields "+m.checkGuess("pin"));
        System.out.println("checking guess 'spin' yields "+m.checkGuess("spin"));
        System.out.println("checking guess 'antidisestablishmentarianism' yields "+m.checkGuess("antidisestablishmentarianism"));

        System.out.println("All words to find from 'sputnik' (after guesses): "+wordsToFind);
        
        // Add calls to the other methods similar to the above method call to test your code
		
	}
	
}
