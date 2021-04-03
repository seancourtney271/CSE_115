package code;

public class Driver {
	
	private static WC_Interface wc;

	public static void main(String[] args) {
//		Once you have defined your WordCount class, uncomment the next line:
		wc = new WordCount();
		wc.readFile("Data/Small.txt");
//		The count for character 'a' is 13
//		The count for character 'b' is 2
//		The count for character 'c' is 4
//		The count for character 'z' is -1
//		The count for character '?' is -1
		reportCharCount('a');
		reportCharCount('b');
		reportCharCount('c');
		reportCharCount('z');
		reportCharCount('?');
		reportWordCount("a");
		reportWordCount("and");
		reportWordCount("the");
		reportWordCount("dinner");
		reportWordCount("bottle");
		reportWordCount("lethargic");
		System.out.println("Hi!  How are you?".replaceAll("[^a-z]","") );
		System.out.println("Hi!  How are you?".toLowerCase().replaceAll("[^a-z]","") );
	}

	private static void reportCharCount(char ch) {
		System.out.println("The count for character '"+ch+"' is " + wc.charCount(ch));
	}

	private static void reportWordCount(String w) {
		System.out.println("The count for word \""+w+"\" is " + wc.wordCount(w));
	}

}

