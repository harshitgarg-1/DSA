class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int tc=0;
        int fc=0;
        int len=0;
        int max=0;
        int left=0;
        char[] a = answerKey.toCharArray();

        for(int i=0 ; i<a.length ; i++){
            if(a[i]=='T') tc++;
            else fc++;
            if(Math.min(tc,fc)<=k){
                len=i-left+1;
                max=Math.max(max,len);
            }
            else{
                if(a[left]=='T') tc--;
                else fc--;
                left++;
            }
        }return max;
    }
}