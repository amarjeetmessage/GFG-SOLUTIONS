import java.util.*;

class Solution {
    static int[][] dp;

    public int knapsack(int W, int val[], int wt[]) {
        int n = wt.length;
        dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(val, wt, W, n - 1);
    }

    public static int solve(int[] val, int[] wt, int W, int i) {
        if (i < 0 || W == 0) return 0;

        if (dp[i][W] != -1) return dp[i][W];

        if (wt[i] <= W) {
            int take = val[i] + solve(val, wt, W - wt[i], i - 1);
            int notTake = solve(val, wt, W, i - 1);
            return dp[i][W] = Math.max(take, notTake);
        }

        return dp[i][W] = solve(val, wt, W, i - 1);
    }
}
