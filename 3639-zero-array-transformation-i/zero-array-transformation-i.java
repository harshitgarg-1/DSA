class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] arr = new int[n+1];
        for(int[] query : queries){
            arr[query[0]]++;
            arr[query[1]+1]--;
        }
        int curr = 0;
        for(int i=0;i<n;i++){
            curr += arr[i];
            if(nums[i]!=0 && nums[i]>curr) return false;
        }
        return true;
    }
}