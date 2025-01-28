/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        while(curr != null){
            Node n1 = new Node(curr.val);
            n1.next = curr.next;
            curr.next = n1;
            curr = curr.next.next;
        }
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        Node dummy = new Node(0);
        Node head1 = dummy;
        curr = head;
        while(curr != null){
            dummy.next = curr.next;
            curr.next = curr.next.next;
            dummy = dummy.next;
            curr = curr.next;
        }
        return head1.next;
    }
}