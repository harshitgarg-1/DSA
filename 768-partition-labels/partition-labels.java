class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] arr = new int[30];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = arr[s.charAt(0)-'a'];

        for(int i=0;i<s.length();i++){
            end = Math.max(end, arr[s.charAt(i)-'a']);
            if(end==i){
                ans.add(end-start+1);
                start = i+1;
            }
        }
        return ans;
        
    }
}