class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int x = 0, n = intervals.length;
		ArrayList<int[]> arr = new ArrayList<>();
		for(int i=0;i<n;i++){
			if(newInterval == null || intervals[i][1]<newInterval[0]) arr.add(intervals[i]);
			else if( newInterval[1]<intervals[i][0]){
				arr.add(newInterval);
                arr.add(intervals[i]);
				newInterval = null;
			}
			else{
				newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
				newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
			}
		}
		if(newInterval != null) arr.add(newInterval);
		int[][] ans = new int[arr.size()][2];
		int j = 0;
		for(int[] a : arr){
			ans[j] = a;
			j++;
		}
		return ans;
    }
}