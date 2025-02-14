class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[] dp = new int[k*2+1];
        for(int i=n-1;i>=0;i--){
            int[] temp = new int[k*2+1];
            for(int j=k*2-1;j>=0;j--){
                if(j%2==0){
                    temp[j] = Math.max(dp[j+1]-prices[i], dp[j]);
                } else {
                    temp[j] = Math.max(dp[j+1]+prices[i], dp[j]);
                }
            }
            dp = temp;
        }
        return dp[0];
    }
}