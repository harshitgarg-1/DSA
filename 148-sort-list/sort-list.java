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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = findMiddle(head);
        ListNode next = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(next);
        return merge(left, right);

    }
    public ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode left, ListNode right){
        ListNode head = new ListNode();
        ListNode curr = head;
        while(left != null && right != null){
            if(left.val < right.val){
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }
        if(left != null) head.next = left;
        if(right != null) head.next = right;
        return curr.next;
    }
}