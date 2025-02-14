class Solution {
    public int lengthOfLIS(int[] nums) {
        // int n = nums.length;
        // int[] dp = new int[n];
        // Arrays.fill(dp, 1);
        // int ans = 1;
        // for(int i=1;i<n;i++){
        //     for(int j=0;j<i;j++){
        //         if(nums[i]>nums[j]){
        //             dp[i] = Math.max(dp[i], dp[j]+1);
        //         }
        //     }
        //     ans = Math.max(ans, dp[i]);
        // }
        return find(nums);
    }

    public int find(int[] nums){
        int n = nums.length;
        ArrayList<Integer> arr = new ArrayList<>();
        int ans = 1;
        arr.add(nums[0]);
        for(int i=1;i<n;i++){
            int index = bs(arr, nums[i]);
            if(index >= arr.size()) arr.add(nums[i]);
            else arr.set(index, nums[i]);
        }
        return arr.size();
    }

    public int bs(ArrayList<Integer> arr, int num){
        int l = 0, r = arr.size()-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(arr.get(mid)==num) return mid;
            else if(arr.get(mid)>num) r = mid-1;
            else l = mid+1;
        }
        return l;
    }
}