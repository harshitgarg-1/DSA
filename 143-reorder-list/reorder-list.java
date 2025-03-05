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
    public void reorderList(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode curr = head;
        while(curr != null){
            st.push(curr);
            curr = curr.next;
        }
        curr = head;
        while(true){
            ListNode add = st.pop();
            add.next=null;
            if(curr==add) return;
            ListNode next = curr.next;
            curr.next = add;
            if(add==next) return;
            add.next = next;
            curr=next;
        }
    }
}