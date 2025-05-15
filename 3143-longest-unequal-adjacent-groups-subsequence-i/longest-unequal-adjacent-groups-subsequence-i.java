class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        int prev = groups[0];
        int n = words.length;
        ans.add(words[0]);
        for(int i=1;i<n;i++){
            if(prev != groups[i]){
                ans.add(words[i]);
                prev = 1-prev;
            }
        }
        return ans;
    }
}
