class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[2];
        for(int i=n-1;i>=0;i--){
            int[] temp = new int[2];
            temp[0] = Math.max(dp[1]-prices[i], dp[0]);
            temp[1] = Math.max(dp[0]+prices[i], dp[1]);
            dp = temp;
        }
        return dp[0];
    }
}