package src;

public class Customers {

	private  LinkedList<Customer> Customers;

	public Customers() {
	
		Customers = new LinkedList<>();
	}
	
	public void registerNewCustomer(int id , String name ,String email) {
		Customers.insert(new Customer(id , name , email));}
	
	// Place a new order for a specific customer جوري
	 // View order history  جوري
	
	public void displayAllCustomers() {
        if (Customers.empty()) {
            System.out.println("No customers found");
            return;
        }
        Customers.findfirst();
        while (!Customers.last()) {
            Customers.retrieve().display();
            Customers.findnext();
        }
       Customers.retrieve().display();
    }
	
}

