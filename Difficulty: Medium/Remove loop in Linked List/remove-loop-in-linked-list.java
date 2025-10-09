/*
class Node
{
    int data;
    Node next;
}
*/

class Solution {
    public static void removeLoop(Node head) {
        if (head == null || head.next == null)
            return;

        Node slow = head;
        Node fast = head;

        // Step 1: Detect Loop using Floyd's Cycle Detection
        boolean hasLoop = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // Loop detected
                hasLoop = true;
                break;
            }
        }

        // Step 2: If no loop found, just return
        if (!hasLoop)
            return;

        // Step 3: Find the start of the loop
        slow = head;

        // Case 1: Loop does not start at head
        if (slow != fast) {
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            // Step 4: Break the loop
            fast.next = null;
        } 
        // Case 2: Loop starts at head node
        else {
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
        }
    }
}
