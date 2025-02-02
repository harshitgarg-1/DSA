class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0, zero=0, l=-1;
        for(int i=0;i<nums.length;i++){
            zero += 1-nums[i];
            if(zero > k){
                l++;
                zero -= 1-nums[l];
            }
            if(zero<=k) ans = Math.max(ans, i-l);
        }
        return ans;
    }
}