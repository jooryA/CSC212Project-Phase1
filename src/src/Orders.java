package src;

import java.io.File;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Orders {
	private  LinkedList<Order> orders;
	private Customers customers; 
	private Products productList;
	
	
	public Orders(LinkedList<Customer> customers ,LinkedList<Order> orders) {
		this.orders = orders;
	   this.customers=new Customers(customers); 
	}
	
	
	public Orders() {
		customers=new Customers(); 
		orders=new LinkedList<>();
	
	}
	public Order SearchOrderByID(int id) {
		if(!orders.empty()) { // if it is not empty check orders
			orders.findfirst();
			while(!orders.last()) {//loop not including last element
				if(orders.retrieve().getOrderId()==id) 
					return orders.retrieve(); // if same order ID found return it 
				else
					orders.findnext();
			}
			if(orders.retrieve().getOrderId()==id) // check order ID for the last element
				return orders.retrieve();
		}
		return null; //no order found with same ID	
	}
	
	public void CreateOrder(Order ord) {
	    if (SearchOrderByID(ord.getOrderId()) == null) {
	        orders.insert(ord);
	        AttachOrderToCustomer(ord);
	        System.out.println("Added Successfully, Order ID: " + ord.getOrderId());

	        // decrement the stock for each product
	        LinkedList<Integer> ids = ord.getProductIds();
	        if (!ids.empty()) {
	            ids.findfirst();
	            while (true) {
	                int pid = ids.retrieve();

	                Product p = productList.searchProductById(pid); //search for the product from the list
	                if (p != null) {
	             
	                    if (p.getStock() > 0) {
	                        p.setStock(p.getStock() - 1);
	                    } else {
	                        System.out.println("Product " + pid + " is out of stock.");
	                    }
	                } else {
	                    System.out.println("Product " + pid + " not found.");
	                }

	                if (ids.last()) break;   
	                ids.findnext();
	            }
	        }
	    } else {
	        System.out.println("Order already exists!");
	    }
	}

	public void AttachOrderToCustomer(Order newOrd) {// Every order must be linked to the customer who made it
		Customer c=customers.SearchCustomerById(newOrd.getCustomerId());
		if(c==null)
			System.out.println("No Customers Found");
		else
			c.PlaceOrder(newOrd);	//// Place a new order for this specific customer
	}

	public void CancelOrder(int id) {
	    Order o = SearchOrderByID(id);

	    if (o == null) {
	        System.out.println("No order found with this ID to Cancel");
	        return;
	    }

	    // 
	    String st = o.getStatus();
	    if ("Delivered".equalsIgnoreCase(st)) {
	        System.out.println("Order " + id + " cannot be cancelled (already delivered).");
	        return;
	    }

	    o.UpdateOrderStatus("Cancelled");
	    System.out.println("Order " + id + " has been cancelled successfully.");

	    LinkedList<Integer> prodIDs = o.getProductIds();
	    if (!prodIDs.empty()) {
	        prodIDs.findfirst();
	        while (true) {
	            int pid = prodIDs.retrieve();
	            Product p = productList.searchProductById(pid);
	            if (p != null) {
	                p.setStock(p.getStock() + 1);   
	            } else {
	                System.out.println("Warning: Product " + pid + " not found in product list.");
	            }
	            if (prodIDs.last()) break;
	            prodIDs.findnext();
	        }
	    }
	}


	
	public void displayOrders() {
		if(orders.empty()) {
			System.out.println("No orders found ");
			return;
		}
		System.out.println("OrderId: \n, CustomerId: \n, ProductId: \n, totalPrice: \n, OrderDate: \n, Status: ");
		
		orders.findfirst();
		while(!orders.last()) { // display all orders until the last order ( last one not included)
			Order ord =orders.retrieve();
			System.out.println(ord.toString());
		}
		Order ord =orders.retrieve();// displays the last order
		System.out.println(ord.toString());	
	}
	public LinkedList<Order> getOrders() {
		return orders;
	}
	public void loadOrders(String fileName) {
	    try {
	        File file = new File(fileName);
	        Scanner read = new Scanner(file);
	        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        System.out.println("Loading orders from: " + fileName);
	        
	        if (read.hasNextLine()) {
	            read.nextLine(); // Skip the header line
	        }

	        while (read.hasNextLine()) {
	            String line = read.nextLine().trim();
	            if (!line.isEmpty()) {//read the data 

	            String[] data = line.split(",");

	            int orderId = Integer.parseInt(data[0].trim().replace("\"", ""));
	            int customerId = Integer.parseInt(data[1].trim().replace("\"", ""));
	            String productId = data[2].trim().replace("\"", "");
	            double totalPrice = Double.parseDouble(data[3]);
	            LocalDate orderDate = LocalDate.parse(data[4],df);
	            String status = data[5].trim();

	            Order o = new Order(orderId, customerId, productId, totalPrice, orderDate, status);
	            orders.insert(o); // Add order to LinkedList
	        }}

	        read.close();
	        System.out.println("Orders loaded successfully from file: " + fileName);

	    } catch (Exception e) {
	        System.out.println("Error reading orders file: " + e.getMessage());
	    }
	}
	
	
	
	}
