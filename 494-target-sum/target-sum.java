class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int x : nums) sum+=x;
        if((sum+target)%2==1 || sum+target<0) return 0;
        return perfectSum(nums,(sum+target)/2);
    }

    public int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        int[] dp = new int[target+1];
        if(nums[0]==0){
            dp[0] = 2;
        } else {
            dp[0] = 1;
            if(nums[0]<=target) dp[nums[0]] = 1;
        }
        for(int i=1;i<n;i++){
            int[] temp = new int[target+1];
            for(int j=0;j<=target;j++){
                int count = dp[j];
                if(nums[i]<=j){
                    count+=dp[j-nums[i]];
                }
                temp[j] = count;
            }
            dp = temp;
        }
        return dp[target];
    }
}