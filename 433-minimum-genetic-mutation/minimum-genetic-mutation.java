class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> hs = new HashSet<>();
        for(String word : bank){
            hs.add(word);
        }
        if(!hs.contains(endGene)) return -1;
        Queue<String> q = new LinkedList<>();
        q.add(startGene);
        int ans = 0;
        while(!q.isEmpty()){
            int n = q.size();
            while(n>0){
                String s = q.poll();
                if(s.equals(endGene)==true){
                    return ans;
                }
                char [] chararray={'A','C','G','T'};
                for(int i=0;i<s.length();i++){
                    for(char ch :chararray){
                        char []replacedchararray = s.toCharArray();
                        replacedchararray[i]=ch;
                        String replacedword = new String(replacedchararray);
                        if(hs.contains(replacedword)){
                            q.add(replacedword);
                            hs.remove(replacedword);
                        }
                    }
                }
                n--;
            }
            ans++;
        }
        return -1;
    }
}