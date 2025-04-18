class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[n];
        int[] degree = new int[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] relation : relations) {
            graph[relation[0]-1].add(relation[1]-1);
            degree[relation[1]-1]++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> a[0]-b[0]);
        for(int i=0;i<n;i++){
            if(degree[i]==0){
                pq.add(new int[]{time[i], i});
            }
        }
        int ans = 0;
        while(pq.size()>0){
            int[] curr = pq.poll();
            ans = curr[0];
            for(int neb : graph[curr[1]]){
                degree[neb]--;
                if(degree[neb]==0){
                    pq.add(new int[]{time[neb]+curr[0], neb});
                }
            }
        }
        return ans;
    }
}