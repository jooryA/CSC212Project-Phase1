package src;

public class Product {
	private int productId;
	private String name;
	private double price;
	private int stock;
	private LinkedList<Review> reviews;  
	
	public Product(int productId, String name, double price, int stock) {   //a constructor
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.stock = stock;
		reviews = new LinkedList<>();
		//add the List after creating reviews class
	   
	}
	
	public void updateProduct(Product p) {       
	this.productId = p.productId;
	this.name = p.name;
	this.price = p.price;
	this.stock = p.stock;
	//copy the reviews as well
	}
	public void insertReview(Review r){
	    reviews.insert(r);
	}
	
	public int getProductId() {
		return productId;
	}


	public String getName() {
		return name;
	}

	
}
