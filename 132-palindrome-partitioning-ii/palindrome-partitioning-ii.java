class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for(int i=n-1;i>=0;i--){
            int min = Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                if(isPalindrome(s, i, j)){
                    if(j==n-1) min = 0;
                    else min = Math.min(min, 1 + dp[j+1]);
                }
            }
            dp[i] = min;
        }
        return dp[0];   
    }
    

    static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}