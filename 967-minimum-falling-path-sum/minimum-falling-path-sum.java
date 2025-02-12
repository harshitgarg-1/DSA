class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = matrix[0][i];
        }
        for(int i=1;i<n;i++){
            int[] temp = new int[n];
            for(int j=0;j<n;j++){
                int min = dp[j];
                if(j>0) min = Math.min(dp[j-1], min);
                if(j<n-1) min = Math.min(dp[j+1], min);
                temp[j] = min+matrix[i][j];
            }
            dp = temp;
        }
        int min = dp[0];
        for(int i=0;i<n;i++){
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}