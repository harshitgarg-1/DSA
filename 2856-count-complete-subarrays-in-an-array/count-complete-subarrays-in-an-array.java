class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int l = 0;
        int N = nums.length;
        HashSet<Integer> dist = new HashSet<>();
        for (int num: nums) {
            dist.add(num);
        }
        int result = 0;
        int k = dist.size();
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int r = 0; r < N; r++) {
            freqMap.put(nums[r], freqMap.getOrDefault(nums[r], 0) + 1);
            while (freqMap.size() == k) {
                result += N - r;
                freqMap.put(nums[l], freqMap.get(nums[l]) - 1);
                if (freqMap.get(nums[l]) == 0)
                    freqMap.remove(nums[l]);   
                l++;
            }
        }

        return result;
    }
}