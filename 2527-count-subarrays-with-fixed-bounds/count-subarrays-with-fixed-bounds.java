class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int start = 0, min = -1, max = -1;
        for(int end = 0; end<nums.length;end++){
            int x = nums[end];
            if(x>maxK || x<minK){
                min = -1;
                max = -1;
                start = end+1;
                continue;
            }
            if(x==minK) min = Math.max(min, end);
            if(x==maxK) max = Math.max(max, end);
            if(min != -1 && max != -1){
                ans += Math.min(min, max) - start+1;
            }
        }
        return ans;
    }
}