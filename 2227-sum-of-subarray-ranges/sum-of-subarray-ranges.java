class Solution {
    public long subArrayRanges(int[] nums) {
        return maxSum(nums) - minSum(nums);
    }

    public long maxSum(int[] nums){
        int n = nums.length;
        long sum = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i=0;i<=n;i++){
            if(st.peek()==-1) st.push(i);
            long val = i==n?Long.MAX_VALUE:nums[i];
            while(st.peek() != -1 && nums[st.peek()]<=val){
                int index = st.pop();
                sum += (long)nums[index]*(index-st.peek())*(i-index);
            }
            st.push(i);
        }
        return sum;
    }

    public long minSum(int[] nums){
        int n = nums.length;
        long sum = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i=0;i<=n;i++){
            if(st.peek()==-1) st.push(i);
            long val = i==n?Long.MIN_VALUE:nums[i];
            while(st.peek() != -1 && nums[st.peek()]>=val){
                int index = st.pop();
                sum += (long)nums[index]*(index-st.peek())*(i-index);
            }
            st.push(i);
        }
        return sum;
    }
}