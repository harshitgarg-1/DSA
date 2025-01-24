class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        // dp[i][j] represents the minimum largest sum when splitting first i elements into j subarrays
        int[][] dp = new int[n + 1][k + 1];
        
        // Prefix sum array to quickly compute sum(p+1, i)
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        // Initialize dp table with high values
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // Base case: dp[i][1] is the sum of the first i elements
        for (int i = 1; i <= n; i++) {
            dp[i][1] = prefixSum[i];  // Sum from 0 to i-1
        }

        // Fill dp table
        for (int j = 2; j <= k; j++) {  // For each number of subarrays from 2 to k
            for (int i = j; i <= n; i++) {  // For each number of elements from j to n
                for (int p = j - 1; p < i; p++) {  // Split at each position p
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[p][j - 1], prefixSum[i] - prefixSum[p]));
                }
            }
        }

        return dp[n][k];
    }
}