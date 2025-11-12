// class Solution {
//     public int nCr(int n, int r) {
//         // code here
        
//         if(r>n) return 0;
        
//         int[] dp = new int[n+1];
//         Arrays.fill(dp , -1);
        
            
//         int a = fact(n,dp);
//         int b = fact(r, dp);
//         int c = fact(n-r, dp);
        
//         int result = a/ (b*c);
        
//         return result;
        
//     }
    
//     public static int fact(int n,int[] dp) {
//         //base case
//         if(n == 0 || n == 1) return 1;
        
//         if(dp[n] != -1) {
//             return dp[n];
//         }
        
//         dp[n] = n*fact(n-1,dp);
        
//         return dp[n];
//     }
// }



// GFG: nCr Problem
class Solution {
    static final int MOD = 1000000007;

    public int nCr(int n, int r) {
        if (r > n) return 0;
        if (r == 0 || r == n) return 1;

        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        long numerator = fact[n];
        long denominator = (fact[r] * fact[n - r]) % MOD;

        long invDenominator = modInverse(denominator, MOD);
        long ans = (numerator * invDenominator) % MOD;

        return (int) ans;
    }

    // Modular exponentiation (for modular inverse)
    private long modInverse(long a, int mod) {
        return power(a, mod - 2, mod);
    }

    private long power(long a, long b, int mod) {
        long res = 1;
        a = a % mod;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }
}
