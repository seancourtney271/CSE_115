package code.ratables;

public class Product extends Ratable {
	public Product(String s) {
		id = s;
	}
	public String getLink(){return "https://www.amazon.com/dp/" + id ;}
	public String getDescription() {return id;}
}
