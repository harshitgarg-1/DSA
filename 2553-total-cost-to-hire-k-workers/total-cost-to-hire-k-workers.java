class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int n = costs.length;
        int i=0, j=n-1;
        long ans = 0;
        for(int x=0;x<candidates;x++){
            if(i>j) break;
            pq.add(new int[]{costs[i],i});
            if(j!=i)pq.add(new int[]{costs[j],j});
            i++;
            j--;
        }
        while(k>0){
            int[] min = pq.poll();
            ans += min[0];
            if(i<=j){
                if(min[1]<i) {
                    pq.add(new int[]{costs[i],i});
                    i++;
                } else {
                    pq.add(new int[]{costs[j],j});
                    j--;
                }
            }
            k--;
        }
        return ans;
    }
}