class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n-1] = nums[n-1];
        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1], nums[i]);
            right[n-i-1] = Math.max(right[n-i], nums[n-i-1]);
        }
        long ans = 0;
        for(int i=1;i<n-1;i++){
            ans = Math.max(1l*(left[i-1]-nums[i])*right[i+1], ans);
        }
        return ans;
    }
}