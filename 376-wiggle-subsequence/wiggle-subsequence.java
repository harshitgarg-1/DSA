class Solution {
    public int wiggleMaxLength(int[] nums) {
        return nums.length - Math.min(getDel(Integer.MAX_VALUE, 1, nums), getDel(Integer.MIN_VALUE, 0, nums));
    }

    public int getDel(int prev, int incr, int[] nums){
        int del = 0;
        for(int num : nums) {
            if((incr == 1 && num >= prev) || (incr == 0 && num <= prev)){
                del++;
            }
            else {
                incr = 1-incr;
            }
            prev = num;
        }
        return del;
    }
}