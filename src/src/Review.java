package src;

public class Review {

	private int reviewID;
	private int CustomerId;
	private int productID;
	private int rating;
	private String comment;
	
	public Review(int reviewID, int customerID, int productID, int rating, String comment) {
		
		this.reviewID = reviewID;
		this.CustomerId = customerID;
		this.productID = productID;
		this.rating = rating;
		this.comment = comment;
	}
	// Update only rating and comment, keep IDs 
	public void updateReview(Review R) {
	    this.rating = R.rating;
	    this.comment = R.comment;
	}


	public int getReviewID() {
		return reviewID;
	}

	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}

	public int getCustomerID() {
		return CustomerId;
	}

	public void setCustomerID(int customerID) {
		this.CustomerId = customerID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	

	
	public void display() {
		
		
		System.out.println("Review ID :" + reviewID);
		System.out.println("Customer ID :" + CustomerId);
		System.out.println("Product ID :" + productID);
		System.out.println("Rating :" + rating);
		System.out.println("Comment :" + comment);
		
	}


	
}
