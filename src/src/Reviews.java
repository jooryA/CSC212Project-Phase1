package src;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Reviews {

	private LinkedList<Review> reviews;
	private Products products;
	private Customers Customers;
	
	
	public Reviews() {
		reviews = new LinkedList<>();
		products = new Products();
		Customers = new Customers();

	}
	public Reviews(LinkedList<Review> reviews, LinkedList<Product> Tproducts, LinkedList<Customer> Tcustomers) {

		this.reviews = reviews;
		products = new Products(Tproducts);
		Customers = new Customers(Tcustomers);
	}

	

	public Review searchReviewtById(int id) {
		if (reviews.empty())
			return null; // No Reviews in the list
		else {
			reviews.findfirst();
			while (!reviews.last()) { // Looping from the first Review till the one before the last
				if (reviews.retrieve().getReviewID() == id)
					return reviews.retrieve();
				reviews.findnext();
			}

			if (reviews.retrieve().getReviewID() == id) // For the last Review in the list
				return reviews.retrieve();

			return null; // If there's no Review in the list matches the id
		}
	}

	public void AttachReviewToproduct(Review r) {
		Product p = products.searchProductById(r.getProductID());
		if (p == null)
			System.out.println("No Reviews Found");
		else
			p.insertReview(r);
		;
	}

	public void AttachReviewToCustomer(Review r) {
		Customer c = Customers.SearchCustomerById(r.getCustomerID());
		if (c == null)
			System.out.println("No Reviews Found");
		else
			c.addReview(r);
	}

	// Add a new review
	public void addNewReview(Review R) {
		if (searchReviewtById(R.getReviewID()) == null) {
			reviews.insert(R);
			AttachReviewToproduct(R);
			AttachReviewToCustomer(R);

			System.out.println("Added Successfully, Review ID: " + R.getReviewID());
		} else
			System.out.println("Review ID: " + R.getReviewID() + " Already exists");

	}

	public void updateReview(int id, Review p) {
		Review rev = searchReviewtById(id);
		if (rev != null) {
			rev.updateReview(p);
			System.out.println("Review is updated successfully ");
		} else
			System.out.println("Review with this Id does not exist.");
	}

	public void displayReview() {
		if (reviews.empty()) {
			System.out.println("No Reviews found ");
			return;
		}

		reviews.findfirst();
		while (!reviews.last()) { // display all Reviews until the last Review ( last one not included)
			Review d = reviews.retrieve();
			d.display();
		}
		Review d = reviews.retrieve();// displays the last Review
		d.display();
	}

	public LinkedList<Review> getReviews() {
		return reviews;
	}

	public void setReviews(LinkedList<Review> reviews) {
		this.reviews = reviews;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public Customers getCustomers() {
		return Customers;
	}

	public void setCustomers(Customers customers) {
		Customers = customers;
	}
	
	
	
	public void loadOrders(String fileName) {
	    try {
	        File file = new File(fileName);
	        Scanner read = new Scanner(file);
	        System.out.println("Reading File: " + fileName);
	        
	        if (read.hasNextLine()) {
	            read.nextLine(); // Skip the header line
	        }

	        while (read.hasNextLine()) {
	            String line = read.nextLine().trim();
	            if (!line.isEmpty()) {//read the data 

	            String[] a = line.split("," , 5);
	            int reviewID= Integer.parseInt(a[0].trim());
	            int customerID =Integer.parseInt(a[2].trim());
	            int productID = Integer.parseInt(a[1].trim());
	            int rating = Integer.parseInt(a[3].trim());
	            String comment = a[4];


	        	Review r= new Review( reviewID,  customerID,  productID,  rating, comment);
	            reviews.insert(r);

	           	        }}

	        read.close();
	        System.out.println(" File loaded successfully from file: " + fileName);

	    } catch (Exception e) {
	        System.out.println("Error reading orders file: " + e.getMessage());
	    }
	}
}
