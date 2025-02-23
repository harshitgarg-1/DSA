class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] pi = new int[n];
        int max = 0;
        String ans = "";
        int i=1, j=0;
        while(i<n){
            if(s.charAt(i)==s.charAt(j)){
                j++;
                pi[i]=j;
                i++;
            } else {
                if(j>0){
                    j = pi[j-1];
                } else {
                    i++;
                }
            }
        }
        return s.substring(n-pi[n-1], n);
    }

}