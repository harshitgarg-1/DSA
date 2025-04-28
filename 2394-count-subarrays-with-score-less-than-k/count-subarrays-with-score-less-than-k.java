class Solution {
    public long countSubarrays(int[] nums, long k) {
        long sum = 0, ans = 0, total = 0;
        int n = nums.length, start=0;
        for(int i=0;i<n;i++){
            total += (i+1);
            sum += nums[i];
            while(i>=start && sum*(i-start+1)>=k){
                ans += n-i;
                sum -= nums[start];
                start++;
            }
        }
        //System.out.println(total);
        return total-ans;

    }
}