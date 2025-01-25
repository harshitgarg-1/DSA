class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int r = n-1, c = 0;
        while(r>=0 && c<m){
            if(matrix[r][c]==target) return true;
            else if(matrix[r][c]>target) r--;
            else c++;
        }
        return false;       
    }
}