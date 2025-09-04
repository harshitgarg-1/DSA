class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> a[1]-b[1]);
        int ans = 0;
        int prev = Integer.MIN_VALUE;
        for(int i=0;i<intervals.length;i++){
            if(prev<=intervals[i][0]){
                prev = intervals[i][1];
            } else {
                ans++;
            }
        }
        return ans;
    }
}