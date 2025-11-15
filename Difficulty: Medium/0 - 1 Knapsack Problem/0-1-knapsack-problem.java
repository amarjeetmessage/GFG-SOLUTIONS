// class Solution {

//     public int knapsack(int W, int val[], int wt[]) {
//         int n = wt.length;

//         int[][] dp = new int[n + 1][W + 1];
//         for (int i = 0; i <= n; i++) {
//             Arrays.fill(dp[i], -1);
//         }

//         return solve(val, wt, W, n - 1, dp);
//     }

//     public static int solve(int[] val, int[] wt, int W, int n, int[][] dp) {
//         // base case
//         if (n < 0 || W == 0) return 0;

//         if (dp[n][W] != -1) {
//             return dp[n][W];
//         }

//         int take = Integer.MIN_VALUE;
//         if (wt[n] <= W) {
//             take = val[n] + solve(val, wt, W - wt[n], n - 1, dp);
//         }

//         int notTake = solve(val, wt, W, n - 1, dp);

//         dp[n][W] = Math.max(take, notTake);
//         return dp[n][W];
//     }
// }

















class Solution {

    public int knapsack(int W, int val[], int wt[]) {
        int n = wt.length;

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 0);
        }

        for (int i = 0; i < n; i++) {
            for (int w = 0; w <= W; w++) {
                int take = Integer.MIN_VALUE;
                int notTake = 0;

                if (wt[i] <= w) {
                    take = val[i] + dp[i][w - wt[i]];
                }

                notTake = dp[i][w];

                dp[i + 1][w] = Math.max(take, notTake);
            }
        }

        return dp[n][W];
    }
}


