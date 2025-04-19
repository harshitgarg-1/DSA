class Solution {
    // 0 1 4 4 5 7
    public long countFairPairs(int[] nums, int lower, int upper) {
            Arrays.sort(nums);
            long ans = 0;
            for(int i=0;i<nums.length-1;i++){
                int l = lower(nums, i+1, lower-nums[i]);
                int r = upper(nums, i+1, upper-nums[i]);
                if(l<=r) ans += r-l+1;
                //System.out.println(l + " " + r);
            }
            return ans;
    }
    public int lower(int[] arr, int start, int target){
        int end = arr.length-1, ans = arr.length;
        while(start<=end){
            int mid = (start+end)/2;
            if(target<=arr[mid]){
                ans = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return ans;
    }
    public int upper(int[] arr, int start, int target){
        int end = arr.length-1, ans = start-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(target>=arr[mid]){
                ans = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return ans;
    }
}