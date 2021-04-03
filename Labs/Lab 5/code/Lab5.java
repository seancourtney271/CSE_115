package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Lab5{


    /**
     * 50 competency points
     *
     * You are given the name of a file containing the price and volume of a stock on different days.
     * Each line of the file represents this information for a day in the csv format "date,price,volume"
     * where the price is represented by a double and volume is represented as an integer.
     *
     * Reading the file represented by the input filename, create and populate a HashMap where the
     * keys are Strings representing dates and the values are the price of a stock on that date as
     * doubles.
     *
     * Hint: For each line in the csv file you are adding the the first two column into the HashMap
     * where the first value is the key and the second is the value.
     *
     * @param filename The name of the csv file to be read
     * @return A map of dates to prices of the stock read from the file
     */
    public HashMap<String, Double> getPrices(String filename){
    	HashMap<String,Double> stock = new HashMap<String,Double>();
    	try {
    		for(String s: Files.readAllLines(Paths.get(filename))){
    			String [] values = s.split(",");
    			stock.put(values[0], new Double(values[1]) );
    			
    		}
    	}catch (IOException e) {
    		e.printStackTrace();
    	}
        return stock; // Replace this return statement with your own
    }


    /**
     * 50 competency points
     *
     * Given a the name of a file containing information about a stock (same format for all questions)
     * and a String representing a date in the format YYYY-MM-DD, return the price of the stock on
     * the given date.
     *
     * Hint: Call your getPrices method which returns a HashMap of dates to prices, then lookup the
     * given date in the HashMap
     *
     * @param filename The name of the csv file to be read
     * @param date The date to lookup the price of the stock
     * @return The price of the stock on data
     */
    public double getPrice(String filename, String date){
    	HashMap<String,Double> stocks = getPrices(filename);
    	double price = 0.0;
		System.out.println(date);
    	for (String s: stocks.keySet()){
    		//System.out.println(s);
    		if(s.equals(date)){
    			price = stocks.get(s);
    		}
    	}
        return price; // Replace this return statement with your own
    }


    /**
     * 50 competency points
     *
     * Given a the name of a file containing information about a stock (same format for all questions)
     * return the highest price reached by the stock in the file.
     *
     * @param filename The name of the csv file to be read
     * @return The highest price reached by the stock in the file
     */
    public double highestPrice(String filename){
    	HashMap<String,Double> stocks = getPrices(filename);
    	double highestprice = 0.0;
    	double comp = 0.0;
    	for (String s: stocks.keySet()){
    		comp = stocks.get(s);
    		if(highestprice < comp){
    			highestprice = comp;
    		}
    		}
        return highestprice; // Replace this return statement with your own
    }


    /**
     * 2 proficiency points
     *
     * Given a the name of a file containing information about a stock (same format for all questions)
     * return the date (in the format YYYY-MM-DD) when the most value of the stock was traded in the file.
     * We'll define "value traded" on a date as the price of the stock multiplied by its volume.
     *
     * Hint: To check if two Strings are equal you should use the .equals method instead of ==. For example:
     *
     * String x = "hello";
     * String y = "hello";
     * if(x.equals(y)){
     *     System.out.println("hello!");
     * }
     *
     * @param filename The name of the csv file to be read
     * @return The date of the highest value traded as a String in the format YYYY-MM-DD
     */
    public String highestValueTraded(String filename){
    	HashMap<String,Double> stocks = getPrices(filename); // date, price
    	HashMap<String,Double> stock = new HashMap<String,Double>(); // date, volume
    	String rit = "";
    	double highest = 0.0;
    	try {
    		for(String s: Files.readAllLines(Paths.get(filename))){
    			String [] values = s.split(",");
    			stock.put(values[0], new Double(values[2]) );
    			
    		}
    	}catch (IOException e) {
    		e.printStackTrace();
    	}
    	for(String s: stocks.keySet()){
    		double a = stocks.get(s);
    		double b = stock.get(s);
    		double c = a * b;
    	//	System.out.println(a*b);
    	//	System.out.println(s);
    		if (c > highest){
    			rit = s;
    			highest = c;
    		}
    		
    	}
        return rit; // Replace this return statement with your own
    }


    /**
     * Run this file as a java application to run the following testing code. Verify that your program runs
     * and return the correct value for at least one of the methods before uploading to AutoLab. Testing code
     * will not always be provided and you are strongly encouraged to write your own tests for all assignments.
     */
    public static void main(String[] args){
        Lab5 lab5 = new Lab5();

        HashMap<String, Double> prices = lab5.getPrices("data/GOOG_2016.csv");
        System.out.println("GOOG prices: " + prices);
        System.out.println("Verify that these prices match the data given in GOOG_2016.csv (right click the file -> open with -> text editor)");
        System.out.println();

        double price = lab5.getPrice("data/GOOG_2016.csv", "2016-09-29");
        System.out.println("Price of GOOG on 2016-09-29: " + price);
        System.out.println("Expected price: 775.01001");
        System.out.println();

        double highestPrice = lab5.highestPrice("data/GOOG_2016.csv");
        System.out.println("Highest price of GOOG: " + highestPrice);
        System.out.println("Expected highest price: 813.109985");
        System.out.println();

        String date = lab5.highestValueTraded("data/GOOG_2016.csv");
        System.out.println("Highest value of GOOG traded occured on: " + date);
        System.out.println("Expected date: 2016-02-02");
    }

}
