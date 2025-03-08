class Solution {
    public int numSquares(int n) {
        List<Integer> ps = new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            ps.add(i*i);
        }
        int m = ps.size();
        int[][] dp = new int[m][n+1];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
        return findMin(m-1, n, dp, ps);
    }

    public int findMin(int i, int target, int[][] dp, List<Integer> ps){
        if(i==0){
            return target;
        }
        if(target==0) return 0;
        if(dp[i][target]!=-1) return dp[i][target];
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, findMin(i-1, target, dp, ps));
        if(ps.get(i)<=target){
            ans = Math.min(ans, 1+findMin(i, target-ps.get(i), dp, ps));
        }
        return dp[i][target] = ans;
    }
}