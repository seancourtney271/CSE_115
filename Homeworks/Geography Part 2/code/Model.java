package code;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import code.Point2D;

/*
 * Homework 3, part 2
 * 
 * This homework is the second step to a geography-based application and will
 * give you practice with the following concepts:
 * 
 *     reading data from a file
 *     structuring data
 *     filtering data
 * 
 * In this homework you will work with a real-world data set that contains
 * approximately 48,000 city names, locations, and populations from around
 * the world.  The data is in the WorldCitiesPop.csv file in the Data folder.
 * 
 * Each line of this file has the following structure:
 *     Country,City,AccentCity,Region,Population,Latitude,Longitude
 *
 * THE City CLASS
 * ==============
 * You will need to keep all the data for a City together in one place. To do
 * this you define a City class that has an instance variable for the following
 * fields:
 * 
 *     Country - store this as a String
 *     City - store this as a String
 *     Region - store this as a String
 *     Population - store this as an int
 *     Latitude - store this as a double
 *     Longitude - store this as a double
 * 
 * Notice that AccentCity is missing - you may safely ignore this field.
 * 
 * The City class must have a constructor that accepts these values as Strings, 
 *      Country, City, Region, Population, Latitude, Longitude
 * and initializes the above instance variables as expected.
 * 
 * Define also a simple accessor method for each of the instance variables. 
 * 
 * THE CityPair CLASS
 * ==================
 * Sometimes you need to work with pairs of cities rather than just individual
 * cities.  The CityPair class has a constructor that takes two City objects and
 * stores each in its own instance variable.
 * 
 * The CityPair class also must have accessors for the two cities in the pair:
 * 
 *     public City cityOne()
 *     public City cityTwo()
 * 
 * 
 * THE MODEL CLASS
 * ===============
 * Define, in the class Model the following methods:
 * 
 * 		ArrayList<City> readDataFromCSV(String filename)
 *     This method reads the data from the indicated filename and returns a few ArrayList<City> containing the data
 *     read in from the file.
 * 
 * 		ArrayList<City> filterByCountry(String country, ArrayList<City> cities) 
 *     This method builds and returns a new ArrayList containing those City objects that are in the indicated country.
 *     If there are no cities in the requested country the ArrayList returned is empty. 
 * 
 * 		ArrayList<City> filterByRegion(String region, ArrayList<City> cities) 
 *     This method builds and returns a new ArrayList containing those City objects that are in the indicated region
 *     If there are no cities in the requested region the ArrayList returned is empty.
 *     
 * 		ArrayList<City> filterByMinimumPopulation(int minimumPopulation, ArrayList<City> cities) 
 *     This method builds and returns a new ArrayList containing those City objects that have a population greater
 *     than or equal to minimumPopulation.  If there are no cities in the with the requested population the ArrayList
 *     returned is empty. 
 * 
 * 		ArrayList<City> filterByMaximumPopulation(int maximumPopulation, ArrayList<City> cities) 
 *     This method builds and returns a new ArrayList containing those City objects that have a population less
 *     than or equal to maximumPopulation.  If there are no cities in the with the requested population the ArrayList
 *     returned is empty. 
 * 
 * 		CityPair furthestApart(ArrayList<City> cities)
 *     This method returns a CityPair containing the two City objects that are furthest apart in the cities ArrayList.
 *     
 * 		CityPair clostestTogether(ArrayList<City> cities)
 *     This method returns a CityPair containing the two City objects that are closest together in the cities ArrayList.
 *
 * 		int totalPopulation(ArrayList<City> cities)
 *     This method returns the combined population of all the City objects in the cities ArrayList. 
 * 
 * Autograding will be set up in Autolab soon, likely no than Tuesday, October 24.
 * 
 */

public class Model {
	
	
	public ArrayList<City> readDataFromCSV(String filename){
		 ArrayList<City> c = new ArrayList<City>();
		 int x = 0;
	    	try {
	    		for (String s: Files.readAllLines(Paths.get(filename))) {
	    			if(x>0) {
	    			String ss [] = s.split(",");
	    			int i = new Integer(ss[4]);
	    			double d  = new Double(ss[5]);
	    			double ds  = new Double(ss[6]);
	    			City city  = new City(ss[0],ss[1],ss[3],i,d,ds);
	    			c.add(city);
	    			}
	    			x +=1;
	    			
	    		}
	    	}
	    	catch (IOException e) {
	    		e.printStackTrace();
	    	}
    		return c;
	 }
	public ArrayList<City> filterByCountry(String country, ArrayList<City> cities) {
		 ArrayList <City> c = new ArrayList <City>();
		 for(City a: cities) {
			 String country1 = a.getCountry();
			 if(country1.equals(country)) {
				 c.add(a);
			 }
		 }
		 return c;
	 }
	public ArrayList<City> filterByRegion(String region, ArrayList<City> cities) {
		 ArrayList <City> c = new ArrayList <City>();
		 for(City a: cities) {
			 String region1 = a.getRegion();
			 if(region1.equals(region)) {
				 c.add(a);
			 }
		 }
		 return c;
	 }
	public ArrayList<City> filterByMinimumPopulation(int minimumPopulation, ArrayList<City> cities) {
		 ArrayList <City> c = new ArrayList <City>();
		 for(City a: cities) {
			 int pop = a.getPopulation();
			 if(pop >= minimumPopulation) {
				 c.add(a);
			 }
		 }
		 return c;
	 }
	public ArrayList<City> filterByMaximumPopulation(int maximumPopulation, ArrayList<City> cities) {
		 ArrayList <City> c = new ArrayList <City>();
		 for(City a: cities) {
			 int pop = a.getPopulation();
			 if(pop <= maximumPopulation) {
				 c.add(a);
			 }
		 }
		 return c;
	 }
	public CityPair furthestApart(ArrayList<City> cities) {
		City cityone = null;
		City citytwo = null;
		double distance = 0.0;
		 for(City a: cities) {
			double latA = a.getLatitude();
			double longiA = a.getLongitude();
			Point2D pointA = new Point2D (latA,longiA);
			for (City b: cities) {
				double latB = b.getLatitude();
				double longiB = b.getLongitude();
				Point2D pointB = new Point2D (latB,longiB);
					if (pointA.distance(pointB) > distance) {
						distance = pointA.distance(pointB);
						cityone = a;
						citytwo = b;
					}
			}
	 }
		 CityPair a = new CityPair (cityone, citytwo);
		 return a;
	 }
	public CityPair clostestTogether(ArrayList<City> cities) {
		 City cityone = null;
			City citytwo = null;
			double distance = Double.MAX_VALUE;
			 for(City a: cities) {
				double latA = a.getLatitude();
				double longiA = a.getLongitude();
				Point2D pointA = new Point2D (latA,longiA);
				for (City b: cities) {
					if(!a.equals(b)) {
					double latB = b.getLatitude();
					double longiB = b.getLongitude();
					Point2D pointB = new Point2D (latB,longiB);
						if (pointA.distance(pointB) < distance) {
							distance = pointA.distance(pointB);
							cityone = a;
							citytwo = b;
						}
					}
				}
		 }
			 CityPair a = new CityPair (cityone, citytwo);
			 return a;
	 }
	public int totalPopulation(ArrayList<City> cities) {
		 int totalpopulation = 0;
		 for(City c: cities) {
			 int a = c.getPopulation();
			 totalpopulation += a;
		 }
		 return totalpopulation;
	 }

	/*
	 * DESCRIBING A PLACE
	 * 
	 * Given:
	 *     a String, the name of place,
	 *     a HashMap<String,Point2D> containing a place name to location mapping, and 
	 *     a HashMap<String,Integer> containing a place name to population mapping,
	 * return a String that describes that place as in the example below.
	 * 
	 * You may assume that if there is an entry for String in either of the two HashMaps, then 
	 * there is an entry for that String in both.
	 * 
	 * If there is no entry for the String in either HashMap, return the string
	 *     "Requested place is unknown: <placename>."
	 * where <placename> is replaced by the requested place name. 
	 * 
	 * Suppose we know the following about Tonawanda City:
	 * 
	 * 	   Tonawanda City is at 43.020335,-78.880315, according to http://www.itouchmap.com/latlong.html
	 *     The population of Tonawanda City is 15,130 (https://en.wikipedia.org/wiki/Tonawanda_(city),_New_York)
	 *     
	 * Assuming that "Tonawanda City" has an entry in both HashMaps, reflecting this information, the String
	 * returned must be:
	 * 
	 *     "Tonawanda City has latitude 43.020335, longitude -78.880315, and has a population of 15130 persons."
	 *     
	 * For example, assuming that "Omicron Persei 8" does not exist in either HashMap, the String
	 * returned must be:
	 * 
	 *     "Requested place is unknown: Omicron Persei 8."   
	 */
	public String description(String name, HashMap<String,Point2D> location, HashMap<String, Integer> population) {
		String answer = "";
		if (location.containsKey(name)) {
			Point2D loc = location.get(name);
			int pop = population.get(name);
			answer = name + " has latitude "+loc.getX()+", longitude "+loc.getY()+", and has a population of "+pop+" persons.";
		}
		else {
			answer = "Requested place is unknown: "+name+".";
		}
		return answer;
	}
	
	
	/*
	 * FIND THE CLOSEST PLACE
	 * 
	 * Given:
	 *     a Point2D, representing a location, and 
	 *     a HashMap<String,Point2D>, containing a place name to location mapping, 
	 * return a String that gives the place name of the closest place to that location from the HashMap.
	 * 
	 * You may assume that the HashMap has at least one entry - this means that there is
	 * in fact a closest place!
	 * 
	 * HINT: Use a figure larger than the Earth's equatorial circumference to seed the closest distance.
	 * https://www.space.com/17638-how-big-is-earth.html
	 * 
	 * HINT: Remember that you can obtain the set of keys for which the HashMap has entries by calling
	 * the keySet() method on the HashMap.
	 * 
	 * HINT: Keep track of both the shortest distance you've come across so far and the name of that place
	 * as you iterate through the loop.
	 */
	public String closestToPoint(Point2D p, HashMap<String, Point2D> location) {
		String closest = "";
		double distance = 25000.0;
		for (String name : location.keySet()) {
			Point2D loc = location.get(name);
			double x = p.distance(loc);
			if (x < distance) {
				distance = x;
				closest = name;
			}
		}
		return closest;
	}
	
	/*
	 * FIND THE LARGEST PLACE WITHIN RADIUS
	 * 
	 * Given:
	 *     a Point2D, a location, 
	 *     a double, a radius, 
	 *     a HashMap<String,Point2D> containing a place name to location mapping, and
	 *     a HashMap<String,Integer> containing a place name to population mapping,
	 * return a String that gives the place name of the most populous place within the given radius to the given location.
	 * 
	 * If there is no place within the radius of the given location, return an empty String, "".
	 * 
	 * HINT: Remember that you can obtain the set of keys for which the HashMap has entries by calling
	 * the keySet() method on the HashMap.
	 * 
	 * HINT: Keep track of both the largest population you've come across so far and the name of that place
	 * as you iterate through the loop.
	 */
	public String largestToPoint(Point2D pt, double radius, HashMap<String, Point2D> location, HashMap<String,Integer> population) {
		String largest = "";
		int pop = 0;
		for (String name : location.keySet()) {
			Point2D loc = location.get(name);
			double x = pt.distance(loc);
			if (x < radius) {
				int p = population.get(name);
				if (p > pop) {
					largest = name;
					pop = p;
				}
			}
		}
		return largest;
	}
	
	/*
	 * FIND THE LONGEST DISTANCE BETWEEN A HASHMAP OF PLACES
	 * 
	 * Given:
	 *     a HashMap<String,Point2D> containing a place name to location mapping
	 * return a double, containing the maximum distance between any two points in the HashMap.
	 * 
	 * For example:
	 * Tonawanda City has latitude 43.020335, longitude -78.880315, and 
	 * Davis Hall has latitude 43.00277, longitude -78.78731, and the distance between them is 
	 * 0.09464913760831883.  If these were the two most distant points in the HashMap the method
	 * should return 0.09464913760831883.
	 * 
	 * If there are fewer than two entries in the HashMap, return 0.0.
	 * 
	 * HINT: Remember that you can obtain the set of values for which the HashMap has keys by calling
	 * the values() method on the HashMap.
	 * 
	 * HINT: Use a loop within a loop, a so-called nested loop, to check all pairs of points in the HashMap.
	 */
	public double longestDistance(HashMap<String, Point2D> location) {
		double distance = 0.0;
		for (Point2D loc1 : location.values()) {
			for (Point2D loc2 : location.values()) {
				if (loc1.distance(loc2) > distance) {
					distance = loc1.distance(loc2);
				}
			}
		}
		return distance;
	}
}
