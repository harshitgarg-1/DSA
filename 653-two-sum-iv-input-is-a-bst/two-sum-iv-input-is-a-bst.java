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
    public boolean findTarget(TreeNode root, int k) {
        IteratorBST left = new IteratorBST(root, false);
        IteratorBST right = new IteratorBST(root, true);
        while(left.hasNext() && right.hasNext()){
            int l = left.peek();
            int r = right.peek();
            if(l>=r) return false;
            if(l+r==k) return true;
            if(l+r<k) left.pop();
            else right.pop();
        }
        return false;
    }
}

class IteratorBST {
    Stack<TreeNode> st;
    boolean reverse;
    IteratorBST(TreeNode node, boolean rev){
        st = new Stack<>();
        reverse = rev;
        push(node);
    }
    void push(TreeNode node){
        while(node != null){
            st.push(node);
            if(reverse) node = node.right;
            else node = node.left;
        }
    }

    boolean hasNext(){
        return !st.isEmpty();
    }

    void pop(){
        if(st.isEmpty()) return;
        TreeNode node = st.pop();
        if(reverse) push(node.left);
        else push(node.right);
    }

    int peek() {
        if(st.isEmpty()) return -1;
        return st.peek().val;
    }
}