/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node curr = head;
        while(curr != null){
            if(curr.child != null){
                Node temp = flatten(curr.child);
                curr.child = null;
                Node next = curr.next;
                Node last = findLast(temp);
                if(next != null){
                    last.next = next;
                    next.prev = last;
                }
                curr.next = temp;
                temp.prev = curr;
                curr = next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
    public Node findLast(Node head) {
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        return curr;
    }
}