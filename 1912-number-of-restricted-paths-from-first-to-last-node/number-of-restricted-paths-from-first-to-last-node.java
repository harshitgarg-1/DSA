class Solution {

    public int dfs(ArrayList<ArrayList<int[]>> adj, int[] dist, int idx, int[] dp){
        if(idx == 1)
            return 1;
        if(dp[idx] != -1)return dp[idx];
        int count = 0;
        
        for(int[] x : adj.get(idx)){
            if(dist[x[1]] > dist[idx])
                count = (count + dfs(adj, dist, x[1], dp)) % 1000000007;
        }

        return dp[idx] = count;
    }

    public int countRestrictedPaths(int n, int[][] edges) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<>());
        
        for(int x[] : edges){
            adj.get(x[0]).add(new int[]{x[2], x[1]});
            adj.get(x[1]).add(new int[]{x[2], x[0]});
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->(a[0]-b[0]));
        q.add(new int[]{0, n});
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;

        while(!q.isEmpty()){
            int node = q.peek()[1];
            int currDist = q.poll()[0];
            if (currDist > dist[node]) continue; 
            for(int[] x: adj.get(node)){
                int nextDist = currDist+x[0];
                if(nextDist < dist[x[1]]){
                    dist[x[1]] = nextDist;
                    q.add(new int[]{dist[x[1]], x[1]});
                }
            }
        }
        // System.out.println(Arrays.toString(dist));

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int res = dfs(adj, dist, n, dp);
        return res;
    }
}