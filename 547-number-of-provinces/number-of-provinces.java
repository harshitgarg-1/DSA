class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        int ans = 0;
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                ans++;
                traverse(isConnected, i, visited, n);
            }
        }
        return ans;
    }

    public void traverse(int[][] isConnected, int node, int[] visited, int total){
        visited[node] = 1;
        for(int i=0;i<total;i++){
            if(isConnected[node][i]==1 && visited[i]!=1){
                traverse(isConnected, i, visited, total);
            }
        }
    }
}