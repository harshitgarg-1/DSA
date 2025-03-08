class Solution {
    public int numSquares(int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return findMin(n, dp);
    }

    public int findMin(int target, int[] dp){
        if(target==0) return 0;
        if(dp[target]!=-1) return dp[target];
        int ans = Integer.MAX_VALUE;
        for(int i=1;i*i<=target;i++){
            ans = Math.min(ans, 1+findMin(target-i*i, dp));
        }
        return dp[target]=ans;
    }
}