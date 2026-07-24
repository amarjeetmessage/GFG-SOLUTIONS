// class Solution {

//     // Stores the maximum substring length found so far
//     int result = 0;

//     public int solve(int m, int n, String s1, String s2) {

//         // No characters left to compare
//         if (m == 0 || n == 0)
//             return 0;

//         int ans = 0;

//         // Characters match -> extend current substring
//         if (s1.charAt(m - 1) == s2.charAt(n - 1)) {

//             ans = 1 + solve(m - 1, n - 1, s1, s2);

//             // Update overall maximum length
//             result = Math.max(result, ans);
//         }

//         // Explore other possible ending positions
//         solve(m - 1, n, s1, s2);
//         solve(m, n - 1, s1, s2);

//         // Return current substring length
//         return ans;
//     }

//     public int longCommSubstr(String s1, String s2) {

//         solve(s1.length(), s2.length(), s1, s2);

//         return result;
//     }
// }






// // memoization
class Solution {

    int result = 0;

    public int solve(int m, int n, String s1, String s2, int[][] dp) {

        if (m == 0 || n == 0)
            return 0;

        if (dp[m][n] != -1)
            return dp[m][n];

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            dp[m][n] = 1 + solve(m - 1, n - 1, s1, s2, dp);
            result = Math.max(result, dp[m][n]);
        } else {
            dp[m][n] = 0;
        }

        solve(m - 1, n, s1, s2, dp);
        solve(m, n - 1, s1, s2, dp);

        return dp[m][n];
    }

    public int longCommSubstr(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }

        solve(m, n, s1, s2, dp);

        return result;
    }
}