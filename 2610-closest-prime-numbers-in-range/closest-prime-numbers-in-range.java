class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] prime = mark(right);
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int prev = -1;
        int diff = Integer.MAX_VALUE;
        for(int i=left;i<=right;i++){
            if(prime[i]==0){
                if(prev == -1) prev = i;
                else if(i-prev < diff){
                    ans[0] = prev;
                    ans[1] = i;
                    diff = i-prev;
                }
                prev = i;
            }
        }
        return ans;
    }
    public int[] mark(int right){
        int[] ans = new int[right+1];
        ans[1] = 1;
        for(int i=2;i<=right;i++){
            if(ans[i] != 1){
                int curr = i+i;
                while(curr<=right){
                    ans[curr] = 1;
                    curr+=i;
                }
            }
        }
        return ans;
    }
}