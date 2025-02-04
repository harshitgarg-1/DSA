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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        HashMap<Integer, HashMap<Integer, List<Integer>>> hm = new HashMap<>();
        int min = 0, lev = 0;
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            int n = q.size();
            while(n>0){
                Pair p = q.poll();
                if(hm.get(p.no)==null){
                    hm.put(p.no, new HashMap<>());
                }
                if(hm.get(p.no).get(lev)==null){
                    hm.get(p.no).put(lev, new ArrayList<>());
                }
                hm.get(p.no).get(lev).add(p.node.val);
                min = Math.min(min, p.no);
                if(p.node.left != null) q.add(new Pair(p.node.left, p.no-1));
                if(p.node.right != null) q.add(new Pair(p.node.right, p.no+1));
                n--;
            }
            lev++;
        }

        while(hm.get(min)!= null){
            List<Integer> curr = new ArrayList();
            for(int i=0;i<lev;i++){
                if(hm.get(min).get(i) != null){
                    Collections.sort(hm.get(min).get(i));
                    curr.addAll(hm.get(min).get(i));
                }
            }
            ans.add(curr);
            min++;
        }
        return ans;
    }
}

class Pair {
    TreeNode node;
    int no;
    Pair(TreeNode n, int i){
        node = n;
        no = i;
    }
}