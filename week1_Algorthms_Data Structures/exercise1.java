import java.util.HashMap;

public class exercise1 {
    
    public static class Product {
        private String productId;
        private String productName;
        private int quantity;
        private double price;

        public Product(String productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        // Getters and Setters
        public String getProductId() {
            return productId; 
        }
        public void setProductId(String productId) { 
            this.productId = productId;
        }
        public String getProductName() { 
            return productName; 
        }
        public void setProductName(String productName) { 
            this.productName = productName; 
        }
        public int getQuantity() { 
            return quantity; 
        }
        public void setQuantity(int quantity) { 
            this.quantity = quantity; 
        }
        public double getPrice() { 
            return price; 
        }
        public void setPrice(double price) { 
            this.price = price; 
        }
    }

    private HashMap<String, Product> inventory;

    public exercise1() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(String productId, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(quantity);
            product.setPrice(price);
        }
    }

    public void deleteProduct(String productId) {
        inventory.remove(productId);
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public static void main(String[] args) {
        exercise1 ims = new exercise1();

        // Adding products
        Product product1 = new Product("1", "Laptop", 10, 1500.00);
        Product product2 = new Product("2", "Smartphone", 20, 800.00);
        ims.addProduct(product1);
        ims.addProduct(product2);

        // Updating product
        ims.updateProduct("1", 15, 1400.00);

        // Deleting product
        ims.deleteProduct("2");

        // Retrieving product
        Product retrievedProduct = ims.getProduct("1");
        System.out.println("Product ID : " + retrievedProduct.getProductId());
        System.out.println("Product Name : " + retrievedProduct.getProductName());
        System.out.println("Quantity : " + retrievedProduct.getQuantity());
        System.out.println("Price : " + retrievedProduct.getPrice());
    }
}



/*
output :- 
------
Product ID: 1
Product Name: Laptop
Quantity: 15
Price: 1400.0
Found Product ID: 1
Found Product Name: Laptop
Found Quantity: 15
Found Price: 1400.0


 */

/* 

Analysis :-
--------
Time Complexity:

Add Product: O(1) on average, as HashMap provides constant-time insertion.
Update Product: O(1) on average, as HashMap allows constant-time retrieval and update.
Delete Product: O(1) on average, as HashMap provides constant-time deletion.

Optimization :-
------------
Load Factor and Resizing: Ensure the HashMap is properly sized to minimize the need for resizing, which can be costly.
Hash Function: Use a good hash function to minimize collisions and maintain constant-time complexity.

*/