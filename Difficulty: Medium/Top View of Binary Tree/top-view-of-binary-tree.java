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

    public ArrayList<Integer> topView(Node root) {

        ArrayList<Integer> ans = new ArrayList<>();

        // Empty Tree
        if (root == null)
            return ans;

        // Stores
        // Horizontal Distance -> Node Value
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // BFS Queue
        Queue<Pair> q = new LinkedList<>();

        // Root is at Horizontal Distance 0
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            Node node = curr.node;
            int hd = curr.hd;

            // Store only the FIRST node
            // for every Horizontal Distance
            if (!map.containsKey(hd))
                map.put(hd, node.data);

            // Left Child
            // Horizontal Distance decreases by 1
            if (node.left != null)
                q.offer(new Pair(node.left, hd - 1));

            // Right Child
            // Horizontal Distance increases by 1
            if (node.right != null)
                q.offer(new Pair(node.right, hd + 1));
        }

        // TreeMap automatically gives
        // keys in sorted order
        for (int value : map.values())
            ans.add(value);

        return ans;
    }
}