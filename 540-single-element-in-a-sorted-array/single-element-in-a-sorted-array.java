class Solution {
    public int singleNonDuplicate(int[] nums) {
        int ans, l=0, r=nums.length-1, n=nums.length-1;
        if(n==0) return nums[0];
        while(l<=r){
            int mid = (l+r)/2;
            //System.out.println(mid);
            if(mid==0 && nums[mid]!=nums[1]) return nums[0];
            if(mid==n && nums[mid]!=nums[mid-1]) return nums[n];
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]) return nums[mid];
            if(mid%2==0){
                if(nums[mid]==nums[mid+1]) l=mid+1;
                else r=mid-1;
            } else {
                if(nums[mid]==nums[mid-1]) l=mid+1;
                else r=mid-1;
            }
        }
        return -1;
    }
}