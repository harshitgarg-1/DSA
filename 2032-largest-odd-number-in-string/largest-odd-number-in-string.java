class Solution {
    public String largestOddNumber(String nums) {
        for(int i=nums.length()-1;i>=0;i--){
            if(Character.getNumericValue(nums.charAt(i))%2==1) return nums.substring(0,i+1);
        }
        return "";
        
    }
}