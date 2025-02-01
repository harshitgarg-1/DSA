class Solution {
    public int trap(int[] height) {
        int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE, l = 0, r = height.length-1, ans=0;
        while(l<=r){
            if(height[l]<height[r]){
                left = Math.max(left, height[l]);
                ans += left - height[l];
                l++;
            } else {
                right = Math.max(right, height[r]);
                ans += right-height[r];
                r--;
            }
        }
        return ans;
    }
}