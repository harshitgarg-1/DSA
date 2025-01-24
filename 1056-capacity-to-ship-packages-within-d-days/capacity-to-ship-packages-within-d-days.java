class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length, l = Integer.MAX_VALUE, r = 0, ans = 0;
        for(int i=0;i<n;i++){
            l = Math.min(l, weights[i]);
            r += weights[i];
        }
        while(l<=r){
            int mid = (l+r)/2;
            if(isPossible(weights, mid, days, n)){
                r=mid-1;
                ans = mid;
            } else {
                l = mid+1;
            }
        }
        return ans;
        
    }

    public boolean isPossible(int[] weights, int capacity, int days, int n){
        int reqDays = 1, sum=0;
        for(int i=0;i<n;i++){
            if(weights[i]>capacity) return false;
            if(sum+weights[i]>capacity){
                reqDays++;
                sum = weights[i];
            } else {
                sum += weights[i];
            }
        }
        return reqDays<=days;
    }
}