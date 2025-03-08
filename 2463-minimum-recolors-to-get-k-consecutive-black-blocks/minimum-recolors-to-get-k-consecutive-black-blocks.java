class Solution {
    public int minimumRecolors(String blocks, int k) {
        int w = 0;
        int j=0, n=blocks.length();
        while(j<k){
            if(blocks.charAt(j)=='W') w++;
            j++;
        }
        int ans = w;
        while(j<n){
            if(blocks.charAt(j)=='W') w++;
            if(blocks.charAt(j-k)=='W') w--;
            ans = Math.min(ans, w);
            j++;
        }
        return ans;
    }
}