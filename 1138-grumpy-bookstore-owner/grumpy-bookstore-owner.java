class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0, n = customers.length, max=0, curr=0;
        for(int i=0;i<n;i++){
            if(grumpy[i]==0) ans += customers[i];
            else curr+=customers[i];
            if(i>=minutes-1){
                max = Math.max(max, curr);
                if(grumpy[i-minutes+1]==1){
                    curr-=customers[i-minutes+1];
                }
            }
        }
        return ans+max;
    }
}