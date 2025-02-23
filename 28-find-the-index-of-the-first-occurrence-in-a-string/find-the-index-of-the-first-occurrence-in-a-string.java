class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int[] pi = new int[n];
        int i=1, j=0;
        while(i<n){
            if(needle.charAt(i)==needle.charAt(j)){
                j++;
                pi[i] = j;
                i++;
            }
            else if(j>0){
                j=pi[j-1];
                continue;
            } else {
                i++;
            }
        }
        i=0;
        j=0;
        while(i<m){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                if(j==n) return i-n;
            }
            else {
                if (j != 0)
                    j = pi[j-1];
                else
                    i++;
            }
        }
        return -1;
    }
}