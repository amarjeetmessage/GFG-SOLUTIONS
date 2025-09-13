class Solution {
    public static long sumOfDivisors(long n) {
        // code here
        long sum = 0;
        for(int i = 1; i<=n; i++){
            sum += i*(n/i);
        }
        return sum;
        
        
        
        
        
    }
}