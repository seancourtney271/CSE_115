package code;

import java.util.HashMap;

/*
 * Homework 3, part 1
 * 
 * This homework is the first step to a geography-based application.  It gives you practice with the following
 * concepts:
 * 
 *     loops
 *     conditionals
 *     HashMaps
 * 
 * The methods you write will use:
 * 
 *   HashMap<String,Point2D> - this is a mapping of place names (e.g. "Tonawanda City") to their locations,
 *   expressed in term of latitude and longitude points (this is what the Point2D is used for).
 * 
 *   HashMap<String,Integer> - this is a mapping of place names to their populations.
 * 
 * New classes you will work with this homework include:
 * 
 *   Point2D - a pair of double values which we use to represent points on a map, in latitude and longitude.
 *   A very useful method defined on a Point2D object is called 'distance'.  If a and b are Point2D objects
 *   a.distance(b) returns the distance between the two points (as a double).  The methods a.getX() and a.getY()
 *   return the x and y coordinates of the point a, respectively.
 *   
 *   Integer - an object which holds a primitive int value.  We've seen this idea before: a Character object
 *   holds a primitive char value.  Integer and Character are called wrapper classes - their objects hold values
 *   of the corresponding primitive type.  Every primitive type has a corresponding wrapper class.  The compiler
 *   can generally convert between an Integer and int transparently as needed (and similarly for other wrapper
 *   class - primitive type pairings).
 *   
 *   Autograding will be set up in Autolab no later than Tuesday, October 3.
 * 
 */
public class Model {

	
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
		double lat = 0, longi = 0;
		int pop = 0;
		for(String s: location.keySet()) {
			if (name == s) {
				lat = location.get(s).getX();
				longi = location.get(s).getY();
				pop = population.get(name);
				answer = name + " has latitude " + lat + ", longitude " + longi + ", and has a population of " + pop + " persons.";
			}
		}
		if (lat == 0) {
			answer = "Requested place is unknown: " + name + ".";
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
		double max = Integer.MAX_VALUE;
	    for (String s: location.keySet()) {
	    	double dist =	p.distance(location.get(s));
	    	if(dist < max) {
	    		max = dist;
	    		closest = s;
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
	    double min = Integer.MIN_VALUE;
	    for (String s: location.keySet()) {
	    	 int pop =	population.get(s);
	    	if(pt.distance(location.get(s)) < radius && pop >= min) {
	    		min = pop;
	    		largest = s;
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
		for(String s : location.keySet()) {
			Point2D pt = location.get(s);
			for(String t : location.keySet()) {
				double distcheck = pt.distance(location.get(t));
				if(distcheck > distance) {
					distance = distcheck;
				}
			}
		}
		return distance;
	}
}
