class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;
        int n = grid.length;
        if(grid[n-1][n-1]==1) return -1;
        if(n==1) return 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        int ans = 1;
        while(q.size()>0){
            int m = q.size();
            ans++;
            while(m>0){
                int[] curr = q.poll();
                for(int i=-1;i<=1;i++){
                    for(int j=-1;j<=1;j++){
                        int x = curr[0]+i;
                        int y = curr[1]+j;
                        if(x<0 || x>=n || y<0 || y>=n || grid[x][y]==1) continue;
                        if(x==n-1 && y==n-1) return ans;
                        grid[x][y]=1;
                        q.add(new int[]{x, y});
                    }
                }
                m--;
            }
        }
        return -1;
    }
}