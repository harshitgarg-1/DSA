class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int l=0, r=0, n = s.length(), ans=0, max=0;
        while(r<n) {
            int no = s.charAt(r)-'A';
            arr[no]+=1;
            max = Math.max(max, arr[no]);
            if(r-l+1-max>k) {
                arr[s.charAt(l)-'A']--;
                l++;
            }
            else {
                ans = Math.max(ans, r-l+1);
            }
            r++;
        }
        return ans;
    }
}