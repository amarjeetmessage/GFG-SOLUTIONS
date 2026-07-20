/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}
*/

class Pair {

    Node node;
    int hd; // Horizontal Distance

    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

class Solution {

    public ArrayList<Integer> bottomView(Node root) {

        ArrayList<Integer> ans = new ArrayList<>();

        // Case 1 : Empty Tree
        if (root == null)
            return ans;

        // TreeMap stores
        // Horizontal Distance -> Node Value
        //
        // TreeMap is used because
        // it automatically keeps keys sorted.
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Queue for BFS
        Queue<Pair> q = new LinkedList<>();

        // Root starts at Horizontal Distance = 0
        q.offer(new Pair(root, 0));

        // Perform Level Order Traversal
        while (!q.isEmpty()) {

            Pair curr = q.poll();

            Node node = curr.node;

            int hd = curr.hd;

            // ************************************************
            // IMPORTANT
            //
            // For Bottom View,
            // ALWAYS update the node.
            //
            // Why?
            //
            // Because BFS reaches deeper nodes later.
            // The latest node at a Horizontal Distance
            // is the bottom-most visible node.
            // ************************************************
            map.put(hd, node.data);

            // Left Child
            //
            // Horizontal Distance decreases by 1
            if (node.left != null)
                q.offer(new Pair(node.left, hd - 1));

            // Right Child
            //
            // Horizontal Distance increases by 1
            if (node.right != null)
                q.offer(new Pair(node.right, hd + 1));
        }

        // TreeMap gives keys in sorted order
        for (int value : map.values())
            ans.add(value);

        return ans;
    }
}