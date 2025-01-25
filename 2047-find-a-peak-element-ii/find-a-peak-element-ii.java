class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0, high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            int max = Integer.MIN_VALUE;
            int col = -1;
            for(int i=0;i<m;i++){
                if(mat[mid][i]>max){
                    max = mat[mid][i];
                    col = i;
                }
            }
            if(mid>0 && mat[mid-1][col]>mat[mid][col]){
                high = mid-1;
            }
            else if(mid<n-1 && mat[mid+1][col]>mat[mid][col]){
                low = mid+1;
            }
            else {
                return new int[]{mid, col};
            }
        }
        return new int[]{-1, -1};
        
    }
}