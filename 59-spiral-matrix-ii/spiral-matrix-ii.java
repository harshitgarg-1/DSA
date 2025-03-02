class Solution {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int count = 1;
        int r1 = 0, r2 = n-1, c1 = 0, c2 = n-1;
        while(r1<=r2&& c1<=c2){
            for(int i=c1;i<=c2;i++){
                arr[r1][i] = count;
                count++;
            }
            r1++;
            for(int i=r1;i<=r2;i++){
                arr[i][c2]=count;
                count++;
            }
            c2--;
            if(r1<=r2){
                for(int i=c2;i>=c1;i--){
                    arr[r2][i]=count;
                    count++;
                }
                r2--;
            }
            if(c1<=c2){
                for(int i=r2;i>=r1;i--){
                    arr[i][c1]=count;
                    count++;
                }
                c1++;
            }
        }
        return arr;
    }
}