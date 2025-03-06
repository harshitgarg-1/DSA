class Solution {
    public int countNumbersWithUniqueDigits(int n) {
       if(n==0) return 1;
       if(n>9) n = 9;
       int res = 10;
       int count = 9;
       int prev = 9;
       while(n>1){
        prev = prev*count;
        count--;
        res += prev;
        n--;
       }
       return res;
    }
}