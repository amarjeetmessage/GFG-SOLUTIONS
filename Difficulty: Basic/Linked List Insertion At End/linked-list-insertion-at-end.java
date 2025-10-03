/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node insertAtEnd(Node head, int x) {
        // Step 1: create a new node
        Node newNode = new Node(x);

        // Step 2: if list is empty, new node becomes the head
        if (head == null) {
            return newNode;
        }

        // Step 3: traverse to the last node
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        // Step 4: link the last node to newNode
        curr.next = newNode;

        // Step 5: return the head of the list
        return head;
    }
}
