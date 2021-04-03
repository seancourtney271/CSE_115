package code;

public class Lab1 {
	
	/*
	 * GENERAL INTRODUCTION
	 * 
	 * In this coding exercise you will use these concepts and skills introduced in lecture to solve some
	 * real-world problems:
	 * 
	 *  	variables
	 *  	expressions
	 *  	methods
	 * 
	 * 
	 * PROBLEM STATEMENT
	 * 
	 * An on-line retailer ships goods to customers and charges for shipping by weight (in grams).
	 * 
	 * You will write three methods, whose inputs and outputs are described below, that will
	 * compute the shipping costs for a package that whose weight is measured in lbs and oz.
	 * 
	 */

	/* 
	 * METHOD 1: Converting pounds and ounces to ounces
	 * 50 competency points
	 * 
	 * This method takes in a weight expressed in pounds (lbs) and ounces (oz) 
	 * and returns the equivalent weight in ounces.
	 * 
	 * The inputs to the method are:
	 * 		lbs - the number of pounds
	 * 		oz  - the number of ounces
	 * 
	 * A pound is equal to sixteen ounces.  To convert a weight expressed in 
	 * pounds and ounces to just ounces, multiply lbs by sixteen and add oz.
	 * Return the result.
	 * 
	 */
	public int question1(int lbs, int oz) {
		int convertedWeight = (16 * lbs) + oz;
		return convertedWeight;  // change the return value!
	}

	/* 
	 * METHOD 2: Converting ounces to grams
	 * 50 competency points
	 * 
	 * This method takes in a weight expressed in ounces (oz) 
	 * and returns the (approximate) equivalent weight in grams.
	 * 
	 * The input to the method is:
	 * 		oz  - the number of ounces
	 * 
	 * An ounce is equal to 28.3495 grams.  Since we have not yet talked about
	 * numbers other than integers, we will approximate and say that one ounce
	 * converts as 28 grams.
	 */
	public int question2(int oz) {
		int gram = 28 * oz;
		return gram;  // change the return value!
	}
	
	/* 
	 * METHOD 3: Computing a shipping cost 
	 * 50 competency points
	 * 
	 * This method computes the shipping cost for a package of a given weight,
	 * expressed in grams.  The vendor imposes a minimum charge of $2.00 (which
	 * we will express as 200 cents.
	 * 
	 * This method takes in a weight expressed in in grams (g) and returns the
	 * shipping cost in cents.
	 * 
	 * The input to the method is:
	 * 		g  - the number of grams
	 * 
	 * The total shipping cost will be $2.00 plus one cent for each gram.  For
	 * example, a 3 gram package will cost 203 cents to ship, whereas a 250 gram
	 * package will cost 450 cents.
	 * 
	 */
	public int question3(int g) {
		int totalCost = g + 200;
		return totalCost;  // change the return value!
	}

	/*
	 * METHOD 4: Computing shipping cost from pounds and ounces
	 * 2 proficiency points
	 * 
	 * This method computes the shipping cost for a package whose weight is expressed
	 * in pounds and ounces, and ALSO prints the shipping cost to the console, following
	 * the format of this example, for a weight of 3 lbs and 7 oz:
	 * 
	 * The cost to ship a package that weighs 3 pounds and 7 ounces is 1740 cents. 
	 * 
	 */	
	public int question4(int lbs, int oz) {
		int totalWeight = (lbs * 16)+ oz;
		int grams = totalWeight * 28;
		int totalCost = grams + 200;
		System.out.print("The cost to ship a package that weighs "+ lbs +" pounds and "+ oz +" ounces is " + totalCost + " cents.");
		return totalCost;  // change the return value!
	}
}
