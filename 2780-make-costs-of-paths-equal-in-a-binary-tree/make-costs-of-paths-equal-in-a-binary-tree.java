class Solution {
    public int minIncrements(int n, int[] cost) {
        int[] max = new int[n];
        int high = dfs(0, n, max, cost);
        return find(0, n, cost, max, high, 0);
    }
    public int dfs(int i, int n, int[] max, int[] cost){
        if(i>=n) return 0;
        int left = dfs(i*2+1, n, max, cost);
        int right = dfs(i*2+2, n, max, cost);
        max[i] = Math.max(left, right);
        return max[i]+cost[i];
    }
    public int find(int i, int n, int[] cost, int[] max, int high, int sum){
        if(i>=n) return 0;
        int currSum = cost[i] + sum;
        int canAdd = high - max[i] - currSum;
        return high - cost[i] - max[i] - sum + find(2*i+1, n, cost, max, high, currSum+canAdd)
                                               + find(2*i+2, n, cost, max, high, currSum+canAdd);
    }
}