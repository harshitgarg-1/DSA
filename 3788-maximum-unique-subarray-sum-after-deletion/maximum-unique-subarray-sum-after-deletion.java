class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE, sum = -1;
        for (int right = 0; right < nums.length; right++) {
            if (!set.contains(nums[right]) && nums[right]>=0) {
                if(sum==-1) sum = 0;
                set.add(nums[right]);
                sum += nums[right];
            }
            max = Math.max(max, nums[right]);
        }
        return sum == -1 ? max : sum;
    }

}