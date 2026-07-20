/* Definition for Node
class Node {
    int data;
    Node left;
    Node right;
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
} */

class Solution {
    static int sumBT(Node root) {
        // code here
        if(root == null) return 0;
       int leftSum = sumBT(root.left);
       int rightSum = sumBT(root.right);
    
       int sum = root.data + leftSum + rightSum;
       return sum;
    }
}