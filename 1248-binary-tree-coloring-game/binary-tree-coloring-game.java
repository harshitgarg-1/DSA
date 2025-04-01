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
    TreeNode p1 = null;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int total = countNode(root, x);
        int left = countNode(p1.left, -1);
        int right = countNode(p1.right, -1);
        int par = total-left-right-1;
        if(left+right+1<par || left+par+1<right || right+par+1<left) return true;
        return false;
    }
    public int countNode(TreeNode root, int x){
        if(root==null) return 0;
        int total=0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            TreeNode curr = q.poll();
            if(curr.val==x) p1 = curr;
            total++;
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
        }
        return total;
    }
}