class Solution {
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> arr = new ArrayList<>();
        Arrays.sort(cuts);
        arr.add(0);
        for(int i=0;i<cuts.length;i++){
            arr.add(cuts[i]);
        }
        arr.add(n);
        int m = arr.size();
        int[][] dp = new int[m][m];
        for(int i = m-2;i>0;i--){
            for(int j=i;j<m-1;j++){
                int min = Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    min = Math.min(min, arr.get(j+1)-arr.get(i-1)+dp[i][k-1]+dp[k+1][j]);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][m-2];
    }
}