class Solution {
    public int repeatedStringMatch(String A, String B) {
        int q = 1;
        StringBuilder S = new StringBuilder(A);
        for (; S.length() < B.length(); q++) S.append(A);
        if (checkSubstring(S.toString(), B)) return q;
        S.append(A);
        if (checkSubstring(S.toString(), B)) return q+1;
        return -1;
    }
    public boolean checkSubstring(String s, String target){
        int mod = 100000;
        int m = target.length();
        int n = s.length();
        int pov = 1;
        for(int i=0;i<m;i++){
            pov = (pov*31)%mod;
        }
        int targetHash = 0;
        for(char c : target.toCharArray()){
            targetHash = (targetHash*31 + c)%mod;
        }
        int currHash = 0;
        for(int i=0;i<n;i++){
            currHash = (currHash*31 + s.charAt(i))%mod;
            if(i>=m){
                currHash = currHash - (pov*s.charAt(i-m))%mod;
            }
            if (currHash < 0) currHash += mod;
            if(i>=m-1){
                if(currHash == targetHash && s.substring(i - m + 1, i + 1).equals(target)){
                    return true;
                }
            }
        }
        return false;
    }
}