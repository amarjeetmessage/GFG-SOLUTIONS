/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/class Solution {
    public ArrayList<Integer> leftView(Node root) {

        ArrayList<Integer> ans = new ArrayList<>();

        // Empty tree
        if (root == null)
            return ans;

        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {

            // Number of nodes in current level
            int size = q.size();

            // Traverse current level
            for (int i = 0; i < size; i++) {

                Node node = q.poll();

                // First node of current level
                if (i == 0)
                    ans.add(node.data);

                // Push left child
                if (node.left != null)
                    q.offer(node.left);

                // Push right child
                if (node.right != null)
                    q.offer(node.right);
            }
        }

        return ans;
    }
}