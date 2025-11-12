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
	private LinkedList<Integer> productIds;
	
	public Order(int orderId, int customerId, String productId, double totalPrice, String orderDate, String status) {
		this.OrderId = orderId;
		this.customerId = customerId;
		this.ProductId = productId;
		this.totalPrice = totalPrice;
		
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        OrderDate=LocalDate.parse(orderDate.replace("\"","").trim(),formatter);
		this.Status = status;
		this.productIds=new LinkedList<>();
		addId(productId);
		
	}
	public void addId(String id) {
		String IDs[]=id.split(";");
		for(int i=0 ; i<IDs.length ;i++) {
			productIds.insert(Integer.parseInt(IDs[i].trim()));
		}
	}
	
	public void UpdateOrderStatus(String S) {
		this.Status =S;
	}
	
	public String toString() {
		return "OrderId=" + OrderId + "\nCustomerId=" + customerId + "\nProductId=" + ProductId + "\ntotalPrice="
				+ totalPrice + "\nOrderDate=" + OrderDate + "\nStatus=" + Status ;
	}
	
	
	public int getOrderId() {return OrderId;}
	
	public int getCustomerId() {return customerId;}
	
	public String getProductId() {return ProductId;}
	
	public double getTotalPrice() {return totalPrice;}
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public LocalDate getOrderDate() {return OrderDate;}
	
	public String getStatus() {return Status;}
	
	public LinkedList<Integer> getProductIds() {
		return productIds;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}