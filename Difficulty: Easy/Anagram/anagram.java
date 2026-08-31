class Solution {
    public static boolean areAnagrams(String s1, String s2) {
        // code here
        
        int len1 = s1.length();
        int len2 = s2.length();
        
        if(len1 != len2) return false;
        
        int[] freq = new int[26];
        for(int i = 0; i<len1; i++){
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }
        
        
        for(int count: freq){
            if(count != 0){
                return false;
            }
        }
        
        return true;
        
    }
}