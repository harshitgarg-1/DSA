class Solution {
    public int minCost(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        return minCost(nums, 0, 1, dp);
    }
    public int minCost(int[] nums, int last, int curr, int[][] dp){
        if(curr>=nums.length) return nums[last];
        if(curr==nums.length-1) return Math.max(nums[last], nums[curr]);
        if(dp[last][curr] != -1) return dp[last][curr];
        int r1 = Math.max(nums[last], nums[curr]) + minCost(nums, curr+1, curr+2, dp);
        int r2 = Math.max(nums[last], nums[curr+1]) + minCost(nums, curr, curr+2, dp);
        int r3 = Math.max(nums[curr+1], nums[curr]) + minCost(nums, last, curr+2, dp);
        return dp[last][curr] = Math.min(r1, Math.min(r2, r3));

    }
}