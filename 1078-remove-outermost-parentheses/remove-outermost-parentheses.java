class Solution {
    public String removeOuterParentheses(String s) {
        String ans = "";
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') {
                count++;
                if(count==1)continue;
            } else {
                count--;
                if(count==0) continue;
            }
            ans += s.charAt(i);

        }
        return ans;
    }
}