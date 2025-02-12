class Solution {
    public int rob(int[] nums) {
        int prev2 = 0;
        int prev1 = nums[0];
        int n = nums.length;
        for(int i=1;i<n;i++){
            int max = nums[i];
            max = Math.max(max, prev2 + nums[i]);
            max = Math.max(max, prev1);
            prev2 = prev1;
            prev1 = max;
        }
        return prev1;
    }
}