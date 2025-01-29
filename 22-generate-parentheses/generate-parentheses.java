class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n*2, 0, "", ans);
        return ans;
    }

    public void generate(int n, int l, String s, List<String> ans){
        if(n==0){
            ans.add(s);
            return;
        }
        if(l<n){
            generate(n-1, l+1, s + "(", ans);
        }
        if(l>0){
            generate(n-1, l-1, s+")", ans);
        }
    }
}