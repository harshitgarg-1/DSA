class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair p1, Pair p2) -> p2.no-p1.no);
        for(int i=0;i<n;i++){
            Arrays.sort(grid[i]);
            if(limits[i]>0){
                limits[i]--;
                pq.add(new Pair(grid[i][m-1], i, m-1));
            }
        }
        long ans = 0;
        while(k>0 && !pq.isEmpty()){
            Pair p = pq.poll();
            ans += p.no;
            if(limits[p.i]>0){
                limits[p.i]--;
                pq.add(new Pair(grid[p.i][p.j-1], p.i, p.j-1));
            }
            k--;
        }
        return ans;
    }
}

class Pair {
    int no;
    int i;
    int j;
    Pair(int n, int i, int j){
        no = n;
        this.i = i;
        this.j = j;
    }
}