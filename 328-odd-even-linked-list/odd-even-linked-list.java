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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode();
        ListNode even = new ListNode();
        ListNode newOddHead = odd, newEvenHead = even;
        ListNode curr = head;
        int count = 1;
        while(curr != null){
            if(count % 2 == 0){
                even.next = curr;
                even = even.next;
            } else {
                odd.next = curr;
                odd = odd.next;
            }
            curr = curr.next;
            count++;
        }
        even.next = null;
        odd.next = newEvenHead.next;
        return newOddHead.next;
    }
}