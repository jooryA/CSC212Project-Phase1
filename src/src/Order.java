package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Order {
	private int OrderId;
	private int customerId;
	private String ProductId;
	private double totalPrice;
	private LocalDate OrderDate;
	private String Status;
	//private LinkedList<Products> product;
	
	public Order(int orderId, int customerId, String productId, double totalPrice, LocalDate orderDate, String status) {
		this.OrderId = orderId;
		this.customerId = customerId;
		this.ProductId = productId;
		this.totalPrice = totalPrice;
        this.OrderDate = orderDate;
		this.Status = status;
	}
	
	
	public void UpdateOrder(Order ord) {
		this.OrderId =ord.OrderId;
		this.customerId	=ord.customerId;
		this.ProductId=ord.ProductId;
		this.totalPrice =ord.totalPrice;
		this.OrderDate =ord.OrderDate;
		this.Status =ord.Status;
	}
	public void UpdateOrderStatus(String S) {
		this.Status =S;
	}
	
	public String toString() {
		return "OrderId=" + OrderId + "\n, CustomerId=" + customerId + "\n, ProductId=" + ProductId + "\n, totalPrice="
				+ totalPrice + "\n, OrderDate=" + OrderDate + "\n, Status=" + Status ;
	}
	
	
	public int getOrderId() {return OrderId;}
	
	public int getCustomerId() {return customerId;}
	
	public String getProductId() {return ProductId;}
	
	public double getTotalPrice() {return totalPrice;}
	
	public LocalDate getOrderDate() {return OrderDate;}
	
	public String getStatus() {return Status;}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}