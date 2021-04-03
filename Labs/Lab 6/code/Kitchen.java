package code;

import java.util.ArrayList;

/**
 * You are given an empty Kitchen class that will be written entirely by you. You will write an instance 
 * variable, a constructor, and several methods in this class.
 * 
 * It is recommended that you start with the Recipe class.
 */
public class Kitchen {
    
    
    // 15 Competency Points
    // Create a private instance variable with type ArrayList of String named ingredients
    private ArrayList<String> ingredients;

    // 15 Competency Points
    // Write a public constructor that doesn't take any parameters and initializes the ingredients variable
    // to a new ArrayList
    public Kitchen() {this.ingredients = new ArrayList<String>();}
    
    // 15 Competency Points
    // Write a public method named addIngredient that takes one String as a parameter and has return type void.
    // This method will add the input String to the ingredients ArrayList
    public void addIngredient (String a){ingredients.add(a);}
    
    // 15 Competency Points
    // Write a public method named removeIngredient that takes one String as a parameter and has return type void.
    // This method will remove one instance of the input String from the ingredients ArrayList.
    // If the input is not in the ArrayList this method will have no effect
    // Hint: The ArrayList class has a remove method
    public void removeIngredient (String a){ingredients.remove(a);}
    
    // 15 Competency Points
    // Write a public method named containsIngredient that takes one String as a parameter and has return type boolean.
    // This method will return true if the input String is in the ingredients ArrayList and false if it is not
    public boolean containsIngredient(String e) {
    	boolean ratern = false;
    	for (String a: ingredients){
    		if(a.equals(e)){
    			ratern = true;
    		}
    	}
    	return ratern;
    }
    
    // 15 Competency Points
    // Write a public method named getQuantity that doesn't take any parameters and has return type int.
    // This method will return the total number of ingredients in this kitchen
    public int getQuantity (){return ingredients.size();}
   
    
    
    // 1 Proficiency Point (Due 24 hours after the end of lab)
    // Write a public method named canCook that takes a Recipe as a parameter and has return type boolean.
    // This method will true if this Kitchen contains both ingredients in the recipe, false otherwise
    public boolean canCook (Recipe a){
    	boolean q = false;
    	boolean u = false;
    	boolean quinn = false;
    	for(String e: ingredients){
    		if(a.getIngredientOne().equals(e)){
    			q = true;
    		}
    		if(a.getIngredientTwo().equals(e)){
    			u = true;
    		}
    	}
    	if(q == true && u == true){
    		quinn = true;
    	}
    	return quinn;
    }
    
    // 1 Proficiency Point (Due 24 hours after the end of lab)
    // Write a public method named cook that takes a Recipe as a parameter and has return type void.
    // If the recipe can be cooked, this method will remove one of each of the ingredients in the recipe.
    // If the recipe can not be cooked, this method will have no effect.
    public void cook (Recipe a){
    boolean b = canCook(a);
    if (b == true){
    	ingredients.remove(a.getIngredientOne());
    	ingredients.remove(a.getIngredientTwo());
    }
    }
    
}
