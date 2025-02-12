class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(obstacleGrid[i-1][j-1]==1){
                    dp[j] = 0;
                    continue;
                }
                dp[j] = dp[j] + dp[j-1];
            }
            
        }
        return dp[n];
    }
}