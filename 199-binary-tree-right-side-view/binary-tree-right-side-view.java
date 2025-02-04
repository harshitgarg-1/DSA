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
    public void fxn(TreeNode root, List<Integer> ls, int cd){
        if(root==null) return;
        if(cd==ls.size()) ls.add(root.val);
        fxn(root.right, ls, cd+1);
        fxn(root.left, ls, cd+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        fxn(root, ls, 0);
        return ls;
        
        
    }
}