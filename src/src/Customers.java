package src;

import java.io.File;
import java.util.Scanner;

public class Customers {

	private  LinkedList<Customer> Customers;

	public Customers() {
	
		Customers = new LinkedList<>();
	}
	public Customers(LinkedList<Customer> customers) {
	Customers=customers;	
	}
	public Customer SearchCustomerById(int id) {
		if(!Customers.empty()) { // if it is not empty check customers
			Customers.findfirst();
			while(!Customers.last()) {//loop not including last element
				if(Customers.retrieve().getCustomerId()==id) 
					return Customers.retrieve(); // if same customer ID found return it 
				else
					Customers.findnext();
			}
			if(Customers.retrieve().getCustomerId()==id) // check customer ID for the last element
				return Customers.retrieve();
		}
		return null; //no customers found with same ID	
	}
	
	
	public void registerNewCustomer(Customer c) {
		if(SearchCustomerById(c.getCustomerId())==null) {
			Customers.insert(c);
			
		System.out.println("Added Successfully, Customer ID: "+ c.getCustomerId());}
		else
			System.out.println("Customer ID: "+c.getCustomerId()+" Already exists");	
		
	}
		
	
	
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
	
	
	public void loadCustomers(String fileName) {
		try {
			File file = new File(fileName);
			Scanner read = new Scanner(file);
			System.out.println("File: "+fileName);
			
			if (read.hasNextLine()) {   //for the header if there's one 
	            read.nextLine(); 
	        }
			while(read.hasNextLine()) {
				String line = read.nextLine().trim();
				
				if(!line.isEmpty()) {
					String a[]=line.split(",");
					int id = Integer.parseInt(a[0].trim());
					String name = a[1].trim();
					String email = a[2].trim();
					
					Customer c = new Customer( id , name, email);
					Customers.insert(c);
				}
			}
			read.close();
	        System.out.println("Customers File loaded successfully.");
		}catch (Exception e) {
			System.out.println("Error in reading file: "+e.getMessage());
		}
	}
}

