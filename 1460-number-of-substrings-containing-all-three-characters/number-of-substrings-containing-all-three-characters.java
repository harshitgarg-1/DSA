class Solution {
    public int numberOfSubstrings(String s) {
        int[] arr = new int[3];
        int ans = 0;
        arr[0]=-1;
        arr[1]=-1;
        arr[2]=-1;
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']=i;
            int min = Math.min(arr[0], Math.min(arr[1], arr[2]));
            ans += min+1;
        }
        return ans;
    }
}