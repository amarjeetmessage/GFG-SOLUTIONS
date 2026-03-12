class Solution {
    
    public int knapsack(int W, int val[], int wt[]) {
        int n = wt.length;
        
        int[][] dp = new int[n+1][W+1];
        
        for(int i = 0; i<=n; i++) {
            Arrays.fill(dp[i] , -1);
        }
        return solve(wt, val, W, n,dp);
    }
    
    public int solve(int wt[], int val[], int W, int n, int[][] dp) {
        
        if(n == 0 || W == 0) return 0;
        
        if(dp[n][W] != -1) {
            return dp[n][W];
        }
        
        int notpick = solve(wt, val, W, n-1,dp);
        
        int pick = 0;
        if(wt[n-1] <= W) {
            pick = val[n-1] + solve(wt, val, W - wt[n-1], n-1,dp);
        }
        
        return dp[n][W] = Math.max(pick, notpick);
    }
}