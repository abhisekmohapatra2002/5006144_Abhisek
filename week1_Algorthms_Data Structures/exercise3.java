/*
Bubble Sort :-
-----------
A simple comparison-based sorting algorithm. It repeatedly steps through the list, compares adjacent elements, 
and swaps them if they are in the wrong order.

Time Complexity :-
Best Case: O(n)
Average Case: O(n^2)
Worst Case: O(n^2)

Insertion Sort :-
-----------
Builds the sorted array one item at a time, picking the next item and placing it in its correct position.

Time Complexity :-
Best Case: O(n)
Average Case: O(n^2)
Worst Case: O(n^2)

Quick Sort:
-----------
A divide-and-conquer algorithm that picks a pivot element and partitions the array around the pivot, sorting the partitions recursively.

Time Complexity :-
Best Case: O(n log n)
Average Case: O(n log n)
Worst Case: O(n^2) 

Merge Sort:
-----------
A divide-and-conquer algorithm that divides the array into halves, recursively sorts them, and then merges the sorted halves.

Time Complexity :-
Best Case: O(n log n)
Average Case: O(n log n)
Worst Case: O(n log n)

*/


public class exercise3 {

    public static class Order {
        private String orderId;
        private String customerName;
        private double totalPrice;

        public Order(String orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        
        public String getOrderId() { 
            return orderId; 
        }
        public void setOrderId(String orderId) { 
            this.orderId = orderId; 
        }
        public String getCustomerName() { 
            return customerName; 
        }
        public void setCustomerName(String customerName) { 
            this.customerName = customerName; 
        }
        public double getTotalPrice() { 
            return totalPrice; 
        }
        public void setTotalPrice(double totalPrice) { 
            this.totalPrice = totalPrice; 
        }
    }

    
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order("1", "Abhi", 250.50),
            new Order("2", "Zahid", 100.75),
            new Order("3", "Asif", 300.40),
            new Order("4", "Yash", 150.20),
            new Order("5", "Manisha", 200.90)
        };

        
        System.out.println("Bubble Sort:");
        bubbleSort(orders);
        for (Order order : orders) {
            System.out.println(order.getOrderId() + " " + order.getCustomerName() + " " + order.getTotalPrice());
        }

        
        orders = new Order[]{
            new Order("1", "Abhi", 250.50),
            new Order("2", "Zahid", 100.75),
            new Order("3", "Asif", 300.40),
            new Order("4", "Yash", 150.20),
            new Order("5", "Manisha", 200.90)
        };

        
        System.out.println("\nQuick Sort:");
        quickSort(orders, 0, orders.length - 1);
        for (Order order : orders) {
            System.out.println(order.getOrderId() + " " + order.getCustomerName() + " " + order.getTotalPrice());
        }
    }
}

/*
output :
----------
Bubble Sort:
2 Zahid 100.75
4 Yash 150.2
5 Manisha 200.9
1 Abhi 250.5
3 Asif 300.4

Quick Sort:
2 Zahid 100.75
4 Yash 150.2
5 Manisha 200.9
1 Abhi 250.5
3 Asif 300.4

*/


/*

Bubble Sort :-
-----------
Time Complexity :
Best Case: O(n)
Average Case: O(n^2)
Worst Case: O(n^2)
Suitable for small datasets or when simplicity is more important than performance.

Quick Sort :-
-----------
Time Complexity :
Best Case: O(n log n)
Average Case: O(n log n)
Worst Case: O(n^2) 
Generally preferred due to its superior average-case performance and efficiency with large datasets.

Why Quick Sort is Preferred Over Bubble Sort :-
--------------------------------------------
Quick Sort's average time complexity of O(n log n) makes it much faster for large datasets compared to Bubble Sort's O(n^2).
Quick Sort is more efficient and scalable, making it suitable for high-performance applications like sorting customer 
orders on an e-commerce platform.

*/