class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] val = new int[n];
        for(int i=0;i<n;i++){
            String word = words[i];
            int curr = 0;
            for(char c : word.toCharArray()){
                curr |= 1<<(c-'a');
            }
            val[i] = curr;
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((val[i]&val[j])==0 && words[i].length()*words[j].length()>ans){
                    ans = words[i].length()*words[j].length();
                }
            }
        }
        return ans;
    }
}