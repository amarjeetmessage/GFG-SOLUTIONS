class Solution {
    public int findMin(int n) {
        // code here
        int sum = 0;
        sum = sum + n / 10;
        n = n % 10;
        sum = sum + n / 5;
        n = n % 5;
        sum = sum + n / 2;
        n = n % 2;
        sum = sum + n / 1;
        return sum ;
    }
}
