class Solution {
    public int hIndex(int[] citations) {
        int l = 0, r = citations.length-1, ans =0, n = citations.length;
        while(l<=r){
            int mid = (l+r)/2;
            ans = Math.max(ans, Math.min(citations[mid], n-mid));
            if(citations[mid]<=n-mid){
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return ans;
    }
}