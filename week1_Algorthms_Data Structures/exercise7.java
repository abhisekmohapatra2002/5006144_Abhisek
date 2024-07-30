/*
Concept of Recursion :-
--------------------
Recursion is a programming technique where a method calls itself to solve smaller instances of the same problem.
It simplifies problems that can be broken down into similar sub-problems.
Base Case: The condition under which the recursion stops.
Recursive Case: The part of the algorithm where the method calls itself.

*/

public class exercise7 {

    public static double calculateFutureValue(double principal, double growthRate, int years) {
        if (years == 0) {
            return principal;
        }
        return calculateFutureValue(principal * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double principal = 1000.0; 
        double growthRate = 0.05; 
        int years = 10;          

        double futureValue = calculateFutureValue(principal, growthRate, years);

        System.out.printf("Future value of the investment after %d years is: %.2f%n", years, futureValue);
    }
}

/*
output :-
Future value of the investment after 10 years is: 1628.89

*/


/*
Time Complexity :-
---------------
The time complexity of the recursive calculateFutureValue method is O(n), where n is the number of years. 
This is because each recursive call processes a single year, leading to a linear number of calls.

Optimization :-
------------
Memoization: To avoid redundant calculations, store results of previously computed values. 
For this problem, memoization is not required because each recursive call computes a unique value directly.

Recursive vs. Iterative Solution :-
--------------------------------
While recursion provides a clean and intuitive solution, iterative approaches can be more efficient for 
large inputs due to reduced overhead from function calls. For this problem, an iterative solution would 
involve a simple loop to compute the future value, which would be more efficient in terms of both time and space complexity.

*/

