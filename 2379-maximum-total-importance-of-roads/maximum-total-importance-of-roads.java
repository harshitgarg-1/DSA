class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] indegree = new int[n];
        for(int[] road : roads){
            indegree[road[0]]++;
            indegree[road[1]]++;
        }
        Arrays.sort(indegree);
        long ans = 0;
        for(int i=0;i<n;i++){
            ans += 1l*(i+1)*indegree[i];
        }
        return ans;
    }
}