/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode s = head, d = head;
        while(d.next!=null && d.next.next!=null){
            s=s.next;
            d=d.next.next;
            if(d==s){
                d=head;
                while(s!=d){
                    s=s.next;
                    d=d.next;
                }
                return s;
            }
        }
        return null;
        
    }
}