/* 
Asymptotic Notation
Big O Notation :-
---------------

Big O notation is a mathematical representation used to describe the time complexity of an algorithm in terms of input size (n).
It helps analyze the efficiency of an algorithm by providing a high-level understanding of its performance.
Best, Average, and Worst-Case Scenarios:

Best Case :- The scenario where the algorithm performs the minimum number of operations.
Average Case :- The scenario that represents the expected number of operations for typical input.
Worst Case :- The scenario where the algorithm performs the maximum number of operations.

*/


import java.util.Arrays;
import java.util.Comparator;

public class exercise2 {
    
    public static class Product {
        private String productId;
        private String productName;
        private String category;

        public Product(String productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        // Getters
        public String getProductId() { return productId; }
        public String getProductName() { return productName; }
        public String getCategory() { return category; }
    }

    public static class LinearSearch {
        public static Product linearSearch(Product[] products, String productId) {
            for (Product product : products) {
                if (product.getProductId().equals(productId)) {
                    return product;
                }
            }
            return null;
        }
    }

    public static class BinarySearch {
        public static Product binarySearch(Product[] products, String productId) {
            int left = 0;
            int right = products.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int comparison = products[mid].getProductId().compareTo(productId);

                if (comparison == 0) {
                    return products[mid];
                } else if (comparison < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        
        Product[] products = {
            new Product("1", "Laptop", "Electronics"),
            new Product("2", "Smartphone", "Electronics"),
            new Product("3", "Tablet", "Electronics"),
            new Product("4", "Headphones", "Accessories"),
            new Product("5", "Smartwatch", "Accessories")
        };

        // Sorting products by productId for binary search
        Arrays.sort(products, Comparator.comparing(Product::getProductId));

        // Linear Search 
        Product foundProductLinear = LinearSearch.linearSearch(products, "3");
        if (foundProductLinear != null) {
            System.out.println("Linear Search: Found " + foundProductLinear.getProductName());
        } else {
            System.out.println("Linear Search: Product not found");
        }

        // Binary Search 
        Product foundProductBinary = BinarySearch.binarySearch(products, "3");
        if (foundProductBinary != null) {
            System.out.println("Binary Search: Found " + foundProductBinary.getProductName());
        } else {
            System.out.println("Binary Search: Product not found");
        }
    }
}

/*
output :-
-------
Linear Search: Found Tablet
Binary Search: Found Tablet
*/

/* 

Analysis :-
--------
Time Complexity:

Linear Search: O(n)
Best Case: O(1) (product is the first element)
Average Case: O(n/2)
Worst Case: O(n) (product is the last element or not found)

Binary Search: O(log n)
Best Case: O(1) (product is the middle element)
Average Case: O(log n)
Worst Case: O(log n) (product is not found)

Suitability :-
-----------
Linear Search: Suitable for small datasets or unsorted data.
Binary Search: More suitable for large, sorted datasets due to its logarithmic time complexity, making it faster for larger datasets.
For an e-commerce platform with potentially large datasets, binary search is more suitable if the product list is sorted by product ID.

*/