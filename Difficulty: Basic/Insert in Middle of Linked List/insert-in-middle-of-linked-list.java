/*
Structure of node class is:
class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    public Node insertInMiddle(Node head, int x) {
        // Step 1: if list is empty, new node becomes head
        if (head == null) {
            return new Node(x);
        }

        // Step 2: count number of nodes
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // Step 3: find the middle node
        int midPos = (size+1) / 2;  // standard middle position
        Node mid = head;
        for (int i = 1; i < midPos; i++) {
            mid = mid.next;
        }

        // Step 4: insert new node after middle
        Node newNode = new Node(x);
        newNode.next = mid.next;
        mid.next = newNode;

        // Step 5: return head
        return head;
    }
}
