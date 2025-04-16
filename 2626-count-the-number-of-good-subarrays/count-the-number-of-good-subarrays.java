class Solution {
    public long countGood(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int left=0, n = nums.length;
        long ans = 0, pair=0;
        for(int right=0;right<n;right++){
            pair += hm.getOrDefault(nums[right], 0);
            hm.put(nums[right], hm.getOrDefault(nums[right], 0)+1);
            while(pair>=k){
                ans += (n-right);
                pair = pair - hm.get(nums[left]) +1;
                hm.put(nums[left], hm.get(nums[left]) -1);
                left++;
            }
        }
        return ans;
    }
}