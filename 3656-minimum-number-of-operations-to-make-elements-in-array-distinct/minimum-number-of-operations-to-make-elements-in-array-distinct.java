class Solution {
    public int minimumOperations(int[] nums) {
        int remove = -1;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                remove = Math.max(remove, hm.get(nums[i]));
            }
            hm.put(nums[i], i);
        }
        return (remove+3)/3;
    }
}