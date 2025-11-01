package src;

public class Products {
	
	private LinkedList<Product> products;
	
	public Products() { 
		products = new LinkedList();
	   
	}
	
	public void addProduct(Product p) {
		products.insert(p);
	}
	
	public void removeProduct() {
		products.remove();
	}
	
	public Product search(int id) {
		if(products.empty())
			return null;    //NO products in the list
		else {
			products.findfirst();
			while(!products.last()) {   //Looping from the first product till the one before the last
				if(products.retrieve().getProductId()==id)
					return products.retrieve();
			products.findnext();}
			
			if(products.retrieve().getProductId()==id)     //For the last product in the list 
			return products.retrieve();
			
			return null;  //If there's no product in the list matches the id
		}
	}
	

	public Product search(String name) {
		if(products.empty())
			return null;    //NO products in the list
		else {
			products.findfirst();
			while(!products.last()) {   //Looping from the first product till the one before the last
				if(products.retrieve().getName().equals(name))
					return products.retrieve();
			products.findnext();}
			
			if(products.retrieve().getName().equals(name))     //for the last product in the list 
				return products.retrieve();
			
			return null;   //If there's no product in the list matches the id
		}
	}

	
	
}
