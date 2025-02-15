class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        ArrayList<int[]> arr = new ArrayList<>();
        int n = queries.length;
        for(int i=0;i<n;i++){
            arr.add(new int[]{i, queries[i][0], queries[i][1]});
        }
        Trie trie = new Trie();
        arr.sort((int[] a, int[] b) -> a[2]-b[2]);
        Arrays.sort(nums);
        int j = 0;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            int[] curr = arr.get(i);
            while(j<nums.length && nums[j]<=curr[2]){
                trie.add(nums[j]);
                j++;
            }
            if(j==0){
                ans[curr[0]] = -1;
                continue;
            }
            ans[curr[0]] = trie.max(curr[1]);
        }
        return ans;
    }
}
class Node {
    Node[] link;
    Node(){
        link = new Node[2];
    }
}

class Trie {
    Node root;
    Trie(){
        root = new Node();
    }
    void add(int no){
        Node curr = root;
        for(int i=31;i>=0;i--){
            int bit = (no>>i)&1;
            if(curr.link[bit]==null){
                curr.link[bit] = new Node();
            }
            curr = curr.link[bit];
        }
    }
    int max(int no){
        Node curr = root;
        int max = 0;
        for(int i=31;i>=0;i--){
            int bit = (no>>i)&1;
            if(curr.link[1-bit]==null){
                curr = curr.link[bit];
                continue;
            }
            max = max | (1<<i);
            curr = curr.link[1-bit];
        }
        return max;
    }
}