class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        generate(s, 0, new ArrayList<>(), ans);
        return ans;
    }
    public void generate(String s, int i, List<String> curr, List<List<String>> ans){
        if(i==s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int j=i;j<s.length();j++){
            if(isPalindrome(s, i, j)){
                curr.add(s.substring(i,j+1));
                generate(s, j+1, curr, ans);
                curr.remove(curr.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int l, int r){
        while(l<r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}