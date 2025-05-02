class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] left = new int[n];
        int l = 1000000;
        for(int i=n-1;i>=0;i--){
            if(dominoes.charAt(i)=='L') l = 0;
            else if(dominoes.charAt(i)=='R') l = 1000000;
            else if(l<1000000) l++;
            left[i] = l;
        }
        // for(int i=0;i<n;i++){
        //     System.out.println(left[i]);
        // }
        String ans = "";
        int r = 1000000;
        for(int i=0;i<n;i++){
            if(dominoes.charAt(i)=='R') r = 0;
            else if(dominoes.charAt(i)=='L') r = 1000000;
            else if(r<1000000) r++;

            if(left[i]==r) ans += ".";
            else if(left[i]>r) ans += "R";
            else ans += "L";
        }
        return ans;
    }
}