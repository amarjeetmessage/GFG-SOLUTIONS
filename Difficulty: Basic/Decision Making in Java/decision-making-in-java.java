// User function Template for Java
class Solution {
    public static String compareNM(int n, int m) {
        // code here
        if(n<m){
            return "lesser";
        }
        if(m<n){
            return "greater";
        }
        else{
            return "equal";
        }
    }
}