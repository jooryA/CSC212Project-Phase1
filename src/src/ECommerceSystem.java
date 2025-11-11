package src;
import java.time.LocalDate;
import java.util.Scanner;

//import javax.annotation.processing.SupportedSourceVersion;

import java.time.format.DateTimeFormatter;
public class ECommerceSystem {
	static Scanner input = new Scanner(System.in);

	static LinkedList<Review> ReviewsList;
	static LinkedList<Product> ProductsList;
	static LinkedList<Customer> CustomersList;
	static LinkedList<Order> OrdersList;

	static Reviews AllReviews;
	static Products AllProducts;
	static Customers AllCustomers;
	static Orders AllOrders;

	public ECommerceSystem() {
		ReviewsList = new LinkedList<Review>();
		ProductsList = new LinkedList<Product>();
		CustomersList = new LinkedList<Customer>();
		OrdersList = new LinkedList<Order>();

		// creates an objects and initializes its LinkedList

		AllReviews = new Reviews(ReviewsList, ProductsList, CustomersList);
		AllProducts = new Products(ProductsList);
		AllCustomers = new Customers(CustomersList);
		AllOrders = new Orders(CustomersList, OrdersList,ProductsList);
	}


	public static void main(String[] args) {
		ECommerceSystem ES = new ECommerceSystem();
		ES.ReadData();
		int choice1;
		int choice;   
		System.out.println("-----------------------------------------------");
		System.out.println("*****************Welcome to the E-Commerce System*****************");
		do {
			System.out.println();
			System.out.println("Pick your role: ");
			System.out.println("1- Manager.");
			System.out.println("2- Customer.");
			System.out.println("3- Exit.");
			choice1= input.nextInt();
			
			switch(choice1) {
			case 1: //Manager
				System.out.println();
				System.out.println("===============================================");
				System.out.println("1- Add a Product");
				System.out.println("2- Remove product");
				System.out.println("3- Update product");
				System.out.println("4- Update order status");
				System.out.println("5- View Customer Reviews");
				System.out.println("6- Show Top 3 Products (Based on Rating)");
				System.out.println("7- Show Orders Between Two Dates");
				System.out.println("8- Show Common Products Reviewed by Two Customers(Rated above 4)");
				System.out.println("9- Display all Products");
				System.out.println("10- Display all customers");
				System.out.println("11- Display all orders");
				System.out.println("12- Display all reviews");
				System.out.println("13- Get average product rating");
				System.out.println("14- Search for a product by its name");
				System.out.println("15- track out of stock products");
				System.out.println("16- Return to main menu.");
				System.out.print("Enter your choice: ");
				choice=input.nextInt();
				System.out.println("===============================================");
				System.out.println();
				switch (choice) {
				case 1:// add product
					System.out.print("Enter Product ID: ");
					int id = input.nextInt();
					input.nextLine();//remove spaces
					System.out.print("Enter Product Name: ");
					String name = input.nextLine(); 
					System.out.print("Enter Product Price: ");
					double price = input.nextDouble();
					System.out.print("Enter Product Stock: ");
					int stock = input.nextInt();

					Product p = new Product(id, name, price, stock);
					AllProducts.addProduct(p);
					break;
				case 2:// remove product 
					System.out.println("Enter product id to remove: ");
					id = input.nextInt();
					AllProducts.removeProduct(id);
					break;
					
				case 3:// update product
					System.out.println("Enter product id you want to update: ");
					int prodId = input.nextInt();
					System.out.print("Enter new product name : ");
					input.nextLine();
					name = input.nextLine();
					input.nextLine();//remove spaces
					System.out.print("Enter new stock : ");
					stock =input.nextInt(); 
					System.out.print("Enter new Price: ");
					price = input.nextDouble();
					
					p = new Product(prodId,name , price, stock);
					AllProducts.updateProduct(prodId , p);
					break;
				case 4: { // Update order status
				    System.out.print("Enter Order ID to update its status: ");
				    id = input.nextInt();
				    input.nextLine(); 
				    Order o = AllOrders.SearchOrderByID(id);
				    if (o == null) {
				        System.out.println("No order found with this ID.");
				        break;
				    }
				    System.out.println("Current status: " + o.getStatus());
				    System.out.print("Enter new status: ");
				    String newStatus = input.nextLine().trim();

				    o.UpdateOrderStatus(newStatus);
				    System.out.println("Order status updated successfully.");
				    break;
				}

				case 5:// View Customer Reviews 
					System.out.print("Enter Customer ID to view its reviews: ");
					   int CustomerID= input.nextInt();
					    Customer c = AllCustomers.SearchCustomerById(CustomerID);
					    if (c != null) {
					        c.displayReviews();
					    } else {
					        System.out.println("Customer Not Found!");
					    }
				   
				    break;
					
				case 6:// Show Top 3 Products (Based on Rating)
					ES.displayTop3Products();
					break;
				case 7:// Show Orders Between Two Dates
				    System.out.print("Enter Start Date (yyyy-M-d): ");
				    String start = input.next();
				    System.out.print("Enter End Date (yyyy-M-d): ");
				    String end = input.next();

				    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-M-d");
				    LocalDate d1 = LocalDate.parse(start, dtf);
				    LocalDate d2 = LocalDate.parse(end, dtf);

				    ES.displayOrdersBetween2Dates(d1,d2);
				    break;

				case 8:// Show Common Products Reviewed by Two Customers(Rated above 4)
				
				    System.out.print("Enter first customer ID: ");
				    int c1 = input.nextInt();
				    System.out.print("Enter second customer ID: ");
				    int c2 = input.nextInt();

				    ES.showCommonProductsAbove4(c1, c2);
				    break;
				
					
				case 9 : //Display all Products
					AllProducts.displayProducts();
					break;
					
				case 10 : //Display all customers
					AllCustomers.displayAllCustomers();
					break;
					
				case 11 : //Display all orders
					AllOrders.displayOrders();
					break;
					
				case 12 : //Display all reviews
					AllReviews.displayReview();
					break;
					
				case 13: // get average rating
					System.out.println("Enter product id: ");
					id= input.nextInt();
					p = AllProducts.searchProductById(id);
					if(p!=null)
					System.out.println("Average rating: "+ p.getAverageRating());
					else
						System.out.println("No product with this Id found");	
					break;
				case 14://search for a product by its name 
					System.out.println("Enter The name of product you want to Search for: ");
					String proName=input.nextLine();
					Product n=AllProducts.searchProductByName(proName);
					if(n!= null)
						System.out.println(n);
					else
						System.out.println("No product with this name found");
					break;
				case 15:// show is there out of stock products
					AllProducts.outOfStockProducts();
					break;
				case 16:// exit
					System.out.println("Thank you! ");
					System.out.println("===============================================");
					break;
				}// end of manager switch
				
				
				
				break; //end of case manager switch1 
				
			case 2: //customer
				System.out.println();
				System.out.println("===============================================");
				System.out.println("1- Register");
				System.out.println("2- Place an order");
				System.out.println("3- View order history");
				System.out.println("4- Cancel order");
				System.out.println("5- Add new review or update ");
				System.out.println("6- Get average rating");
				System.out.println("7- Show Top 3 Products (Based on Rating)");
				System.out.println("8- Return to main menu");
				System.out.print("Enter your choice: ");
				choice=input.nextInt();
				System.out.println("===============================================");
				System.out.println();
				switch(choice) {
				case 1:// add customer
					System.out.print("Enter Customer ID: ");
					int id = input.nextInt();
					input.nextLine();//remove spaces
					System.out.print("Enter Customer Name: ");
					String name = input.next(); 
					System.out.print("Enter Customer Email: ");
					String email = input.next();

				    Customer C = new Customer(id, name, email);
				    AllCustomers.registerNewCustomer(C);
					break;
				case 2: // Place an order
			
				    System.out.print("Enter Order ID: ");
				    id = input.nextInt();
				    System.out.print("Enter Customer ID: ");
				    int cusID = input.nextInt();
				    input.nextLine(); 
				    // Allow multiple products separated by ';'
				    System.out.print("Enter Product IDs separated by ';' ");
				    String proID = input.nextLine();

				    // Default order status is 'pending'
				    String status = "pending";
				    // System automatically sets today's date
				    java.time.format.DateTimeFormatter fmt =java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd");
				    String dateStr = java.time.LocalDate.now().format(fmt);

				    Order O = new Order(id, cusID, proID, 0.0, dateStr, status);

				    // Add the order 
				    AllOrders.CreateOrder(O);
				    break;

				case 3: //view order history
					System.out.println("Enter customer id");
					id= input.nextInt();
					Customer cus = AllCustomers.SearchCustomerById(id);
					if(cus!=null)
					cus.viewOrdersHistory();
					else
						System.out.println("No customer found with this id");	
					break;
					
					case 4:// cancel order
						System.out.println("Enter order id to cancel");
						id= input.nextInt();
						AllOrders.CancelOrder(id);
						break;
					case 5: // Add or update a review
					    // Ask for review details
					    System.out.print("Enter review ID: ");
					    id = input.nextInt();

					    System.out.print("Enter Customer ID: ");
					    cusID = input.nextInt();

					    System.out.print("Enter Product ID: ");
					    int productID = input.nextInt();

					    // Read rating (must be between 1 and 5)
					    System.out.print("Enter rating (1..5): ");
					    int rating = input.nextInt();
					    if (rating < 1 || rating > 5) {
					        System.out.println("Invalid rating. Must be between 1 and 5.");
					        break;
					    }

					    input.nextLine();
					    System.out.print("Enter comment: ");
					    String comment = input.nextLine();

					    Review rev = new Review(id, cusID, productID, rating, comment);

					    AllReviews.addNewReview(rev);
					    break;

				case 6:// get average rating	
					System.out.println("Enter product id");
					id= input.nextInt();
					Product p = AllProducts.searchProductById(id);
					if(p!=null)
					System.out.println("Average rating: "+ p.getAverageRating());
					else
						System.out.println("product with this id not found");
					break;
					
					
				case 7:// Show Top 3 Products (Based on Rating)
					ES.displayTop3Products();
					break;
				
				case 8:// exit
					System.out.println("Thank you!");
					System.out.println("===============================================");
					break;
				}  //end of customer switch choices 


				break; //end of case customer switch1
				
			case 3: //Exit 
				System.out.println("Thank you! , Good bye");
				System.out.println("-----------------------------------------------");
				break; //end of exit switch1 
			}  //end of switch1 
			
			

		}while(choice1 !=3); //end of ' outer do' picking role 

	} // End of main
		// Method read from files


	public void ReadData() {
	AllProducts.loadProducts("C:\\Users\\lenovo\\eclipse-workspace\\CSC212Project-Phase1\\dataset\\prodcuts.csv");
	AllCustomers.loadCustomers("C:\\Users\\lenovo\\eclipse-workspace\\CSC212Project-Phase1\\dataset\\customers.csv");
	AllOrders.loadOrders("C:\\Users\\lenovo\\eclipse-workspace\\CSC212Project-Phase1\\dataset\\orders.csv");
	AllReviews.loadReviews("C:\\Users\\lenovo\\eclipse-workspace\\CSC212Project-Phase1\\dataset\\reviews.csv");
	
	}
	
	
	public void displayTop3Products() {
		if (ProductsList.empty()) {
			System.out.println("No Products in in the list.");
			return;
		}

		Product max1 = new Product(-1, "-", -1, -1);
		Product max2 = new Product(-1, "-", -1, -1);
		Product max3 = new Product(-1, "-", -1, -1);

		ProductsList.findfirst();
		while (!ProductsList.last()) {
			Product p = ProductsList.retrieve();
			if (p.getAverageRating() > max1.getAverageRating()) {
				max3 = max2;
				max2 = max1;
				max1 = p;
			} else if (p.getAverageRating() > max2.getAverageRating()) {
				max3 = max2;
				max2 = p;
			} else if (p.getAverageRating() > max3.getAverageRating()) {
				max3 = p;
			}
			ProductsList.findnext();
		}
		// for the last product
		Product p = ProductsList.retrieve();
		if (p.getAverageRating() > max1.getAverageRating()) {
			max3 = max2;
			max2 = max1;
			max1 = p;
		} else if (p.getAverageRating() > max2.getAverageRating()) {
			max3 = max2;
			max2 = p;
		} else if (p.getAverageRating() > max3.getAverageRating()) {
			max3 = p;
		}

		System.out.println("Top Products (Based on Rating)");
		if (max1 != null)
			System.out.println("Top 1: " + max1.getName() + ", ID: " + max1.getProductId() + ", Average rating: "
					+ max1.getAverageRating());
		if (max2 != null)
			System.out.println("Top 2: " + max2.getName() + ", ID: " + max2.getProductId() + ", Average rating: "
					+ max2.getAverageRating());
		if (max3 != null)
			System.out.println("Top 3: " + max3.getName() + ", ID: " + max3.getProductId() + ", Average rating: "
					+ max3.getAverageRating());

	}
	public void displayOrdersBetween2Dates(LocalDate d1 , LocalDate d2) {
		if(OrdersList.empty()) {
			System.out.println("No Orders Found");
			return;}
			OrdersList.findfirst();
			while(!OrdersList.last()) {
			Order ord=OrdersList.retrieve();
			if(ord.getOrderDate().compareTo(d1)>0 &&ord.getOrderDate().compareTo(d2)<=0) {
			System.out.println(ord.getOrderId());
			}
			OrdersList.findnext();
			}//for the last element
			Order ord=OrdersList.retrieve();
			if(ord.getOrderDate().compareTo(d1)>=0 &&ord.getOrderDate().compareTo(d2)<=0) 
				System.out.println(ord.getOrderId());

	}
	// Show common products reviewed by two customers with Avg > 4
	private static void showCommonProductsAbove4(int c1, int c2) {

	    if (AllReviews == null || AllProducts == null) {
	        System.out.println("Data not loaded!");
	        return;
	    }

	    LinkedList<Integer> customer1Products = new LinkedList<>();
	    LinkedList<Integer> customer2Products = new LinkedList<>();
	    LinkedList<Review> reviewsList = AllReviews.getReviews();

	    // product lists for both customers
	    if (!reviewsList.empty()) {
	        reviewsList.findfirst();
	        while (!reviewsList.last()) {
	            Review r = reviewsList.retrieve();
	            Product p = AllProducts.searchProductById(r.getProductID());

	            // only consider products whose average rating > 4
	            if (p != null && p.getAverageRating() > 4) {
	                if (r.getCustomerID() == c1) customer1Products.insert(r.getProductID());
	                if (r.getCustomerID() == c2) customer2Products.insert(r.getProductID());
	            }
	            reviewsList.findnext();
	        }
	        // handle the last review
	        Review r = reviewsList.retrieve();
	        Product p = AllProducts.searchProductById(r.getProductID());
	        if (p != null && p.getAverageRating() > 4) {
	            if (r.getCustomerID() == c1) customer1Products.insert(r.getProductID());
	            if (r.getCustomerID() == c2) customer2Products.insert(r.getProductID());
	        }
	    }

	    //  Compare lists and print common products 
	    boolean found = false;
	    if (!customer1Products.empty() && !customer2Products.empty()) {

	        customer1Products.findfirst();
	        while (true) {
	            int pid = customer1Products.retrieve();

	            
	            boolean exists = false; // 'exists' is used to check if the current product ID also exists in customer2Products list
	            customer2Products.findfirst();
	            while (true) {
	                if (customer2Products.retrieve() == pid) { exists = true; break; }
	                if (customer2Products.last()) break;
	                customer2Products.findnext();
	            }

	            if (exists) {
	                Product p2 = AllProducts.searchProductById(pid);
	                if (p2 != null) {
	                    System.out.println("Product ID: " + p2.getProductId()
	                                     + ", Name: " + p2.getName()
	                                     + ", Avg Rating: " + p2.getAverageRating());
	                    found = true;
	                }
	            }

	            if (customer1Products.last()) break;
	            customer1Products.findnext();
	        }
	    }

	    if (!found) {
	        System.out.println("No common products reviewed by both customers with Avg > 4.");
	    }
	}

	
	
	
	
		

}
