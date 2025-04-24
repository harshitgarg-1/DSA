class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<=1) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int n = nums.length;
        int[] minVal = new int[n-1];
        int[] maxVal = new int[n-1];
        Arrays.fill(minVal, Integer.MAX_VALUE);
        Arrays.fill(maxVal, Integer.MIN_VALUE);
        int gap = ((max - min)/(n - 1));
        for(int num : nums){
            if (num == min || num == max) continue;
            int i = (num-min)/(gap+1);
            minVal[i] = Math.min(num, minVal[i]);
            maxVal[i] = Math.max(num, maxVal[i]);
        }
        int ans = 0;
        int prev = min;
        for(int i=0;i<n-1;i++){
            if (minVal[i] == Integer.MAX_VALUE && maxVal[i] == Integer.MIN_VALUE)
            continue;
            ans = Math.max(ans, minVal[i]-prev);
            prev = maxVal[i];
        }
        ans = Math.max(ans, max-prev);
        return ans;
    }
}