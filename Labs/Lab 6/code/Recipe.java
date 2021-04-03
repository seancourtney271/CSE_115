package code;

/**
 * You are given a partial definition of a Recipe class. Your task is to complete this class by 
 * writing a constructor and 3 getter methods for the 3 instance variables
 */
public class Recipe {

    // Do not edit these variables
    private String name;
    private String ingredientOne;
    private String ingredientTwo;

    
    // 15 Competency Points
    // Write a public constructor for the Recipe class that takes 3 Strings as parameters. In the constructor, set 
    // the first parameter to the name instance variable, the second to ingredientOne, and the third to 
    // ingredientTwo
    public Recipe (String name, String ingredientOne, String ingredientTwo){
        this.name = name;
        this.ingredientOne = ingredientOne;
        this.ingredientTwo = ingredientTwo;
    }

    // 15 Competency Points
    // Write a public method named getName that doesn't take any parameters and has return type String. This 
    // method should return the value of the name instance variable
    public String getName (){return this.name;}

    // 15 Competency Points
    // Write a public method named getIngredientOne that doesn't take any parameters and has return type String. This 
    // method should return the value of the ingredientOne instance variable
    public String getIngredientOne (){return this.ingredientOne;}
    
    // 15 Competency Points
    // Write a public method named getIngredientTwo that doesn't take any parameters and has return type String. This 
    // method should return the value of the ingredientTwo instance variable
    public String getIngredientTwo (){return this.ingredientTwo;}
}
