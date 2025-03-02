class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0, j=-1, n = nums.length;
        while(i<n){
            if(j>=1 && nums[i]==nums[j] && nums[i]==nums[j-1]){
                i++;
                continue;
            }
            j++;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
        }
        return j+1;
    }
}