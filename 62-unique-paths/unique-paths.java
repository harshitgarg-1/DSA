class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1 && j==1){
                }
                dp[j] = dp[j] + dp[j-1];
            }
            
        }
        return dp[n];
    }
}