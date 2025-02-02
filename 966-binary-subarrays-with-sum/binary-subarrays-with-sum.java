class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarrays(nums, goal) - numSubarrays(nums, goal-1);
    }
    public int numSubarrays(int[] nums, int goal) {
        int ans = 0, l = 0, sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            while(sum>goal && l<i){
                sum -= nums[l];
                l++;
            }
            if(sum<=goal) ans += (i-l+1);
        }
        return ans;
    }
}