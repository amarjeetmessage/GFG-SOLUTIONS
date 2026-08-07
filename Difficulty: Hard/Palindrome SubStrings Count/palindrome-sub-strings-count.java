
// // solve in O(n^3) 
// class Solution {
//     public boolean isPalindrome(String s) {
//         int i = 0; 
//         int j = s.length()-1;
        
//         while(i < j) {
//             if(s.charAt(i) == s.charAt(j)){
//                 i++;
//                 j--;
//             }else{
//                 return false;
//             }
//         }
//         return true;
//     }
//     public int countPS(String s) {
//         // code here
//         int count = 0;
//         int n = s.length();
        
//         for(int i = 0; i<n; i++){
//             for(int j = i+1; j<n; j++) {
//                 if(isPalindrome(s.substring(i, j+1))){
//                     count++;
//                 }
//             }
//         }
        
//         return count;
        
//     }
// }








// solve in O(n^2) 
class Solution {

    public int countPS(String s) {
        int n = s.length();
        int count = 0;

        // Odd length palindromes
        for (int center = 0; center < n; center++) {
            int left = center;
            int right = center;

            while (left >= 0 && right < n &&
                   s.charAt(left) == s.charAt(right)) {

                if (right - left + 1 >= 2)
                    count++;

                left--;
                right++;
            }
        }

        // Even length palindromes
        for (int center = 0; center < n - 1; center++) {
            int left = center;
            int right = center + 1;

            while (left >= 0 && right < n &&
                   s.charAt(left) == s.charAt(right)) {

                count++;

                left--;
                right++;
            }
        }

        return count;
    }
}