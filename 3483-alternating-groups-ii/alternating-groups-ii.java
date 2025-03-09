class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int i=0, j=0, n=colors.length, ans=0;
        while(j<=n+k-2){
            if(j!=0 && colors[j%n]==colors[(j-1)%n]){
                i=j;
                j++;
            } else {
                if(j-i+1==k) {
                    ans++;
                    i++;
                }
                j++;
            }
            
        }
        return ans;
    }
}