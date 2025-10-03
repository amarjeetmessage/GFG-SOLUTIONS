/*
class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
}*/

class Solution {
    public int getCount(Node head) {
        // code here
        int size = 0;
        Node temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }
}