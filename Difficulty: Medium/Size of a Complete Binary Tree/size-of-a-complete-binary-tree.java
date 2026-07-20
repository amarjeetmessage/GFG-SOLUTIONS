
class Solution {

    public int findLeftHeight(Node root){
        if(root == null) return 0;
        int count = 0;
        while(root != null) {
            count++;
            root = root.left;
        }
        return count;
    }
    public int findRightHeight(Node root){
        if(root == null) return 0;
        int count = 0;
        while(root != null) {
            count++;
            root = root.right;
        }
        return count;
    }
    public int countNodes(Node root) {
        if(root == null) return 0;

        int leftHeight = findLeftHeight(root);
        int RightHeight = findRightHeight(root);

        if(leftHeight == RightHeight) {
            return ((int)Math.pow(2,leftHeight) -1);
        }

        // now solve recursively if not equal height
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return 1 + (leftCount + rightCount);
        
    }
}