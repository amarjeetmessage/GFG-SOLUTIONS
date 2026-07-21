/*

==========================
PSEUDOCODE
==========================

Boundary Traversal consists of 4 parts

1. Print Root
2. Print Left Boundary (excluding leaf nodes)
3. Print All Leaf Nodes
4. Print Right Boundary (excluding leaf nodes) in Reverse Order

------------------------------------------------

BoundaryTraversal(root)

if root == NULL
    return

if root is not leaf
    add root

Add Left Boundary

Add Leaf Nodes

Add Right Boundary

return answer

------------------------------------------------

Left Boundary

curr = root.left

while(curr != null)

    if curr is not leaf
        add curr

    if left child exists
        move left
    else
        move right

------------------------------------------------

Leaf Nodes

DFS

if node is leaf
    add node

visit left

visit right

------------------------------------------------

Right Boundary

curr = root.right

while(curr != null)

    if curr is not leaf
        push into stack

    if right exists
        move right
    else
        move left

Pop everything from stack
and add into answer

*/
class Solution {

    //------------------------------------------------------------
    // Check whether current node is a Leaf Node
    //------------------------------------------------------------
    public boolean isLeaf(Node node) {

        // Leaf node means both children are NULL
        return node.left == null && node.right == null;
    }

    //------------------------------------------------------------
    // Add Left Boundary
    // (Ignore all leaf nodes)
    //------------------------------------------------------------
    public void insertLeftBoundary(ArrayList<Integer> res, Node root) {

        // Start from left child of root
        Node curr = root.left;

        while (curr != null) {

            // Boundary should not contain leaf nodes
            // because leaf traversal will add them later
            if (!isLeaf(curr))
                res.add(curr.data);

            // Prefer moving left
            if (curr.left != null)
                curr = curr.left;

            // Otherwise move right
            else
                curr = curr.right;
        }
    }

    //------------------------------------------------------------
    // Add all Leaf Nodes using DFS
    //------------------------------------------------------------
    public void insertLeafNodes(ArrayList<Integer> res, Node root) {

        if (root == null)
            return;

        // If current node is leaf
        if (isLeaf(root)) {

            res.add(root.data);
            return;
        }

        // Visit Left Subtree
        insertLeafNodes(res, root.left);

        // Visit Right Subtree
        insertLeafNodes(res, root.right);
    }

    //------------------------------------------------------------
    // Add Right Boundary
    // Store inside stack to reverse the order
    //------------------------------------------------------------
    public void insertRightBoundary(ArrayList<Integer> res, Node root) {

        // Start from right child
        Node curr = root.right;

        Stack<Integer> st = new Stack<>();

        while (curr != null) {

            // Ignore leaf nodes
            if (!isLeaf(curr))
                st.push(curr.data);

            // Prefer moving right
            if (curr.right != null)
                curr = curr.right;

            // Otherwise move left
            else
                curr = curr.left;
        }

        // Reverse order
        while (!st.isEmpty()) {
            res.add(st.pop());
        }
    }

    //------------------------------------------------------------
    // Main Function
    //------------------------------------------------------------
    ArrayList<Integer> boundaryTraversal(Node root) {

        ArrayList<Integer> res = new ArrayList<>();

        // Empty Tree
        if (root == null)
            return res;

        // Add Root only if it is NOT a leaf
        // Otherwise leaf traversal will print it again
        if (!isLeaf(root))
            res.add(root.data);

        //--------------------------------------------------------
        // Step 1 : Left Boundary
        //--------------------------------------------------------
        insertLeftBoundary(res, root);

        //--------------------------------------------------------
        // Step 2 : All Leaf Nodes
        //--------------------------------------------------------
        insertLeafNodes(res, root);

        //--------------------------------------------------------
        // Step 3 : Right Boundary
        //--------------------------------------------------------
        insertRightBoundary(res, root);

        return res;
    }
}
