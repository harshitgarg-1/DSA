class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(i>=firstLen-1){
                if(i>0) left[i] = Math.max(left[i-1],sum);
                else left[i] = sum;
                sum -= nums[i-firstLen+1];
            }
        }
        sum=0;
        for(int i=n-1;i>=0;i--){
            sum+=nums[i];
            if(n-i>=firstLen){
                if(i<n-1) right[i] = Math.max(right[i+1],sum);
                else right[i] = sum;
                sum -= nums[i+firstLen-1];
            }
        }
        sum=0;
        int ans = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(i>=secondLen-1){
                int max = 0;
                if(i-secondLen>=0){
                    max = Math.max(max, left[i-secondLen]);
                }
                if(i<n-1){
                    max = Math.max(max,right[i+1]);
                }
                ans = Math.max(ans, sum+max);
                sum -= nums[i-secondLen+1];
            }
        }
        return ans;
    }
}