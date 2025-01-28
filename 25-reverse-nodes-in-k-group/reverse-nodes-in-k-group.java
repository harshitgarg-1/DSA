/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null, curr = head;
        while(curr != null){
            ListNode kthNode = findKNode(curr, k);
            ListNode next = null;
            if(kthNode == null){
                if(prev != null){
                    prev.next = curr;
                }
                break;
            } else {
                next = kthNode.next;
                kthNode.next = null;
                reverse(curr);
                if(head == curr) head = kthNode;
                if(prev != null) prev.next = kthNode;
                prev = curr;
                curr = next;
            }
        }

        return head;
    }

    public ListNode findKNode(ListNode head, int k) {
        ListNode curr = head;
        while(k>1 && curr != null){
            curr = curr.next;
            k--;
        }
        return curr;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


}