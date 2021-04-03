package code;

public class City {
	 private String country;
	 private String city;
	 private String region;
	 private int population;
	 private double lat;
	 private double longi;
	 public City (String country, String city, String region, int population, double lat, double longi) {
		 this.country = country;
		 this.city = city;
		 this.region = region;
		 this.population = population;
		 this.lat = lat;
		 this.longi = longi;
	 }
	 public String getCountry () {return this.country;}
	 public String getCity () {return this.city;}
	 public String getRegion () {return this.region;}
	 public int getPopulation () {return this.population;}
	 public double getLatitude () {return this.lat;}
	 public double getLongitude () {return this.longi;}

}
