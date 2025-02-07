class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] degree = new int[n];
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjRev.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            degree[i] = graph[i].length;
            if(degree[i]==0) q.add(i);
            for (int j=0;j<graph[i].length;j++) {
                adjRev.get(graph[i][j]).add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            ans.add(node);
            for (int it : adjRev.get(node)) {
                degree[it]--;
                if (degree[it] == 0) q.add(it);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}