class Solution {
    
    static int solve(int n) {
        if(n == 0) return 1;
        if(n == 1 || n == 2) return n;
        
        return solve(n-1) + solve(n-2) + solve(n-3);
    }

    static int countWays(int n) {
        // add your code here
        return solve(n);
    }
}
