package src;

public class Reviews {

	private LinkedList<Review> reviews;

    public Reviews() {
        reviews = new LinkedList<>();
    }
    
    
    
 // Add a new review
    public void addNewReview(int reviewId, int customerId, int productId, int rating, String comment) {
        Review r = new Review(reviewId, customerId, productId, rating, comment);
        reviews.insert(r);
        System.out.println("Review added successfully.");
    }
    //edit rev باقي 
    
}
