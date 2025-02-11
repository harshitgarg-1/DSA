class Solution {
    int timer = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adjLst = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int[] curr = new int[n];
        int[] min = new int[n];
        for(int i=0;i<n;i++){
            adjLst.add(new ArrayList<>());
        }
        for(List<Integer> connection : connections){
            adjLst.get(connection.get(0)).add(connection.get(1));
            adjLst.get(connection.get(1)).add(connection.get(0));
        }
        Arrays.fill(curr, -1);
        dfs(adjLst, ans, curr, min, 0, -1);
        return ans;
    }

    public void dfs(List<List<Integer>> adjLst, List<List<Integer>> ans, int[] curr, int[] min, int node, int par){
        curr[node] = timer;
        min[node] = timer;
        timer++;
        for(int adj : adjLst.get(node)){
            if(adj == par) continue;
            if(curr[adj]==-1){
                dfs(adjLst, ans, curr, min, adj, node);
            }
            min[node] = Math.min(min[node], min[adj]);
            if(curr[node]<min[adj]){
                ans.add(List.of(node, adj));
            }
        }
    }
}