class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] present = new boolean[26];
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            lastIndex.put(s.charAt(i), i);
        }
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(present[c-'a']) continue;
            while(!st.isEmpty() && st.peek()>c && lastIndex.get(st.peek())>i){
                char curr = st.pop();
                present[curr-'a'] = false;
            }
            st.push(c);
            present[c-'a'] = true;
        }
        String ans = "";
        while(!st.isEmpty()){
            ans = st.pop() + ans;
        }
        return ans;
    }
}