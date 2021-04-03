package code;

import java.util.ArrayList;
import java.util.HashMap;

public class Lab4{


    /**
     * 50 competency points
     *
     * Create and return a HashMap containing the following menu items mapped to their prices:
     *
     * "Mac & Cheese": $5.50
     * "Buffalo Mac & Cheese": $7.00
     * "Falafel Pita": $6.50
     * "Tater Tots": $2.00
     *
     * The keys in the HashMap will be of type String and represent the name of each menu item. The values in the
     * HashMap will be the prices of the items.
     *
     * Be sure to add the Strings exactly as the appear including capitalization and spaces.
     *
     * @return A hash map containing the provided menu items and prices
     */
    public HashMap<String, Double> getMenu(){
    	HashMap<String,Double> getMenu = new HashMap<String,Double>();
    	getMenu.put("Mac & Cheese",5.50);
    	getMenu.put("Buffalo Mac & Cheese",7.00);
    	getMenu.put("Falafel Pita",6.50);
    	getMenu.put("Tater Tots",2.00);
        return getMenu; // Replace this return statement with your own
    }


    /**
     * 50 competency points
     *
     * Compute and return price of a customer's order. The order is provided as an ArrayList of Strings with
     * each String being the name of a menu item. You can assume every item in the order is on the menu
     * from the previous method. You should call your getMenu() method to obtain the menu as a HashMap, then use
     * this menu to lookup the price of each item in the order.
     *
     * @param order An ArrayList of Strings containing the menu items to be ordered by a customer
     * @return The total price of the customer's order
     */
    public double getPrice(ArrayList<String> order){
    	HashMap<String,Double> getItem = getMenu();   
		double total = 0;
    	for(int i = 0; i < order.size(); i++){
    		String s = order.get(i);
    		total += getItem.get(s);
    		

    	}
    	

        return total; // Replace this return statement with your own
    }


    /**
     * 50 competency points
     *
     * Return the most expensive (highest price) item in the provided order. Use the menu returned by your
     * getMenu() method to get the price of each item. You can assume every item in the order is on the menu.
     *
     * @param order An ArrayList of Strings containing the menu items to be ordered by a customer
     * @return The name of the most expensive item from the order
     */
    public String mostExpensiveItem(ArrayList<String> order){
    	HashMap<String,Double> getItem3 = getMenu(); 
    	double highestprice = 0;
    	String ratern = "";
    	for (String item : order){
    		double prices = getItem3.get(item);
    		if (prices > highestprice){
    			highestprice = prices;
    		}
    	for (int i = 0; i < order.size(); i++){
    		String r = order.get(i);
    		if(highestprice == getItem3.get(r) ){
    			ratern = r;
    		}
    	}
    	}
        return ratern; // Replace this return statement with your own
    }


    /**
     * 2 proficiency points
     *
     * Return the index of the least expensive (lowest total price) order from the provided orders. These
     * orders are given as an ArrayList of orders where each order is represented as an ArrayList of
     * Strings. These orders can be iterated over just like any other ArrayList. Since you need to return
     * the index of the least expensive order you should use a for loop (not a for-each loop) so you have
     * access to this index.
     *
     * You can assume every item in each order is on the menu.
     *
     * @param mealChoices A list of possible orders that can be made by a customer
     * @return The index of the least expensive order in the ArrayList of orders
     */
    public int cheapestMeal(ArrayList<ArrayList<String>> mealChoices){

        return -1; // Replace this return statement with your own
    }


}

