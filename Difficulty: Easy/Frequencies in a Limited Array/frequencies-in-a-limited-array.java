import java.util.*;

class Solution {
    public List<Integer> frequencyCount(int[] arr) {
        int n = arr.length;
        int[] hash = new int[n + 1]; // hash to count frequencies (1..n)
        
        // Count frequencies only for numbers in [1..n]
        for (int num : arr) {
            if (num >= 1 && num <= n) {
                hash[num]++;
            }
        }
        
        // Prepare result list
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ans.add(hash[i]);
        }
        
        return ans;
    }
}
