package src;

public class Customer {

	private int CustomerId;
	private String name;
	private String email;
	private LinkedList<Order> orders;
	
	public Customer(int customerId, String name, String email) {
		
		CustomerId = customerId;
		this.name = name;
		this.email = email;
		orders = new LinkedList<>();
	}
	public void PlaceOrder(Order order) {// Place a new order for this specific customer
		orders.insert(order);
	}
	public void displayOrders() {
		if(!orders.empty()) {
			System.out.println("Orders for Customer : "+name );
			orders.findfirst();
			while(!orders.last()) {// display all orders until the last order ( last one not included)
				System.out.println(orders.retrieve().toString());
				orders.findnext();
			}
			System.out.println(orders.retrieve().toString());// displays the last order
		}else
		System.out.println("No Orders Found for Customer : "+name);
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
public void display() {
		System.out.println("Customer ID :" + CustomerId);
		System.out.println("name  :" + name);
		System.out.println("email :" + email);
	
	}
	

	
	
}
