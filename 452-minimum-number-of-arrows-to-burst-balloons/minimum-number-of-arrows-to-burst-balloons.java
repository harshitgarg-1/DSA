class Solution {
    public int findMinArrowShots(int[][] points) {
        int ans =1;
        Arrays.sort(points, (int[] a, int[] b) -> Integer.compare(a[0],b[0]));
        int prev = points[0][1];
        for(int i=1;i<points.length;i++){
            if(prev < points[i][0]){
                ans++;
                prev = points[i][1];
            } else {
                prev = Math.min(prev, points[i][1]);
            }
        }
        return ans;
    }
}