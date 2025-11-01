package src;

public class Product {
	private int productId;
	private String name;
	private double price;
	private int stock;
	//private LinkedList<> reviews;   after adding the reviews class
	
	public Product(int productId, String name, double price, int stock) {   //a constructor
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.stock = stock;
		//add the List after creating reviews class
	   
	}
	
	public void updateProduct(Product p) {       
	this.productId = p.productId;
	this.name = p.name;
	this.price = p.price;
	this.stock = p.stock;
	//copy the reviews as well
	}
	
	public int getProductId() {
		return productId;
	}


	public String getName() {
		return name;
	}

	
}
