class Solution {
    // It is based on that there can be only 1 sequence for each count of number
    public int consecutiveNumbersSum(int n) {
        int ans = 1, k=2;
        // kx + k(k-1)/2 = n;
        while(true){
            int i = (k*(k-1))/2;
            if(n-i<=0) break;
            if((n-i)%k==0) {
                ans++;
            }
            k++;
        }
        return ans;
    }


}