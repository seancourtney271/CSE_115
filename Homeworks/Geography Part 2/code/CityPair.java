package code;

public class CityPair {
	private City cityOne;
	private City cityTwo;
	public CityPair (City a, City b) {
		this.cityOne = a;
		this.cityTwo = b;
	}
	public City cityOne () {return this.cityOne;}
	public City cityTwo () {return this.cityTwo;}
}
