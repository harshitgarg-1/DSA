class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length, i=0,j=1, diff=0, ans=0;
        while(j<n){
            if(i+1==j){
                diff = nums[j]-nums[i];
                j++;
            } else {
                if(nums[j]-nums[j-1] != diff){
                    i = j-1;
                } else {
                    ans += Math.max(0, j-i-1);
                    j++;
                }
            }
        }
        return ans;
    }
}