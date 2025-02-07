class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>();
        for(String word : wordList) st.add(word);
        Queue<String> q = new LinkedList<>();
        if(beginWord.equals(endWord)) return 1;
        q.add(beginWord);
        int ans = 1;
        while(!q.isEmpty()){
            ans++;
            int n = q.size();
            while(n>0){
                char[] curr =  q.poll().toCharArray();
                for(int i=0;i<curr.length;i++){
                    for(int j=0;j<26;j++){
                        char c = curr[i];
                        curr[i] = (char)('a'+j);
                        String word = new String(curr);
                        if(st.contains(word)){
                            //System.out.println(word + " " + ans);
                            if(word.equals(endWord)) return ans;
                            q.add(word);
                            st.remove(word);
                        }
                        curr[i] = c;
                    }
                }
                n--;
            }
        }
        return 0;
    }
}