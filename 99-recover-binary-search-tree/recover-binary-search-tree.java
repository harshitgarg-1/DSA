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
    public void recoverTree(TreeNode root) {
        TreeNode x = null, y = null, prev = null;
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || root != null){
            if(root != null){
                st.push(root);
                root = root.left;
            } else {
                TreeNode curr = st.pop();
                if(prev != null && prev.val>curr.val){
                    if(x == null){
                        x = prev;
                    }
                    y = curr;
                }
                prev = curr;
                root = curr.right;
            }
        }

        if(x != null && y != null){
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }
}