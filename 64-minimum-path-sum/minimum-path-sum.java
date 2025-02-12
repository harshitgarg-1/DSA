class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = grid[0][0];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1 && j==1) continue;
                dp[j] = Math.min(dp[j],dp[j-1])+grid[i-1][j-1];
            }
        }
        return dp[n];
    }
}