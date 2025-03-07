class Pair {
    int value;
    int index;
    Pair(int v, int i){
        value = v;
        index = i;
    }
}
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        ArrayList<Pair> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(new Pair(intervals[i][0], i));
        }
        Collections.sort(arr, (Pair p1, Pair p2) -> p1.value-p2.value);
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = bs(arr, intervals[i][1], n);
        }
        return ans;
    }

    public int bs(ArrayList<Pair> arr, int target, int n){
        int index = -1;
        int i=0, j=n-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(arr.get(mid).value==target) return arr.get(mid).index;
            if(arr.get(mid).value>target){
                index = arr.get(mid).index;
                j = mid-1;
            } else {
                i = mid+1;
            }
        }
        return index;
    }
}