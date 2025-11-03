package src;
// Create method not complete / cancel

public class Orders {
private  LinkedList<Order> orders;
private Customers customers; 


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

public void AttachOrderToCustomer(Order newOrd) {// Every order must be linked to the customer who made it
	Customer c=customers.SearchCustomerById(newOrd.getCustomerId());
	if(c==null)
		System.out.println("No Customers Found");
	else
		c.PlaceOrder(newOrd);	
}
public void CreateOrder(Order ord) { 
	if(SearchOrderByID(ord.getOrderId())==null) {
		orders.insert(ord);// should i add it to the end of the list?
		AttachOrderToCustomer(ord);
	System.out.println("Added Successfully, Order ID: "+ord.getOrderId());}
	else
		System.out.println("Order ID: "+ord.getOrderId()+" Already exists");	
	
}
public void RemoveOrder(int id) {
	if(!orders.empty()) {
		orders.findfirst();
		while(!orders.last()) { // loop from the first order till the order before last
		if(orders.retrieve().getOrderId()==id){// check if matching ID is found ,then remove it
			orders.remove();// remove order that has the same order id
		return;
		}else
			orders.findnext();//if no matching id is found , continue the loop
	}
		if(orders.retrieve().getOrderId()==id){// checking the last element
			orders.remove();
		return;
		}
	System.out.println("No order found with this ID to delete");
}else
	System.out.println("No order found with this ID to delete");
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
		ord.toString();
	}
	Order ord =orders.retrieve();// displays the last order
	ord.toString();	
}
public LinkedList<Order> getOrders() {
	return orders;
}




}
