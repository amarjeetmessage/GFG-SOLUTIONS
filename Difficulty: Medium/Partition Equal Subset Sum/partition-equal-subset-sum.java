class Solution {

    public static boolean findSubset(int index, int target, int[] arr, Boolean[][] dp) {

        if (target < 0) return false;

        if (index < 0) {
            return target == 0;
        }

        if (dp[index][target] != null) {
            return dp[index][target];
        }

        boolean notTake = findSubset(index - 1, target, arr, dp);
        boolean take = findSubset(index - 1, target - arr[index], arr, dp);

        return dp[index][target] = take || notTake;
    }

    static boolean equalPartition(int[] arr) {

        int n = arr.length;

        int sum = 0;
        for (int x : arr) {
            sum += x;
        }

        if (sum % 2 != 0) return false;

        int target = sum / 2;

        Boolean[][] dp = new Boolean[n][target + 1];

        return findSubset(n - 1, target, arr, dp);
    }
}