class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> temp = new ArrayList<>();
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0]-b[0]);
        temp.add(intervals[0]);
        for(int i=1;i<intervals.length;i++) {
            if(temp.get(temp.size()-1)[1]>=intervals[i][0]){
                temp.get(temp.size()-1)[1] = Math.max(intervals[i][1], temp.get(temp.size()-1)[1]);
            } else {
                temp.add(intervals[i]);
            }
        }
        int[][] ans = new int[temp.size()][2];
        for(int i=0;i<temp.size();i++){
            ans[i] = temp.get(i);
        }
        return ans;
    }
}