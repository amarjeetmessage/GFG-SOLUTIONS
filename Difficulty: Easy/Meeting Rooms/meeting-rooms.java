//brute force appraoch tc = O(N^2) and sc = O(1)

// class Solution {
//     static boolean canAttend(int[][] arr) {
//         // code here
//         //   2....4
//         //                   9...12
//         //            6.......10
//         for(int i = 0; i<arr.length; i++) {
//             int s1 = arr[i][0],
//                 e1 = arr[i][1] -1;
            
//             for(int j = i + 1; j<arr.length; j++) {
                 
//                 int s2 = arr[j][0],
//                     e2 = arr[j][1] - 1;
                    
//                     if(e1 >= s2 && e2 >= s1) {
//                         return false;
//                     }
//             }
//         }
//         return true;
        
//     }
// }



//optimized approach 
class Solution {
    static boolean canAttend(int[][] arr) {
        // code here
        // sort by start time
        
        Arrays.sort(arr, (a,b) -> a[0] - b[0]);
        
        //  [[2, 4], [9, 12], [6, 10]]
        // sorted [[2,4], [6, 10], [9,12]]
        
        for(int i = 1; i<arr.length; i++) {
            int s2 = arr[i][0];
            int e1 = arr[i-1][1];
            
            if(s2 < e1){
                return false;
            }
        }
        return true;
        
    }
}