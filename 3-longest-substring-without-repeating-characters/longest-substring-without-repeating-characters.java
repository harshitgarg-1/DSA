class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int ans = 0, l=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(hm.containsKey(c)){
                l = Math.max(l, hm.get(c)+1);
            }
            ans = Math.max(ans, i-l+1);
            hm.put(c, i);
        }
        return ans;
    }
}