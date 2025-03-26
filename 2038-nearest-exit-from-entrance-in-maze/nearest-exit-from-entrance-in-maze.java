class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {

        int m = maze.length;
        int n = maze[0].length;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {entrance[0], entrance[1]});
        maze[entrance[0]][entrance[1]] = '+';
        int dist = 0;
        while(! queue.isEmpty()) {
            dist++;
            int n1 = queue.size();
            for(int j=0;j<n1;j++){
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                for(int i = 0; i < 4; i++) {
                    int x = r + dx[i];
                    int y = c + dy[i];

                    if(x == -1 || y == -1 || x == m || y == n) continue;
                    if(maze[x][y] == '+') continue;
                    if(x == 0 || y == 0 || x == m - 1 || y == n - 1) return dist;
                    maze[x][y] = '+';
                    queue.add(new int[] {x, y});
                }
            }
        }
        return -1;
    }
}