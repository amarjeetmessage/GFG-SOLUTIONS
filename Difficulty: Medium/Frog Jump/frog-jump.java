class Solution {
    int minCost(int[] height) {
        int n = height.length;
        int[] dp = new int[n];
        Arrays.fill(dp , -1);
        
        return cost(height , n-1 , dp);
        
    }
    
    public static int cost(int[] height , int n, int[] dp) {
        
        //base case
        if(n == 0) return 0;
        if(n == 1) return Math.abs(height[1] - height[0]);
        
        if(dp[n] != -1) {
            return dp[n];
        }
        
        int cost1 = cost(height , n-1 , dp) + Math.abs(height[n] - height[n-1]);
        
        int cost2 = cost(height , n-2 , dp) + Math.abs(height[n] - height[n-2]);
        
        dp[n] =  Math.min(cost1, cost2);
        return dp[n];
        
        
    }
}