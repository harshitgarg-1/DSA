class Solution {
    public int numberOfSubarrays(int[] nums, int goal) {
        return numSubarrays(nums, goal) - numSubarrays(nums, goal-1);
    }
    public int numSubarrays(int[] nums, int goal) {
        int ans = 0, l = 0, count = 0;
        for(int i=0;i<nums.length;i++){
            count += nums[i]%2;
            while(count>goal && l<i){
                count -= nums[l]%2;
                l++;
            }
            if(count<=goal) ans += (i-l+1);
        }
        return ans;
    }
}