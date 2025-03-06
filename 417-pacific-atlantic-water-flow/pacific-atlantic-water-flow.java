class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] arr = new int[m][n];
        int[][] arr1 = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr[0][i] = 1;
            q.add(new int[]{0, i});
        }
        for(int i=0;i<m;i++){
            arr[i][0] = 1;
            q.add(new int[]{i, 0});
        }
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, -1, 0, 1};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int i=0;i<4;i++){
                int nx = curr[0]+x[i];
                int ny = curr[1]+y[i];
                if(nx>=0 && nx<m && ny>=0 && ny<n && arr[nx][ny]<=0 && heights[curr[0]][curr[1]]<=heights[nx][ny]){
                    arr[nx][ny] +=1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        for(int i=0;i<n-1;i++){
            arr1[m-1][i] +=1;
            q.add(new int[]{m-1, i});
        }
        for(int i=0;i<m;i++){
            arr1[i][n-1] +=1;
            q.add(new int[]{i, n-1});
        }
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int i=0;i<4;i++){
                int nx = curr[0]+x[i];
                int ny = curr[1]+y[i];
                if(nx>=0 && nx<m && ny>=0 && ny<n && arr1[nx][ny]<=0 && heights[curr[0]][curr[1]]<=heights[nx][ny]){
                    arr1[nx][ny] +=1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1 && arr1[i][j]==1){
                    ans.add(List.of(i, j));
                }
            }
        }
        return ans;
    }
}