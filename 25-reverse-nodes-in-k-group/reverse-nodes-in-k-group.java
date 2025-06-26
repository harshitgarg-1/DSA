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
        ListNode prev = null, newHead = null, curr = head;
        while(curr != null){
            ListNode next = null;
            ListNode kth = kthNode(curr, k);
            if(kth==null){
                if(prev==null){
                    newHead = curr;
                } else {
                    prev.next = curr;
                }
                curr = null;
            } else {
                next = kth.next;
                kth.next = null;
                reverse(curr);
                if(prev==null){
                    newHead = kth;
                } else {
                    prev.next = kth;
                }
                prev = curr;
                curr = next;
            }
        }
        return newHead;
    }
    public ListNode kthNode(ListNode head, int k) {
        while(head != null && k>1) {
            head = head.next;
            k--;
        }
        return head;
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