import java.util.*;

class Solution {
    public int activitySelection(int[] start, int[] finish) {
        int n = start.length;
        if (n == 0) return 0;

        // Step 1: Pair start and finish times
        int[][] activities = new int[n][2];
        for (int i = 0; i < n; i++) {
            activities[i][0] = start[i];   // start time
            activities[i][1] = finish[i];  // finish time
        }

        // Step 2: Sort activities by finish time (ascending)
        Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));

        // Step 3: Select first activity
        int count = 1;
        int lastFinish = activities[0][1];

        // Step 4: Check remaining activities
        for (int i = 1; i < n; i++) {
            // strictly greater (no overlapping allowed)
            if (activities[i][0] > lastFinish) {
                count++;
                lastFinish = activities[i][1];
            }
        }

        // Step 5: Return max count of non-overlapping activities
        return count;
    }
}
