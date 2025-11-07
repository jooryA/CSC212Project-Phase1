package src;
import java.time.LocalDate;
import java.util.Scanner;
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
		AllOrders = new Orders(CustomersList, OrdersList);
	}

// we can add more options
	public static void main(String[] args) {
		ECommerceSystem ES = new ECommerceSystem();
		int choice;

		do {
			System.out.println("Welcome to the E-Commerce System ");
			System.out.println("-----------------------------------");
			System.out.println("1- Read From Files");
			System.out.println("2- Add a Product");
			System.out.println("3- Add a Customer");
			System.out.println("4- Place an Order");
			System.out.println("5- Add Reviews to product");
			System.out.println("6- View Customer Reviews");
			System.out.println("7- Show Top 3 Products (Based on Rating)");
			System.out.println("8- Show Orders Between Two Dates");
			System.out.println("9- Show Common Products Reviewed by Two Customers(Rated above 4)");
			System.out.println("10- Exit");

			System.out.print("Enter your choice: ");
			choice = input.nextInt();

			switch (choice) {
			case 1:// Read from files

				break;
			case 2:// add product
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

				if (AllProducts != null) {
					AllProducts.addProduct(p);
				} 
				break;
			case 3:// add customer
				System.out.print("Enter Customer ID: ");
				id = input.nextInt();
				input.nextLine();//remove spaces
				System.out.print("Enter Customer Name: ");
				name = input.next(); 
				System.out.print("Enter Customer Email: ");
				String email = input.next();

			    Customer C = new Customer(id, name, email);

				if (AllCustomers != null) {
					AllCustomers.registerNewCustomer(C);
				} 
				break;
			case 4:// place an order
				System.out.print("Enter Order ID: ");
				id = input.nextInt();
				input.nextLine();//remove spaces
				System.out.print("Enter Customer ID : ");
				int cusID=input.nextInt(); 
				System.out.print("Enter Product ID : ");
				String proID=input.next(); 
				System.out.print("Enter Total Price: ");
				price = input.nextDouble();
				System.out.print("Enter Order Date in dd/MM/yyyy Format: ");
				String Date = input.next();
				System.out.print("Enter Order Status ( pending , shipped , delivered or canceled )");
				String status = input.next();

				DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/M/yyyy");
			    Order O = new Order(id, cusID , proID,price,LocalDate.parse(Date,df) , status);

				if (AllOrders != null) {
					AllOrders.CreateOrder(O);
				} 
				
				break;
				case 5:// add review
					System.out.print("Enter Review ID: ");
					id = input.nextInt();
					input.nextLine();//remove spaces
					System.out.print("Enter Customer ID : ");
					cusID=input.nextInt(); 
					System.out.print("Enter Product ID : ");
					int productID=input.nextInt(); 
					System.out.print("Enter your Rating: ");
					int rating= input.nextInt();
					System.out.print("Enter Your Comment: ");
					String comment = input.nextLine();
					
				    Review R = new Review(id,cusID,productID,rating,comment);
					AllReviews.addNewReview(R);
					
					break;
			case 6:// View Customer Reviews
				
				break;
			case 7:// Show Top 3 Products (Based on Rating)
				ES.displayTop3Products();
				break;
			case 8:// Show Orders Between Two Dates
			    System.out.print("Enter Start Date (d/M/yyyy): ");
			    String start = input.next();
			    System.out.print("Enter End Date (d/M/yyyy): ");
			    String end = input.next();

			    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
			    LocalDate d1 = LocalDate.parse(start, dtf);
			    LocalDate d2 = LocalDate.parse(end, dtf);

			    ES.displayOrdersBetween2Dates(d1,d2);
			    break;

			case 9:// Show Common Products Reviewed by Two Customers(Rated above 4)
				break;
			case 10:// exit
				System.out.println("Thank you! , Good bye");
				break;

			}// end switch

		} while (choice != 9);
		// end do-while

	} // End of main
		// Method read from files

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
	
	
	
	
	
		

}
