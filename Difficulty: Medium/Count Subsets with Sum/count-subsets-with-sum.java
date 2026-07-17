// class Solution {
    
//     public static int findSubset(int index, int target, int[] arr) {
//         // base case
//         if(index < 0 ){
//             if(target == 0) return 1;
//             else return 0;
//         }
        
        
//         // recursive call 
//         int res = findSubset(index -1, target, arr) +
//         findSubset(index -1, target - arr[index], arr);
        
        
//         // return
//         return res;
//     }
//     static int perfectSum(int[] arr, int target) {
//         // code here
//         int n = arr.length;
        
//         return findSubset(n-1, target, arr);
//     }
// }











class Solution {

    public static int findSubset(int index, int target, int[] arr, int[][] dp) {

        if (target < 0) return 0;

        if (index < 0) {
            return target == 0 ? 1 : 0;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        return dp[index][target] =
                findSubset(index - 1, target, arr, dp)
              + findSubset(index - 1, target - arr[index], arr, dp);
    }

    static int perfectSum(int[] arr, int target) {

        int n = arr.length;

        int[][] dp = new int[n][target + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return findSubset(n - 1, target, arr, dp);
    }
}


