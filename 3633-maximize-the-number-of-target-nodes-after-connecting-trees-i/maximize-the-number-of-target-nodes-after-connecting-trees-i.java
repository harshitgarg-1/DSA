import java.util.*;

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        if (k == 0) {
            int[] result = new int[edges1.length + 1];
            Arrays.fill(result, 1);
            return result;
        }

        // Create adjacency lists
        List<List<Integer>> adj1 = new ArrayList<>(edges1.length + 1);
        List<List<Integer>> adj2 = new ArrayList<>(edges2.length + 1);

        // Initialize adjacency lists
        for (int i = 0; i <= edges1.length; i++) {
            adj1.add(new ArrayList<>());
        }
        for (int i = 0; i <= edges2.length; i++) {
            adj2.add(new ArrayList<>());
        }

        // Populate adjacency list for first graph
        for (int[] edge : edges1) {
            int u = edge[0], v = edge[1];
            adj1.get(u).add(v);
            adj1.get(v).add(u);
        }

        // Populate adjacency list for second graph
        for (int[] edge : edges2) {
            int u = edge[0], v = edge[1];
            adj2.get(u).add(v);
            adj2.get(v).add(u);
        }

        // Calculate target nodes for first graph
        int[] ans1 = new int[edges1.length + 1];
        for (int i = 0; i < adj1.size(); i++) {
            ans1[i] = bfs(adj1, i, k);
        }

        // Calculate target nodes for second graph
        int[] ans2 = new int[edges2.length + 1];
        for (int i = 0; i < adj2.size(); i++) {
            ans2[i] = bfs(adj2, i, k - 1);
        }

        // Find maximum value in ans2
        int maxi = Arrays.stream(ans2).max().orElse(0);

        // Combine results
        for (int i = 0; i < ans1.length; i++) {
            ans1[i] += maxi;
        }

        return ans1;
    }

    private int bfs(List<List<Integer>> adj, int start, int maxDepth) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        q.offer(start);
        visited[start] = true;

        int depth = 1;
        while (!q.isEmpty() && depth <= maxDepth) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int current = q.poll();
                for (int neighbor : adj.get(current)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        q.offer(neighbor);
                    }
                }
            }
            depth++;
        }

        // Count visited nodes
        int visitedCount = 0;
        for (boolean v : visited) {
            if (v) visitedCount++;
        }
        return visitedCount;
    }
}