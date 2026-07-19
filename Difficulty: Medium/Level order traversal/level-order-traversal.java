/* A binary tree Node
class Node {
    public int data;
    public Node left;
    public Node right;

    // Constructor
    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/

class Solution {
    public ArrayList<Integer> levelOrder(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        
        q.offer(root);
        
        while(!q.isEmpty()){
            Node current = q.poll();
            
            list.add(current.data);
            
            if(current.left != null){
                q.offer(current.left);
            }
            
            if(current.right != null) {
                q.offer(current.right);
            }
        }
        
        return list;
    }
}