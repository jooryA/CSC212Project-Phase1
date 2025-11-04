package src;

public class Products {
	
	private LinkedList<Product> products;
	
	public Products() { 
		products = new LinkedList();
	   
	}
	
	public void addProduct(Product p) {
		if(searchProductById(p.getProductId())==null) {
			products.insert(p);
			System.out.println(p.getName()+" is added successfully.");}
		else 
			System.out.println(p.getName()+" is already added.");
	}
	
	public void removeProduct(int id) {
		if(searchProductById(id)!=null) {
			String name =products.retrieve().getName();
			products.remove();       //the search method would move the current to the intended product so it'll get removed
			System.out.println((name+" is removed successfully."));}
		else
			System.out.println("Product with this Id does not exist.");
	}
	
	public void updateProduct(int id , Product p) {
		Product prod = searchProductById(id);
		if(prod!=null) {
			prod.updateProduct(p);
			System.out.println("Product is updated successfully into "+p.getName());}
		else 
			System.out.println("Product with this Id does not exist.");
	}
	
	public Product searchProductById(int id) {
		if(products.empty())
			return null;    //No products in the list
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
	
	public Product searchProductByName(String name) {
		if(products.empty())
			return null;    //No products in the list
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

	public void displayOutOfStock() {
		if(products.empty()) {
			System.out.println("No products exist");
			return;
		}
		System.out.println("Out of stock products:");
		boolean inStock = true;
		products.findfirst();
		
		while(!products.last()){
			if(products.retrieve().getStock()==0) {
				System.out.println(products.retrieve().toString()); 
				inStock = false;}
			products.findnext();
		}
		if(products.retrieve().getStock()==0) {
			System.out.println(products.retrieve().toString()); 
			inStock = false;}
		
		if (inStock)
			System.out.println("All products are in Stock");
	}
	
}
