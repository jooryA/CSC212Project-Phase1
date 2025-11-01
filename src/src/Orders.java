package src;
// add / cancel methods missing 

public class Orders {
private  LinkedList<Order> orders;
//private Customers customers; 

//
//public Orders(LinkedList<Customer> customers ,LinkedList<Order> orders) {
	//this.orders = orders;
   //this.customers=new Customers(customers); // 
//}


public Orders() {
	//customers=new Customers(); 
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
