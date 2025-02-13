class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int n = coins.length;
        int[] dp = new int[amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0) dp[i] = i/coins[0];
            else dp[i] = (int) Math.pow(10, 9);
        }
        for(int i=1;i<n;i++){
            int[] temp = new int[amount+1];
            for(int j=0;j<=amount;j++){
                int notTaken = dp[j];
                int taken = Integer.MAX_VALUE;
                if(coins[i]<=j){
                    taken = temp[j-coins[i]]+1;
                }
                temp[j] = Math.min(notTaken, taken);
            }
            dp = temp;
        }
        return dp[amount]==(int) Math.pow(10, 9)?-1:dp[amount];
    }
}