/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> arr = new ArrayList<>();
            for(int i=0;i<n;i++){
                Node curr = q.poll();
                arr.add(curr.val);
                for(Node child : curr.children){
                    q.add(child);
                }
            }
            ans.add(arr);
        }
        return ans;
    }
}