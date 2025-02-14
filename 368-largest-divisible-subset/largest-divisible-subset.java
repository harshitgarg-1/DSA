class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] par = new int[n];
        int[] dp = new int[n];
        int max = 1, index = 0;
        for(int i=0;i<n;i++){
            par[i] = i;
            dp[i] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                    par[i] = j;
                }
                if(max < dp[i]){
                    max = dp[i];
                    index = i;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(par[index]!=index){
            ans.add(0, nums[index]);
            index = par[index];
        }
        ans.add(0, nums[index]);
        return ans;
    }
}