package code;

import java.util.HashMap;

public class Testing {

	public static void main(String[] args) {
        // Instantiate the Utilities class to access its methods
        Model m = new Model();
        
        // Create a mapping of place names to their populations
        HashMap<String,Integer> pop = new HashMap<String,Integer>(); 
        pop.put("Tonawanda City", 15130);
        
        // Create a mapping of place names (e.g. "Tonawanda City") to their locations expressed in latitude and longitude points
        HashMap<String,Point2D> loc = new HashMap<String,Point2D>();
		Point2D pt = new Point2D(43.020335, -78.880315);
		loc.put("Tonawanda City", pt);

        // Call the description method and print the result
        // Verify that "Tonawanda City has latitude 43.020335, longitude -78.880315, and has a population of 15130 persons." is printed.
		String s = m.description("Tonawanda City", loc, pop);
		System.out.println(s);
        
        // Add calls to the other methods similar to the above method call to test 
        // your code. You can use the test cases given in the feedback from AutoLab   
		
	}
	
}
