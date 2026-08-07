// class Solution {
//     static int solve(int n, int k,int[][] dp) {
//         // code here
//         if(n == 1) return k;
//         if(k == 0) return 0;
//         if(k == 1) return 1;
        
//         if(dp[n][k] != -1){
//             return dp[n][k];
//         }
        
//         int result = Integer.MAX_VALUE;
//         for(int j = 1; j<=k; j++){
//             int ans =1+ Math.max(solve(n-1,j-1,dp), 
//                                 solve(n,k-j,dp));
                                
//             result = Math.min(result, ans);
//         }
//         return dp[n][k] = result;
//     }
    
//     static int eggDrop(int n, int k) {
//         // code here
//         int[][] dp = new int[n+1][k+1];
//         for(int i = 0; i<=n; i++){
//             Arrays.fill(dp[i], -1);
//         }
//         return solve(n,k,dp);
//     }
// }









// class Solution {

//     static int solve(int n, int k, int[][] dp) {

//         if (k == 0 || k == 1)
//             return k;

//         if (n == 1)
//             return k;

//         if (dp[n][k] != -1)
//             return dp[n][k];

//         int low = 1;
//         int high = k;

//         int ans = Integer.MAX_VALUE;

//         while (low <= high) {

//             int mid = low + (high - low) / 2;

//             int breakEgg = solve(n - 1, mid - 1, dp);

//             int notBreak = solve(n, k - mid, dp);

//             int temp = 1 + Math.max(breakEgg, notBreak);

//             ans = Math.min(ans, temp);

//             if (breakEgg < notBreak) {
//                 low = mid + 1;
//             } else {
//                 high = mid - 1;
//             }
//         }

//         return dp[n][k] = ans;
//     }

//     static int eggDrop(int n, int k) {

//         int[][] dp = new int[n + 1][k + 1];

//         for (int i = 0; i <= n; i++)
//             Arrays.fill(dp[i], -1);

//         return solve(n, k, dp);
//     }
// }









class Solution {

    int findTotalFloor(int eggs, int moves) {
        if (eggs == 0 || moves == 0)
            return 0;

        if (eggs == 1)
            return moves;

        return 1 + findTotalFloor(eggs - 1, moves - 1)
                 + findTotalFloor(eggs, moves - 1);
    }

    public int eggDrop(int n, int k) {

        // moves = 0,1,2,3,4,5...
        int moves = 0;

        while (findTotalFloor(n, moves) < k) {
            moves++;
        }

        return moves;
    }
}