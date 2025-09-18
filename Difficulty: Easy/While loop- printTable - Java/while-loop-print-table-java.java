class Solution {
    public void calculateMultiples(int n) {
        int i = 10;  // start from 10th multiple
        while (i >= 1) {
            System.out.print(n * i + " ");
            i--;
        }
    }
}
