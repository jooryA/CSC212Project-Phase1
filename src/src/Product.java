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
	}
	
	public void updateProduct(Product p) {       
	this.productId = p.productId;
	this.name = p.name;
	this.price = p.price;
	this.stock = p.stock;
	this.reviews = p.reviews;
	}
	
	public double getAverageRating() {
		if(reviews.empty())
			return 0;
		double sum = 0;
		int count =0;
		reviews.findfirst();
		while(!reviews.last()) {
			sum+=reviews.retrieve().getRating();
			count++;
			reviews.findnext();
		}
		sum+=reviews.retrieve().getRating();
		count++;
		
		return sum/count;
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

	public int getStock() {
		return stock;
	}
	
	
	
}
