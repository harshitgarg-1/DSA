class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i=0, j=0, k=n-1;
        while(j<=k){
            if(nums[j]==1)j++;
            else if(nums[j]==0){
                nums[j] = 1;
                nums[i] = 0;
                i++;
                j++;
            }
            else{
                nums[j] = nums[k];
                nums[k]=2;
                k--;
            }
        }
    }
}