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
        ListNode curr = head, root = head, next = null, prev = null;
        while(curr != null) {
            ListNode end = findKthNode(curr, k);
            if(end == null){
                if(curr != root){
                    prev.next = curr;
                }
                curr = null;
            } else {
                next = end.next;
                end.next = null;
                reverse(curr);
                if(curr == root){
                    root = end;
                }
                if(prev != null){
                    prev.next = end;
                }
                prev = curr;
                curr = next;
            }
        }
        return root;
    }
    public ListNode findKthNode(ListNode curr, int k){
        ListNode ans = curr;
        while(ans != null && k>1){
            ans = ans.next;
            k--;
        }
        return ans;
    }

    public void reverse(ListNode curr){
        ListNode head = curr, prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;

        }
    }
}