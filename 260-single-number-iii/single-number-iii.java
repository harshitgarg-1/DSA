class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int x : nums){
            xor^=x;
        }
        int xor0=0, xor1=0, setBit=0;
        while((xor&(1<<setBit)) == 0){
            setBit++;
        }
        for(int x : nums){
            if(((x>>setBit)&1)==0){
                xor0^=x;
            } else {
                xor1^=x;
            }
        }
        return new int[]{xor0, xor1};
    }
}