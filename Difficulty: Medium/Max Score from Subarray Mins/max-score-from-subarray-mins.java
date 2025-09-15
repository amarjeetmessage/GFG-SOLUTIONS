class Solution {
    public int maxSum(int arr[]) {
        // code here
        int sum = 0;
        int ans  = 0;
        for(int i = 0; i<arr.length-1; i++){
            sum = arr[i] + arr[i+1];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}