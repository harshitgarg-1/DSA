class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = 0, n = nums.length;
        for(int num : nums){
            max = Math.max(max, num);
        }
        long ans = 0;
        int count = 0, start = 0;
        for(int i=0;i<n;i++){
            if(nums[i]==max) count++;
            while(count>=k){
                ans += n-i;
                if(nums[start]==max) count--;
                start++;
            }
        }
        return ans;
    }
}