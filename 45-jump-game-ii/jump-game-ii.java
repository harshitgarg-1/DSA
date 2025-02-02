class Solution {
    public int jump(int[] nums) {
        if(nums.length<=1) return 0;
        int ans = 1, curr = nums[0], max = 0;
        for(int i=1;i<nums.length-1;i++){
            curr--;
            max--;
            max = Math.max(nums[i], max);
            if(curr==0){
                curr = max;
                max = 0;
                ans++;
            }
        }
        return ans;

    }
}