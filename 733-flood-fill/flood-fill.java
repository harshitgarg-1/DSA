class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new LinkedList<>();
        int m = image.length, n = image[0].length;
        if(sr>=m || sr<0 || sc<0 || sr>=n) return image;
        int[][] vis = new int[m][n];
        q.add(new int[]{sr, sc});
        int srcColor = image[sr][sc];
        image[sr][sc] = color;
        vis[sr][sc] = 1;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int i=0;i<4;i++){
                int x = curr[0] + dx[i];
                int y = curr[1] + dy[i];
                if(x<0 || x>=m || y<0 || y>=n || vis[x][y]==1 || image[x][y]!=srcColor) continue;
                vis[x][y] = 1;
                image[x][y] = color;
                q.add(new int[]{x,y});
            }
        }
        return image;
    }
}