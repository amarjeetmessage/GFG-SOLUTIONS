class Solution {
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                dp[i][j] = -1;
            }
        }
         return helper(0, n-1, arr,dp);
         
    }
    
    public static int helper(int i, int j, int[] arr, int[][] dp) {
        //base case 
        if(i+1 == j) return 0;
        
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int ans = Integer.MAX_VALUE;
        for(int k = i+1; k<=j-1; k++) {
            int curr = helper(i,k,arr,dp) + helper(k,j,arr,dp) + arr[i] * arr[j]* arr[k];
            
            ans = Math.min(ans, curr);
        }
        
        return dp[i][j] = ans;
    }
}