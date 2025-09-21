/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func hasCycle(head *ListNode) bool {
    if head == nil {
        return false;
    }
    var slow *ListNode = head
    var fast *ListNode = head

    for slow.Next != nil && fast.Next != nil && fast.Next.Next !=nil {
        slow = slow.Next
        fast = fast.Next.Next
        if slow == fast {
            return true
        }
    }
    return false
}