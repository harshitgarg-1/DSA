class Solution {
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])) continue;
            if(nums[i] < k) return -1;
            if(nums[i] != k) ans++;
            set.add(nums[i]);
        }
        return ans;
    }
}
