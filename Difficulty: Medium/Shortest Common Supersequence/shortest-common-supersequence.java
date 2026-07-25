

/*
 * Shortest Common Supersequence (SCS)
 * -----------------------------------
 *
 * There are TWO types of questions:
 *
 * 1) Find the LENGTH of SCS
 *    -> No need to construct the string.
 *    -> Just find the LCS length.
 *
 *       SCS Length = s1.length() + s2.length() - LCS Length
 *
 *    Reason:
 *    - LCS is common in both strings.
 *    - While adding both lengths, common characters are counted twice.
 *    - Subtract LCS once.
 *
 * -------------------------------------------------------------
 *
 * 2) Find the ACTUAL SCS STRING
 *    -> Formula is NOT enough.
 *    -> We must construct the shortest string.
 *
 *    Steps:
 *    1. Build the LCS DP table.
 *    2. Backtrack from dp[n][m].
 *    3. If characters match:
 *         -> Add the character once.
 *         -> Move diagonally.
 *    4. Else:
 *         -> Move towards the larger DP value.
 *         -> Add the skipped character to the answer.
 *    5. Append remaining characters of either string.
 *    6. Reverse the answer (since backtracking is done from the end).
 *
 *    Intuition:
 *    - While backtracking, every skipped character must be included
 *      because the final answer should contain both strings.
 *
 * -------------------------------------------------------------
 *
 * Quick Revision:
 *
 * Length Question  -> n + m - LCS
 * String Question  -> LCS DP + Backtracking + Add skipped chars + Reverse
 */
 
 
// class Solution {

//     public static int solve(int m, int n, String s1, String s2) {

//         // Base Case
//         if (m == 0 || n == 0)
//             return 0;

//         // Characters match
//         if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
//             return 1 + solve(m - 1, n - 1, s1, s2);
//         }

//         // Characters don't match
//         return Math.max(
//                 solve(m - 1, n, s1, s2),
//                 solve(m, n - 1, s1, s2)
//         );
//     }

//     public static int minSuperSeq(String s1, String s2) {

//         int m = s1.length();
//         int n = s2.length();

//         int lcsCount = solve(m, n, s1, s2);

//         return m + n - lcsCount;
//     }
// }







// // memoization
class Solution {

    public static int solve(int m, int n, String s1, String s2, int[][] dp) {

        // Base Case
        if (m == 0 || n == 0)
            return 0;

        // Already computed
        if (dp[m][n] != -1)
            return dp[m][n];

        // Characters match
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return dp[m][n] = 1 + solve(m - 1, n - 1, s1, s2, dp);
        }

        // Characters don't match
        return dp[m][n] = Math.max(
                solve(m - 1, n, s1, s2, dp),
                solve(m, n - 1, s1, s2, dp)
        );
    }

    public static int minSuperSeq(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }

        int lcsCount = solve(m, n, s1, s2, dp);

        return m + n - lcsCount;
    }
}