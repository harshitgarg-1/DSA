class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if(m>n) return findMedianSortedArrays(nums2, nums1);
        int l=0, r=m, totalLen = m+n, len = (m+n)/2;
        while(l<=r){
            int mid = (l+r)/2;
            int l1 = mid==0?Integer.MIN_VALUE:nums1[mid-1];
            int r1 = mid==m?Integer.MAX_VALUE:nums1[mid];
            int l2 = len-mid==0?Integer.MIN_VALUE:nums2[len-mid-1];
            int r2 = len-mid==n?Integer.MAX_VALUE:nums2[len-mid];
            if (l1 <= r2 && l2 <= r1) {
                if (totalLen % 2 == 1) return Math.min(r1, r2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) r = mid - 1;
            else l = mid + 1;
        }
        return 0;
        
    }
}