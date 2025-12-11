class Solution {
    public int rob(int[] nums) {
        int prev = nums[0], prev2 = 0, n = nums.length;
        for(int i=1;i<n;i++){
            int max = Integer.MIN_VALUE;
            max = Math.max(max, nums[i]+prev2);
            max = Math.max(max, prev);
            prev2 = prev;
            prev = max;
        }
        return prev;

    }
}