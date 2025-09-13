// User function Template for Java
import java.util.*;

class Solution {
    static ArrayList<Long> factorialNumbers(long n) {
        ArrayList<Long> result = new ArrayList<>();
        
        // Start recursion with first factorial (1! = 1)
        helper(1, 1, n, result);
        
        return result;
    }
    
    /**
     * Recursive helper function
     * @param fact : current factorial value
     * @param i    : current number whose factorial is being considered
     * @param n    : limit (factorials must be <= n)
     * @param result : list storing factorial numbers
     */
    static void helper(long fact, long i, long n, ArrayList<Long> result) {
        // Base case: if factorial exceeds n, stop recursion
        if (fact > n) return;
        
        // Store the current factorial
        result.add(fact);
        
        // Recursive call to calculate next factorial
        // next factorial = fact * (i + 1)
        helper(fact * (i + 1), i + 1, n, result);
    }
}
