// class Solution {
//     public ArrayList<String> binstr(int n) {
//         // code here
        
//     }
// }



class Solution {
    // recursive function to generate all binary strings
    public void binstrRec(char[] s, int i, ArrayList<String> res) {
        int n = s.length;

        // if string is complete, add to result
        if (i == n) {
            res.add(new String(s));
            return;
        }

        // assign '0' at current position
        s[i] = '0';
        binstrRec(s, i + 1, res);

        // assign '1' at current position
        s[i] = '1';
        binstrRec(s, i + 1, res);
    }

    public ArrayList<String> binstr(int n) {
        char[] s = new char[n];

        Arrays.fill(s, '0');

        ArrayList<String> res = new ArrayList<>();

        binstrRec(s, 0, res);

        return res;
    }
}


