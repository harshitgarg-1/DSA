class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<TreeSet<Integer>> preAns = new ArrayList<>();
        for(int i=0;i<n;i++){
            preAns.add(new TreeSet<>());
        }
        List<Integer>[] adjacencyList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        int[] degrees = new int[n];
        for(int[] edge : edges){
            int i = edge[0];
            int j = edge[1];
            degrees[j]++;
            preAns.get(j).add(i);
            adjacencyList[i].add(j);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degrees[i]==0) q.add(i);
        }
        while(q.size()>0){
            int curr = q.poll();
            Set<Integer> set = new TreeSet<>();
            for(int prev : preAns.get(curr)){
                set.addAll(preAns.get(prev));
            }
            preAns.get(curr).addAll(set);
            for(int neb : adjacencyList[curr]){
                degrees[neb]--;
                if(degrees[neb]==0) q.add(neb);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(new ArrayList<>(preAns.get(i)));
        }
        return ans;
    }
}