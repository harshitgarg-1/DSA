class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i=1;i<=n;i++){
            if(p.charAt(i-1)=='*') dp[i] = dp[i-1];
            else dp[i] = false;
        }
        for(int i=1;i<=m;i++){
            boolean[] temp = new boolean[n+1];
            temp[0] = false;
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    temp[j] = dp[j-1];
                } else if(p.charAt(j-1)=='*') {
                    temp[j] = dp[j]||temp[j-1];
                } else {
                    temp[j] = false;
                }
            }
            dp = temp;
        }
        return dp[n];
    }
}