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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || root != null){
            if(root != null){
                st.add(root);
                root = root.left;
            } else {
                TreeNode curr = st.pop();
                ans.add(curr.val);
                root = curr.right;
            }
        }
        return ans;
    }

    public void traverse(TreeNode root, List<Integer> ans){
        if(root == null) return;
        traverse(root.left, ans);
        ans.add(root.val);
        traverse(root.right, ans);
    }
}