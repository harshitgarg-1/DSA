class Solution {
    class Pair{
        int i;
        int j;
        Pair(int x, int y){
            i=x;
            j=y;
        }
    }
    public void island(char[][] grid, int i, int j){
        Queue<Pair> st = new LinkedList<>();
        grid[i][j]='0';
        st.add(new Pair(i, j));
        while(!st.isEmpty()){
            Pair p = st.poll();
            int x = p.i;
            int y = p.j;
            if(y+1 < grid[0].length && grid[x][y+1]=='1'){
                grid[x][y+1]='0';
                st.add(new Pair(x, y+1));
            }
            if(y-1 >= 0 && grid[x][y-1]=='1'){
                grid[x][y-1]='0';
                st.add(new Pair(x, y-1));
            }
            if(x+1 <grid.length && grid[x+1][y]=='1'){
                grid[x+1][y]='0';
                st.add(new Pair(x+1, y));
            }
            if(x-1 >=0 && grid[x-1][y]=='1'){
                grid[x-1][y]='0';
                st.add(new Pair(x-1, y));
            }
        }
    }
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    island(grid, i, j);
                }
            }
        }
        return ans;
    }
}