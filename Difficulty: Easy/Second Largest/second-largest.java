class Solution {
    public int getSecondLargest(int[] arr) {
        // मान लो पहले element को ही सबसे बड़ा
        int max = arr[0];
        int secMax = -1;   // second largest को initially -1 रख दिया

        // पूरे array को check करेंगे
        for (int i = 1; i < arr.length; i++) {
            
            if (arr[i] > max) {
                // जब नया बड़ा element मिले
                secMax = max;   // पुराना max अब second largest होगा
                max = arr[i];   // नया max update कर दो
            } 
            else if (arr[i] < max && arr[i] > secMax) {
                // जब element max से छोटा लेकिन secMax से बड़ा हो
                secMax = arr[i];
            }
        }

        return secMax;  // second largest मिलेगा, अगर नहीं मिला तो -1 ही रहेगा
    }
}
