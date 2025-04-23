class Solution {
    public int minMaxWeight(int n, int[][] edges, int threshold) {        
        List<List<Integer>> rev = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            rev.add(new ArrayList<>());
        }
        
        Set<Integer> weightSet = new HashSet<>();
        for(int[] e : edges) {
            int u = e[0], v = e[1];
            int w = e[2];
            rev.get(v).add(u);
            weightSet.add(w);
        }
        
        if(!canVisitAll(n, rev)) {
            return -1;
        }
        
        List<Integer> weights = new ArrayList<>(weightSet);
        Collections.sort(weights);
        
        int left = 0;
        int right = weights.size() - 1;
        int ans = -1;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            int W = weights.get(mid);
            
            List<List<Integer>> temp = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                temp.add(new ArrayList<>());
            }
            for (int[] e : edges) {
                int u = e[0], v = e[1], w = e[2];
                if (w <= W) {
                    temp.get(v).add(u);
                }
            }
            
            if(canVisitAll(n, temp)) {
                ans = W;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return ans;
    }
    
    public boolean canVisitAll(int n, List<List<Integer>> revGraph) {
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int count = 1;
        
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int nxt : revGraph.get(cur)) {
                if(!visited[nxt]) {
                    visited[nxt] = true;
                    count++;
                    queue.offer(nxt);
                }
            }
        }
        
        return count == n;
    }
}