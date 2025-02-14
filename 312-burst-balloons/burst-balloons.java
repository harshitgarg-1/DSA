class Solution {
    public int maxCoins(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        for(int i=0;i<nums.length;i++){
            arr.add(nums[i]);
        }
        arr.add(1);
        int m = arr.size();
        int[][] dp = new int[m][m];
        for(int i = m-2;i>0;i--){
            for(int j=i;j<m-1;j++){
                int max = Integer.MIN_VALUE;
                for(int k=i;k<=j;k++){
                    max = Math.max(max, arr.get(j+1)*arr.get(i-1)*arr.get(k)+dp[i][k-1]+dp[k+1][j]);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][m-2];
    }
}