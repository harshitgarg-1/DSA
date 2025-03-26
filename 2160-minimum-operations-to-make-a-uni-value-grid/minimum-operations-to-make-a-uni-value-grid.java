class Solution {
    public int minOperations(int[][] grid, int x) {
    final int m = grid.length;
    final int n = grid[0].length;
        int ans=0;
    int[] A = new int[m * n];
    for (int i = 0; i < m; ++i)
      for (int j = 0; j < n; ++j)
        A[i * n + j] = grid[i][j];
     Arrays.sort(A);

    for (final int a : A){
        if(Math.abs(a - A[A.length / 2]) % x !=0 ) return -1;
      ans += Math.abs(a - A[A.length / 2]) / x;   
    } 
        return ans;
    }
}