class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int start = 0, n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==key){
                for(int j = Math.max(start, i-k);j<=Math.min(i+k, n-1);j++){
                    ans.add(j);
                    start=j;
                }
                start++;
            }
        }
        return ans;
    }
}