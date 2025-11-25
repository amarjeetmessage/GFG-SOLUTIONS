/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        // code here
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast ) {
                break;
            }
        }
        if(fast == null || fast.next == null) {//chcking for length 1 node
            return 0;
        }
        
        Node n1 = head;
        Node n2 = slow;
        
        while(n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        
        int count = 1;
        Node curr = n1.next;
        
        while(curr != n1) {
            count= count+1;
            curr = curr.next;
        }
        return count;
    }
}