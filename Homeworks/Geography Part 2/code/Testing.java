package code;

public class Testing {

	public static void main(String[] args) {
        // Instantiate the Utilities class to access its methods
        Model m = new Model();
        System.out.println(m.readDataFromCSV("Data/WorldCitiesPop.csv"));
	}
	
}
