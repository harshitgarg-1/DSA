class Solution {
    public int maximumGroups(int[] grades) {
        int ans = 0;
        int taken = 1;
        while(taken<=grades.length){
            ans ++;
            taken += ans+1;
        }
        return ans;
    }
}