// class Solution {
// 	public int minOperations(String s1, String s2) {
// 		// NOTE: this is same as leetcode 516 && 1143 just find the length of palindrome and return (length of s1 - palindrome length) + length of s2 - palindrome length)
	
	    
	    
// 	}
	
// }



// memoizaton code
class Solution {
    public int solve(int m, int n, String text1, String text2,int[][] dp) {
        // base case 
        if(m == 0 || n == 0) return 0;

        if(dp[m][n] != -1) {
            return dp[m][n];
        }

        // recursive code 

        // two case if char match
        if(text1.charAt(m-1) == text2.charAt(n-1)) {
            return dp[m][n] =  1 + solve(m-1,n-1,text1,text2,dp);
        }
        // if not match
        else{
            return dp[m][n] = Math.max(solve(m-1,n,text1,text2,dp) , solve(m,n-1,text1,text2, dp));
        }
    }
    public int minOperations(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i<=m; i++){
            Arrays.fill(dp[i] , -1);
        }
        int res = solve(m,n,text1,text2,dp);
        int ans = m-res+n-res;
        return ans;
    }
}
