// User function Template for Java

class Solution {
    static int evenlyDivides(int n) {
        int temp = n;
        int count = 0;
        
        while (n > 0) {
            int digit = n % 10;  // extract last digit
            if (digit != 0 && temp % digit == 0) { // check digit not zero
                count++;
            }
            n = n / 10;  // remove last digit
        }
        
        return count;
    }
}
