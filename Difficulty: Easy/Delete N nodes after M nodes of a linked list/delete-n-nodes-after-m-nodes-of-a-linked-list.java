/*
delete n nodes after m nodes
The input list will have at least one element
Node is defined as
  class Node
  {
      int data;
      Node next;
      Node(int data)
      {
          this.data = data;
          this.next = null;
      }
  }
*/

class Solution {
    static void linkdelete(Node head, int n, int m) {
        // your code here
        // apply loop condition and write body to each time n nodes delete after skippint m nodes in a loop 
        
        
        /* while(curr != null) {
            //skip m nodes 
            //delete n nodes 
           }
        */
        
        Node curr = head;
        
        while(curr != null) {
            //skip m nodes
            int counter = 0;
            Node prev = null;
            
            while( counter < m && curr != null) {
                counter++;
                prev = curr;
                curr = curr.next;
            }
            
            
            //delete n nodes
            counter = 0;
            while(counter < n && curr != null) {
                counter++;
                curr = curr.next;
            }
            prev.next = curr;
        
        }
    }
}


