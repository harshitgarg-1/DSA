class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x : nums) sum+=x;
        if(sum%2!=0) return false;
        return isSubsetSum(nums, sum/2);
    }

    public Boolean isSubsetSum(int arr[], int target) {
        int n = arr.length;
        boolean[]dp = new boolean[target+1];
        if(arr[0]<=target){
            dp[arr[0]] = true;
        }
        dp[0] = true;
        for(int i=1;i<n;i++){
            boolean[] temp = new boolean[target+1];
            temp[0] = true;
            for(int j=1;j<=target;j++){
                boolean possible = dp[j];
                if(j-arr[i]>=0){
                    possible = possible || dp[j-arr[i]];
                }
                temp[j] = possible;
            }
            dp = temp;
        }
        return dp[target];
    }
}