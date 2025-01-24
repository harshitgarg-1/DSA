class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length, l=0;
        int r = n-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(arr[mid]-mid-1 >=k) r = mid-1;
            else l = mid+1;
        }

        return k+r+1;
    }
}