class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        int[][] vis = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            if(board[i][0]== 'O'){
                board[i][0] = 'p';
                vis[i][0] = 1;
                q.add(new int[]{i, 0});
            }
            if(board[i][n-1]== 'O'){
                board[i][n-1] = 'p';
                vis[i][n-1] = 1;
                q.add(new int[]{i, n-1});
            }
        }
        for(int i=0;i<n;i++){
            if(board[0][i]== 'O'){
                board[0][i] = 'p';
                vis[0][i] = 1;
                q.add(new int[]{0, i});
            }
            if(board[m-1][i]== 'O'){
                board[m-1][i] = 'p';
                vis[m-1][i] = 1;
                q.add(new int[]{m-1, i});
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int i=0;i<4;i++){
                int x = curr[0]+dx[i];
                int y = curr[1]+dy[i];
                if(x<0 || x>=m || y<0 || y>=n || vis[x][y]==1 || board[x][y]!='O'){
                    continue;
                }
                board[x][y] = 'p';
                vis[x][y] = 1;
                q.add(new int[]{x,y});
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='p') board[i][j] = 'O';
                else if(board[i][j]=='O') board[i][j] = 'X';
            }
        }
    }
}