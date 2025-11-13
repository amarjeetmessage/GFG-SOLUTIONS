class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        
        int n = arr.length;

        int[][] dp = new int[n+1][sum+1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(arr, sum, n, dp);
    }

    public static boolean solve(int[] arr, int sum, int n, int[][] dp) {
        if(sum == 0) return true;
        if(n == 0) return false;

        if(dp[n-1][sum-1] != -1) {
            return dp[n-1][sum-1] == 1;  // convert int to boolean
        }

        boolean notpick = solve(arr, sum, n-1, dp);
        boolean pick = false;  // declare outside so it's in scope below

        if(arr[n-1] <= sum) {
            pick = solve(arr, sum - arr[n-1], n-1, dp);
        }

        boolean result = pick || notpick;
        dp[n-1][sum-1] = result ? 1 : 0;  // store boolean as int
        return result;
    }
}
