class Tuple { 
    int first, second, third; 
    Tuple(int _first, int _second, int _third) {
        this.first = _first; 
        this.second = _second; 
        this.third = _third; 
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] effort = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                effort[i][j] = (int)1e9;
            }
        }

        int dr[] = {-1, 0, 1, 0}; 
        int dc[] = {0, 1, 0, -1}; 

        PriorityQueue<Tuple> q = new PriorityQueue<>((Tuple t1, Tuple t2) -> t1.first-t2.first);  
        q.add(new Tuple(0, 0, 0));
        effort[0][0]=0;

        while(!q.isEmpty()){
            Tuple it = q.peek(); 
            q.remove(); 
            int eff = it.first; 
            int r = it.second; 
            int c = it.third; 
            if(r==n-1 && c == m-1) return eff;
            for(int i = 0;i<4;i++) {
                int newr = r + dr[i]; 
                int newc = c + dc[i]; 
                
                if(newr >= 0 && newr < n && newc >= 0 && newc < m 
                && Math.max(eff, Math.abs(heights[r][c]-heights[newr][newc])) < effort[newr][newc]) {
                    effort[newr][newc] = Math.max(eff, Math.abs(heights[r][c]-heights[newr][newc])); 
                    q.add(new Tuple(effort[newr][newc], newr, newc)); 
                }
            }
        }
        return effort[n-1][m-1];
        
    }
}