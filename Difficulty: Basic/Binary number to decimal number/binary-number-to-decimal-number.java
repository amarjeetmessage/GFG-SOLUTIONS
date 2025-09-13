class Solution {
    public int binaryToDecimal(String b) {
        int decNum = 0;
        int pow = 0;

        // Process from right to left
        for (int i = b.length() - 1; i >= 0; i--) {
            int bit = b.charAt(i) - '0'; // Get digit
            decNum += bit << pow;  // Use bit shifting instead of Math.pow
            pow++;
        }
        return decNum;
    }
}
