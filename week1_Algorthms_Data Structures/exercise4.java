/*
Array Representation in Memory :-
--------------------------------

Arrays are a collection of elements stored in contiguous memory locations.
Each element can be accessed directly using its index, providing constant-time access (O(1)).
Advantages include fast access to elements and efficient memory utilization for fixed-size collections.

*/


public class exercise4 {

    // Employee class definition
    public static class Employee {
        private String employeeId;
        private String name;
        private String position;
        private double salary;

        public Employee(String employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        // Getters and Setters
        public String getEmployeeId() { 
            return employeeId; 
        }
        public void setEmployeeId(String employeeId) { 
            this.employeeId = employeeId; 
        }
        public String getName() { 
            return name; 
        }
        public void setName(String name) { 
            this.name = name; 
        }
        public String getPosition() { 
            return position; 
        }
        public void setPosition(String position) { 
            this.position = position; 
        }
        public double getSalary() { 
            return salary; 
        }
        public void setSalary(double salary) { 
            this.salary = salary; 
        }

        @Override
        public String toString() {
            return "Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
        }
    }

    private Employee[] employees;
    private int size;
    private int capacity;

    public exercise4(int capacity) {
        this.capacity = capacity;
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    
    public boolean addEmployee(Employee employee) {
        if (size < capacity) {
            employees[size++] = employee;
            return true;
        } else {
            System.out.println("Array is full. Cannot add more employees.");
            return false;
        }
    }

    
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    
    public boolean deleteEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        exercise4 employeeManagementSystem = new exercise4(10);

        
        Employee emp1 = new Employee("1", "Abhi", "Manager", 75000);
        Employee emp2 = new Employee("2", "Manisha", "Developer", 65000);
        Employee emp3 = new Employee("3", "Asif", "Designer", 60000);

        employeeManagementSystem.addEmployee(emp1);
        employeeManagementSystem.addEmployee(emp2);
        employeeManagementSystem.addEmployee(emp3);

        System.out.println("All Employees:");
        employeeManagementSystem.traverseEmployees();

        System.out.println("\nSearching for Employee with ID 2:");
        Employee foundEmployee = employeeManagementSystem.searchEmployee("2");
        if (foundEmployee != null) {
            System.out.println(foundEmployee);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDeleting Employee with ID 002:");
        boolean isDeleted = employeeManagementSystem.deleteEmployee("2");
        if (isDeleted) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nAll Employees after deletion:");
        employeeManagementSystem.traverseEmployees();
    }
}


/*
output :-
-------
All Employees:
Employee ID: 1, Name: Abhi, Position: Manager, Salary: 75000.0
Employee ID: 2, Name: Manisha, Position: Developer, Salary: 65000.0
Employee ID: 3, Name: Asif, Position: Designer, Salary: 60000.0

Searching for Employee with ID 2:
Employee ID: 2, Name: Manisha, Position: Developer, Salary: 65000.0

Deleting Employee with ID 002:
Employee deleted successfully.

All Employees after deletion:
Employee ID: 1, Name: Abhi, Position: Manager, Salary: 75000.0
Employee ID: 3, Name: Asif, Position: Designer, Salary: 60000.0

*/



/*

Time Complexity:
----------------
Add: O(1) (if the array is not full)
Search: O(n)
Traverse: O(n)
Delete: O(n)

Limitations of Arrays:
----------------------
Fixed Size: Arrays have a fixed size, which can lead to wasted space if the array is not fully utilized 
or insufficient space if the array is full. Insertion and Deletion: Inserting or deleting elements 
requires shifting elements, leading to O(n) time complexity for these operations. 

When to Use Arrays:
-------------------
Arrays are suitable when you need fast access to elements using indices and the size of the collection 
is known and fixed. They are not ideal for dynamic data structures where frequent insertions and deletions are required.

*/

