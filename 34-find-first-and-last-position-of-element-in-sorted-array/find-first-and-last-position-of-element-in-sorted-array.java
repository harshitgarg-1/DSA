class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = min(nums, target);
        int end = max(nums, target);
        return new int[]{start, end};
    }

    public int min(int[] arr, int k){
        int l =0, r = arr.length-1, ans = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(arr[mid]==k){
                r=mid-1;
                ans = mid;
            }
            else if(arr[mid]>k) r = mid-1;
            else l = mid+1;
        }
        return ans;
    }

    public int max(int[] arr, int k){
        int l =0, r = arr.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(arr[mid]>k) r = mid-1;
            else l = mid+1;
        }
        return r==-1 || arr[r]!=k ? -1:r;
    }
}