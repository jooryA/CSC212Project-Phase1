package src;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class FileManager {
	
    private static final String PRODUCTS_FILE = "dataset/prodcuts.csv";
    private static final String CUSTOMERS_FILE = "dataset/customers.csv";
    private static final String ORDERS_FILE = "dataset/orders.csv";
    private static final String REVIEWS_FILE = "dataset/reviews.csv";

    public void saveAllData(LinkedList<Product> products, 
                            LinkedList<Customer> customers,
                            LinkedList<Order> orders, 
                            LinkedList<Review> reviews) {
        
        saveFile(PRODUCTS_FILE, "productId,name,price,stock", products);
        saveFile(CUSTOMERS_FILE, "customerId,name,email", customers);
        saveFile(ORDERS_FILE, "orderId,customerId,productIds,totalPrice,orderDate,status", orders);
        saveFile(REVIEWS_FILE, "reviewID,productID,customerID,rating,comment", reviews);
    }
        
    private void saveProducts(LinkedList<Product> products) {
        saveFile(PRODUCTS_FILE, "productId,name,price,stock", products);
    }

    private void saveCustomers(LinkedList<Customer> customers) {
        saveFile(CUSTOMERS_FILE, "customerId,name,email", customers);
    }
    
    private void saveOrders(LinkedList<Order> orders) {
        saveFile(ORDERS_FILE, "orderId,customerId,productIds,totalPrice,orderDate,status", orders);
    }
    
    private void saveReviews(LinkedList<Review> reviews) {
        saveFile(REVIEWS_FILE, "reviewID,productID,customerID,rating,comment", reviews);
    }

    private <T> void saveFile(String fileName, String header, LinkedList<T> list) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName, false))) {
            
            pw.println(header); 
            
            if (list.empty()) return; 
            
            list.findfirst();
            while (true) {
                Object item = list.retrieve();
                
                if (item instanceof Customer) {
                    pw.println(((Customer) item).toCSV());
                } else if (item instanceof Product) {
                    pw.println(((Product) item).toCSV());
                } else if (item instanceof Order) {
                    pw.println(((Order) item).toCSV());
                } else if (item instanceof Review) {
                    pw.println(((Review) item).toCSV());
                }
                
                if (list.last()) break;
                list.findnext();
            }
        } catch (IOException e) {
            System.err.println("Error writing data to file " + fileName + ": " + e.getMessage());
        } catch (Exception e) {
             System.err.println("Error processing data in FileManager for " + fileName + ": " + e.getMessage());
        }
    }
}
