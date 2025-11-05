package src;

import java.util.Scanner;
public class ECommerceSystem {
  static Scanner input=new Scanner(System.in) ;
  
	static LinkedList<Review> ReviewsList;
	static LinkedList<Product> ProductsList;
	static LinkedList<Customer> CustomersList;
	static LinkedList<Order> OrdersList;
	
	static Reviews AllReviews;
	static Products AllProducts;
	static Customers AllCustomers;
	static Orders AllOrders;
	
	public ECommerceSystem() {
	ReviewsList=new LinkedList<Review>();
	ProductsList=new LinkedList<Product>();
	CustomersList=new LinkedList<Customer>();
	OrdersList=new LinkedList<Order>();
	
	//creates an objects and initializes its LinkedList
	
	//AllReviews=new Reviews(ReviewsList , ProductsList , CustomersList);
	//AllProducts=new Products(ProductsList);
	AllCustomers=new Customers(CustomersList);
	AllOrders=new Orders(CustomersList, OrdersList);
	}
// we can add more options
	public static void main(String[] args) {
	ECommerceSystem ES=new  ECommerceSystem();	
	int choice;
	
	do {
		System.out.println("Welcome to the E-Commerce System ");
		System.out.println("-----------------------------------");
		System.out.println("1- Read From Files");
		System.out.println("2- Add a Product");
		System.out.println("3- Add a Customer");
		System.out.println("4- Place an Order");
		System.out.println("5- View Customer Reviews");
		System.out.println("6- Show Top 3 Products (Based on Rating)");
		System.out.println("7- Show Orders Between Two Dates");
		System.out.println("8- Show Common Products Reviewed by Two Customers(Rated above 4)");
		System.out.println("9- Exit");
		
		System.out.print("Enter your choice: ");
		choice=input.nextInt();
		
		switch(choice) {
		case 1://Read from file
			break;
		case 2:// add product
			break;
		case 3://add customer
			break;
		case 4://place an order
			break;
		case 5://View Customer Reviews
			break;
		case 6://Show Top 3 Products (Based on Rating)
			break;
		case 7://Show Orders Between Two Dates
			break;
		case 8://Show Common Products Reviewed by Two Customers(Rated above 4)
			break;
		case 9://exit
			System.out.println("Thank you! , Good bye");
			break;
		
		
		
		}//end switch
		
		
	}while(choice!=9);
	// end do-while
	
	}
	// Method read from files
	
	

}
