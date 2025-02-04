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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        root = root.left;
        while(!st.isEmpty()){
            if(root != null){
                st.add(root);
                root = root.left;
            } else if(st.peek().right != null){
                root = st.peek().right;
            } else {
                TreeNode curr = null;
                while(!st.isEmpty() && st.peek().right == curr){
                    curr = st.pop();
                    ans.add(curr.val);
                }
            }
        }
        return ans;
    }

    public void traverse(TreeNode root, List<Integer> ans){
        if(root == null) return;
        traverse(root.left, ans);
        traverse(root.right, ans);
        ans.add(root.val);
    }
}