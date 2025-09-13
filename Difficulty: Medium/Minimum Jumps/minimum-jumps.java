// GFG Style: Minimum Jumps to Reach End
// Multiple approaches included
// Greedy O(n) is active for submission

class Solution {

    // ---------------------------
    // Approach 1: Greedy (Optimal O(n)) ✅ ACTIVE
    // ---------------------------
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0; // already at last index
        if (arr[0] == 0) return -1; // can't move at all

        int jumps = 1;              // we need at least one jump
        int maxReach = arr[0];      // farthest index reachable so far
        int steps = arr[0];         // steps we can still take in current jump

        for (int i = 1; i < n; i++) {
            if (i == n - 1) return jumps; // reached end

            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;

            if (steps == 0) { // must take a new jump
                jumps++;
                if (i >= maxReach) return -1; // cannot progress further
                steps = maxReach - i; // reset steps for new range
            }
        }
        return -1;
    }


    /* ---------------------------
    // Approach 2: Dynamic Programming (O(n^2))
    // ---------------------------
    public int minJumps(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (j + arr[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1] >= Integer.MAX_VALUE / 2 ? -1 : dp[n - 1];
    }
    */


    /* ---------------------------
    // Approach 3: BFS (Level Order Traversal) - O(n^2) in worst case
    // ---------------------------
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;
        if (arr[0] == 0) return -1;

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        q.add(0);
        visited[0] = true;

        int jumps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int idx = q.poll();
                if (idx == n - 1) return jumps;

                int maxReach = Math.min(n - 1, idx + arr[idx]);
                for (int next = idx + 1; next <= maxReach; next++) {
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            jumps++;
        }
        return -1;
    }
    */
}
