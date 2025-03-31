/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        helper(root, k, pq);
        if(pq.size()<k) return -1;
        return pq.peek();
    }

    public int helper(TreeNode root, int k, PriorityQueue<Integer> pq) {
        if(root==null) return 0;
        int left = helper(root.left, k, pq);
        int right = helper(root.right, k, pq);
        if(left == -1 || right == -1 || left != right) return -1;
        if(pq.size()<k ) pq.add(left+right+1);
        else if (pq.peek()<left+right+1){
            pq.poll();
            pq.add(left+right+1);
        }
        return left+right+1;
    }
}