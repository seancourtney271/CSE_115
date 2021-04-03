package code;

/**
 * A class with code to run several methods from Utilities to test their functionality
 */
public class Testing {
    
    public static void main(String[] args){
        
        // Instantiate the Utilities class to access its methods
        Utilities utilities = new Utilities();
        
        // Call the avergageRating methods and print the result
        // Verify that that 5.5 is printed to the screen after completing the method
        System.out.println(utilities.averageRating(5,6));
        
        // Add calls to the other methods similar to the above method call to test 
        // your code. You can use the test cases given in the feedback from AutoLab
        
        
    }
}

