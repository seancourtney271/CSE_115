package code;

import java.util.ArrayList;

public class Testing {

	public static void main(String[] args) {
		
        // Instantiate the Models class to access its methods
        Model m = new Model("dictionaries/small.txt");
        // Add calls to the other methods similar to the above method call to test your code
        ArrayList<Character> a = new ArrayList<Character>();
        a.add('a');
        a.add('s');
        a.add('d');
        a.add('f');
        a.add('g');
        a.add('h');
        a.add('j');
        a.add('k');
      System.out.println(m.charList2string(a));
	}
	
}
