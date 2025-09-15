class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        if (arr.length < 2) return -1;
        
        // Initialize with first element
        int max = arr[0];
        int secMax = -1;  // -1 indicates no second max found yet
        
        for(int i = 1; i < arr.length; i++) {  // Start from index 1
            if(arr[i] > max) {
                secMax = max;
                max = arr[i];
            }
            else if(arr[i] > secMax && arr[i] < max) {
                secMax = arr[i];
            }
        }
        
        return secMax;
    }
}