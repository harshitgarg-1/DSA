class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        generate(num, 0, 0, target, "", ans, 0);
        return ans;
    }
    public void generate(String s, int index, long sum, int target, String curr, List<String> ans, long prev){
        if(index == s.length()){
            if(sum==target) ans.add(curr);
            return;
        }
        for(int i=index;i<s.length();i++){
            if(i != index && s.charAt(index) == '0') break;
            long no = Long.parseLong(s.substring(index, i + 1));
            if(index==0){
                generate(s, i+1, no, target, ""+no, ans, no);
                continue;
            }
            generate(s, i+1, sum+no, target, curr+"+"+no, ans, no);
            generate(s, i+1, sum-no, target, curr+"-"+no, ans, -1*no);
            generate(s, i+1, sum-prev+(prev*no), target, curr+"*"+no, ans, prev*no);
        }
    }
}