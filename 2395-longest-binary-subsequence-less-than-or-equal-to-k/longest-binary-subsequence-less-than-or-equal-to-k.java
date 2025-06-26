class Solution {
    public int longestSubsequence(String s, int k) {
        int ans = 0, n = s.length(), curr=0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='0') ans++;
            else {
                if(curr+Math.pow(2,n-1-i)<=k){
                    ans ++;
                    curr += Math.pow(2,n-1-i);
                }
            }
        }
        return ans;
    }
}