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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return helper(root, 0).treeNode;
    }
    public Pair helper(TreeNode root, int depth){
        if(root == null) return new Pair(0, null);
        Pair left = helper(root.left, depth+1);
        Pair right = helper(root.right, depth+1);
        if(left.treeNode == null && right.treeNode == null) return new Pair(depth, root);
        if(right.depth > left.depth) return right;
        if(left.depth > right.depth) return left;
        return new Pair(left.depth, root);

    }
}

class Pair {
    int depth;
    TreeNode treeNode;
    Pair(int d, TreeNode t) {
        depth = d;
        treeNode = t;
    }
}