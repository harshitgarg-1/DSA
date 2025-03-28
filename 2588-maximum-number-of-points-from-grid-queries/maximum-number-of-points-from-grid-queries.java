class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        ArrayList<int[]> queriesSort = new ArrayList<>();
        int n = queries.length;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            queriesSort.add(new int[]{queries[i],i});
        }
        int x = grid.length;
        int y = grid[0].length;
        int[][] vis = new int[x][y];
        Collections.sort(queriesSort, (int[] a, int[] b) -> a[0]-b[0]);
        ArrayList<int[]> nextPositions = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        nextPositions.add(new int[]{0,0});
        vis[0][0] = 1;
        int prev = 0;
        for(int i=0;i<n;i++){
            int query = queriesSort.get(i)[0];
            int j=0;
            while(j<nextPositions.size()){
                int[] curr = nextPositions.get(j);
                if(grid[curr[0]][curr[1]]<query){
                    q.add(curr);
                    nextPositions.remove(j);
                } else {
                    j++;
                }
            }
            int currCount = 0;
            while(!q.isEmpty()){
                int[] curr = q.poll();
                int a = curr[0];
                int b = curr[1];
                currCount++;
                if(a>0 && vis[a-1][b]!=1){
                    if(grid[a-1][b]<query){
                        q.add(new int[]{a-1,b});
                    } else {
                        nextPositions.add(new int[]{a-1,b});
                    }
                    vis[a-1][b]=1;
                }
                if(a<x-1 && vis[a+1][b]!=1){
                    if(grid[a+1][b]<query){
                        q.add(new int[]{a+1,b});
                    } else {
                        nextPositions.add(new int[]{a+1,b});
                    }
                    vis[a+1][b]=1;
                }
                if(b>0 && vis[a][b-1]!=1){
                    if(grid[a][b-1]<query){
                        q.add(new int[]{a,b-1});
                    } else {
                        nextPositions.add(new int[]{a,b-1});
                    }
                    vis[a][b-1]=1;
                }
                if(b<y-1 && vis[a][b+1]!=1){
                    if(grid[a][b+1]<query){
                        q.add(new int[]{a,b+1});
                    } else {
                        nextPositions.add(new int[]{a,b+1});
                    }
                    vis[a][b+1]=1;
                }
            }
            ans[queriesSort.get(i)[1]] = currCount+prev;
            prev = currCount+prev;

        }
        return ans;
    }
}