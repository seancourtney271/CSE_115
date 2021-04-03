
	package code;

	import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.Paths;
import java.util.ArrayList;

	public class WordCount  implements WC_Interface{
		private String words[] = null;
		private String[] readAllLines(String filename) {
			ArrayList<String> split = new ArrayList<String>();
			try {
				for (String file: Files.readAllLines(Paths.get(filename))) {
					split.add(file);
			}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			
			return split.toArray(new String[split.size()]);
		}
		
		
		private String[] split(String[] split, String by) {
			ArrayList<String> splited = new ArrayList<String>();
			for(String splitby: split) {
				String splite [] = 	splitby.split(by);
				for(String word: splite) {
					splited.add(word);
				}
				
			}
			return splited.toArray(new String[splited.size()]);
			
		}
		public void readFile(String filename) {
			String[] read = readAllLines(filename);
			String[] notab = split(read, " ");
			for(int i = 0; i< notab.length; i++) {
				String lowercase = notab[i];
			 lowercase = lowercase.toLowerCase();
			 lowercase = lowercase.replaceAll("[^a-z]", "");
			 notab[i] = lowercase;
			}
			words = notab;
		}
		public int charCount(char ch) {
			int count = 0;
			for(String word : words) {
				for(char character: word.toCharArray()) {
					if(character == ch) {
						count++;
					}
				}
			}
			if(count == 0) {
				return -1;
			}
			else {
			return count;
			}
			
		}
		public int wordCount(String w) {
			int count = 0;
			for(String word : words) {
				if(word.equals(w)) {
					count++;
				}
			}
			if(count == 0) {
				return -1;
			}
			else {
			return count;
			}
	}
	}
