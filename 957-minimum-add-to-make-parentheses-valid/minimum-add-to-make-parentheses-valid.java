class Solution {
    public int minAddToMakeValid(String s) {
        int ans = 0, count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
            } else {
                count--;
            }
            if(count<0){
                count=0;
                ans++;
            }
        }
        ans+=count;
        return ans;
    }
}