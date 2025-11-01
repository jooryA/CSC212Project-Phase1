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
