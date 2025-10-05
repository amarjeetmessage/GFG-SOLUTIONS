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
    Node reverseList(Node head) {
        // code here
        
        //FOR OPTIMAL APPRAOCH USE THREE POINTER
        
        Node temp = head;
        if(temp == null || temp.next == null) return head;
        
        Stack<Node> stack = new Stack<>();
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        
        Node newHead = stack.pop();
        temp = newHead;
        
        while(!stack.isEmpty()){
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null;
        return newHead;
        
    }
}
